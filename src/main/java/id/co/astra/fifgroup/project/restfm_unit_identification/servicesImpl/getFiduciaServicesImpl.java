package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.resultDataFiduciadto;
import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.getFiduciaGateway;
import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.getTokenGateway;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.motif_LogRepo;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.getFiduciaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

@Service("getFiduciaServicesImpl")
public class getFiduciaServicesImpl implements getFiduciaServices {

    @Value("${url.APIRepoList}")
    private String path;

    @Value("${reqId.repo}")
    private String reqId;

    @Value("${source.repo}")
    private String source;

    @Value("${url.APITokenRepo}")
    private String urlRepo;

    @Value("${repo.clientId}")
    private String clientIdRepo;

    @Value("${repo.clientSecret}")
    private String clientSecretRepo;

    @Value("${repo.grantType}")
    private String grantTypeRepo;

    @Value("${repo.username}")
    private String usernameRepo;

    @Value("${repo.password}")
    private String passwordRepo;

    @Value("${code.FiduciaRepo}")
    private String categoryFiduciaRepo;

    @Value("${ws.createby}")
    private String createby;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private motif_LogRepo motifLogRepo;

    @Autowired
    public motifTrnServiceImpl motifTrn;

    @PersistenceContext
    private EntityManager entitiyManager;

    @Autowired
    public motifLogServiceImpl motifLog;

    @Autowired
    public getFiduciaGateway getFiduciaGateway;

    @Autowired
    public getTokenGateway getTokenGateway;

    public resultDataFiduciadto dataFiducia;

    private HttpStatus StatusResponse;

    private ObjectMapper mapper = new ObjectMapper();
    private RestTemplate restTemplate = new RestTemplate();

    private String flag;

    private String generateToken;

    @Override
    public ResponseEntity getfiducia(String contractNo, String requestBy) {

        responseFiduciaObj responseObj = new responseFiduciaObj();
        String fileId = "";
        String mime = "";
        resultDataFiduciadto dataFiducia = new resultDataFiduciadto();


        if (contractNo.isEmpty()) {
            responseObj.setRespHttpMessage("Contract No can't be null!");
            responseObj.setRespHttpCode("400");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else if (requestBy.isEmpty()) {
            responseObj.setRespHttpMessage("Request By can't be null!");
            responseObj.setRespHttpCode("400");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
            //Get Appl No
            String applNo = getApplNo(contractNo);
            if (applNo.equals("Not Found")) {
                responseObj.setRespHttpCode("404");
                responseObj.setRespHttpMessage("Appl No Not Found!");
                StatusResponse = HttpStatus.NOT_FOUND;
            } else {
                //Get ID Certificate Fiducia
//                dataFiducia = getId(contractNo,applNo,requestBy);
                try {
//            if(generateToken == null){
                    generateToken = getTokenGateway.getToken();
//            }
                    String dataJson = getFiduciaGateway.getId(applNo, requestBy, generateToken);

                    JsonNode jsonNode = mapper.readTree(dataJson);
                    if (!jsonNode.findValue("respCode").asText().equals("404")) {
                        JsonNode file = jsonNode.findValue("files");
                        for (JsonNode obj : file) {
                            if (obj.findValue("category").asText().equals(categoryFiduciaRepo)) {
//                    if(obj.findValue("category").asText().equals("J32")){
                                fileId = obj.findValue("id").asText();
                                mime = obj.findValue("mime").asText();
                            }
                        }
                        if (fileId.isEmpty()) {
                            flag = "Id File Fiducia Not Found in Repo!";
                            motifLog.insertLogMotif(contractNo, applNo, "Get ID File Fiducia", "Failed", "ID File Fiducia Not Found in Repo!", requestBy);
                        } else {
                            flag = "Found";
                            dataFiducia.setIdFiducia(fileId);
                            dataFiducia.setMime(mime);
                            motifLog.insertLogMotif(contractNo, applNo, "Get ID File Fiducia", "Success", "ID File Fiducia : " + fileId, requestBy);
                        }
                    } else {
                        flag = "Appl No Not Found in Repo!";
                        motifLog.insertLogMotif(contractNo, applNo, "Get ID File Fiducia", "Failed", "Appl No Not Found in Repo!", requestBy);
                    }
                } catch (Exception e) {
                    flag = e.getMessage();
                    motifLog.insertLogMotif(contractNo, applNo, "Get ID File Fiducia", "Failed", "Error : " + e.getMessage(), requestBy);
                }
                if (flag.equals("Found")) {
                    responseObj.setRespHttpCode("200");
                    responseObj.setRespHttpMessage("Sucessfully");
                    responseObj.setData(dataFiducia);
                    StatusResponse = HttpStatus.OK;
                    motifTrn.insertTrnMotif(contractNo, "", "", "Get ID File Fiducia", "Success", "ID File Fiducia : " + dataFiducia.getIdFiducia(), "", createby, requestBy);
                } else if (flag.equals("Id File Fiducia Not Found in Repo!")) {
                    responseObj.setRespHttpCode("404");
                    responseObj.setRespHttpMessage(flag);
                    responseObj.setData(dataFiducia);
                    StatusResponse = HttpStatus.NOT_FOUND;
                } else if (flag.equals("Appl No Not Found in Repo!")) {
                    responseObj.setRespHttpCode("404");
                    responseObj.setRespHttpMessage(flag);
                    responseObj.setData(dataFiducia);
                    StatusResponse = HttpStatus.NOT_FOUND;
                } else {
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage(flag);
                    StatusResponse = HttpStatus.BAD_REQUEST;
                }
            }
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }

    //Get APPL NO
    @Transactional
    private String getApplNo(String contractNo) {
        String applNo = "";
        try {

            String applNoo = motifLogRepo.queryStr(contractNo);
            applNo = applNoo.toString();

        } catch (Exception e) {
            applNo = "Not Found";
            motifLog.insertLogMotif(contractNo, "", "Get APPL NO", "Failed", "Appl No Not Found!", "Motif Mobile");
        }
        return applNo;
    }
}
