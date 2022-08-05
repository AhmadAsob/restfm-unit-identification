package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.resultDataFiduciadto;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.motif_LogRepo;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.getFiduciaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    public resultDataFiduciadto dataFiducia;

    private HttpStatus StatusResponse;

    private ObjectMapper mapper = new ObjectMapper();
    private RestTemplate restTemplate = new RestTemplate();

    private String flag;

    private String generateToken;

    @Override
    public ResponseEntity getfiducia(String contractNo, String requestBy) {

        responseFiduciaObj responseObj = new responseFiduciaObj();

        if(contractNo.isEmpty()){
            responseObj.setRespHttpMessage("Contract No can't be null!");
            responseObj.setRespHttpCode("400");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else if(requestBy.isEmpty()){
            responseObj.setRespHttpMessage("Request By can't be null!");
            responseObj.setRespHttpCode("400");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else{
            //Get Appl No
            String applNo = getApplNo(contractNo);
            if(applNo.equals("Not Found")){
                responseObj.setRespHttpCode("404");
                responseObj.setRespHttpMessage("Appl No Not Found!");
                StatusResponse = HttpStatus.NOT_FOUND;
            } else{
                //Get ID Certificate Fiducia
                dataFiducia = getId(contractNo,applNo,requestBy);
                if(flag.equals("Found")){
                    responseObj.setRespHttpCode("200");
                    responseObj.setRespHttpMessage("Sucessfully");
                    responseObj.setData(dataFiducia);
                    StatusResponse = HttpStatus.OK;
                    motifTrn.insertTrnMotif(contractNo,"", "","Get ID File Fiducia", "Success","ID File Fiducia : " + dataFiducia.getIdFiducia(),"", createby, requestBy);
                }else if(flag.equals("Id File Fiducia Not Found in Repo!")){
                    responseObj.setRespHttpCode("404");
                    responseObj.setRespHttpMessage(flag);
                    responseObj.setData(dataFiducia);
                    StatusResponse = HttpStatus.NOT_FOUND;
                }else if(flag.equals("Appl No Not Found in Repo!")){
                    responseObj.setRespHttpCode("404");
                    responseObj.setRespHttpMessage(flag);
                    responseObj.setData(dataFiducia);
                    StatusResponse = HttpStatus.NOT_FOUND;
                }else {
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
        try{
            String queryStr = "SELECT APPL_NO " +
                    "FROM ACCTMGMT.AR_TRN_SUM_CONTRACTS " +
                    "WHERE CONTRACT_NO = :contractNo";
            Query query = entitiyManager.createNativeQuery(queryStr);
            query.setParameter("contractNo", contractNo);

            applNo = query.getSingleResult().toString();
        } catch (Exception e){
            applNo = "Not Found";
            motifLog.insertLogMotif(contractNo, "", "Get APPL NO", "Failed", "Appl No Not Found!", "Motif Mobile");
        }
        return applNo;
    }

    @Scheduled(fixedDelay = 1500000) //milisecond
    private String getToken() throws JsonProcessingException {
        String access_token = "";
        try{
            HttpHeaders keycloakHeaders = new HttpHeaders();
            keycloakHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            keycloakHeaders.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("grant_type",grantTypeRepo);
            map.add("client_id",clientIdRepo);
            map.add("client_secret",clientSecretRepo);
            map.add("password",passwordRepo);
            map.add("username",usernameRepo);
            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, keycloakHeaders);

            String tokenget = restTemplate.exchange(urlRepo,HttpMethod.POST, entity , String.class).getBody();

            JsonNode rootNode = mapper.readTree(tokenget);
            access_token = rootNode.get("access_token").asText();
            generateToken = "Bearer " + access_token;
        }catch (Exception e){
            motifLog.insertLogMotif("","","Get Token API Repo", "Failed", "Error : " + e.getMessage(),"");
        }
        return access_token;
    }

    //get ID Fiducia
    private resultDataFiduciadto getId(String contractNo, String applNo, String requestBy){
        String fileId = "";
        String mime = "";
        resultDataFiduciadto dataFiducia = new resultDataFiduciadto();

        try {
            if(generateToken == null){
                getToken();
            }

            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.setContentType(MediaType.APPLICATION_JSON);
            httpHeaders.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            httpHeaders.add(HttpHeaders.AUTHORIZATION, generateToken);

            HttpEntity<?> httpEntity = new HttpEntity<Object>(httpHeaders);
            String dataJson = restTemplate.exchange(path,HttpMethod.POST,httpEntity,String.class, reqId,source,requestBy,applNo).getBody();

            JsonNode jsonNode = mapper.readTree(dataJson);
            if(!jsonNode.findValue("respCode").asText().equals("404")){
                JsonNode file = jsonNode.findValue("files");
                for (JsonNode obj: file){
                    if(obj.findValue("category").asText().equals(categoryFiduciaRepo)){
//                    if(obj.findValue("category").asText().equals("J32")){
                        fileId = obj.findValue("id").asText();
                        mime = obj.findValue("mime").asText();
                    }
                }
                if(fileId.isEmpty()){
                    flag = "Id File Fiducia Not Found in Repo!";
                    motifLog.insertLogMotif(contractNo,applNo,"Get ID File Fiducia", "Failed", "ID File Fiducia Not Found in Repo!", requestBy);
                } else{
                    flag = "Found";
                    dataFiducia.setIdFiducia(fileId);
                    dataFiducia.setMime(mime);
                    motifLog.insertLogMotif(contractNo,applNo,"Get ID File Fiducia", "Success", "ID File Fiducia : " + fileId, requestBy);
                }
            }else{
                flag = "Appl No Not Found in Repo!";
                motifLog.insertLogMotif(contractNo,applNo,"Get ID File Fiducia", "Failed", "Appl No Not Found in Repo!", requestBy);
            }
        } catch (Exception e) {
            flag = e.getMessage();
            motifLog.insertLogMotif(contractNo,applNo,"Get ID File Fiducia", "Failed", "Error : " + e.getMessage() , requestBy);
        }
        return dataFiducia;
    }
}
