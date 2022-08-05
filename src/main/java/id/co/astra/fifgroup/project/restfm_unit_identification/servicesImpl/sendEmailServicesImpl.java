package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.sendEmaildto;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.sendEmailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

@Service("sendEmailServicesImpl")
public class sendEmailServicesImpl implements sendEmailServices {

    @Value("${url.APISendEmail}")
    private String urlEmail;

    @Value("${email.from}")
    private String emailFrom;

    @Value("${email.passwd}")
    private String emailPasswd;

    @Value("${ws.createby}")
    private String createby;

    private HttpStatus StatusResponse;

    @Autowired
    public motifLogServiceImpl motifLog;

    @Autowired
    public motifTrnServiceImpl motifTrn;

    @Override
    public ResponseEntity sendEmail(sendEmaildto dataEmail) {

        responseObj responseObj = new responseObj();
        RestTemplate restTemplate = new RestTemplate();

        if(dataEmail.getSubject().isEmpty()){
            responseObj.setRespHttpMessage("Email Subject can't be null!");
            responseObj.setRespHttpCode("400");
            StatusResponse = HttpStatus.BAD_REQUEST;
        }else if(dataEmail.getTo().length == 0){
            responseObj.setRespHttpMessage("To can't be null!");
            responseObj.setRespHttpCode("400");
            StatusResponse = HttpStatus.BAD_REQUEST;
        }else if(dataEmail.getEmailBody().isEmpty()){
            responseObj.setRespHttpMessage("Email Body can't be null!");
            responseObj.setRespHttpCode("400");
            StatusResponse = HttpStatus.BAD_REQUEST;
        }else if(dataEmail.getRequestBy().isEmpty()){
            responseObj.setRespHttpMessage("Request By can't be null!");
            responseObj.setRespHttpCode("400");
            StatusResponse = HttpStatus.BAD_REQUEST;
        }else {
            try{
                HttpHeaders requestHeaders = new HttpHeaders();
                requestHeaders.set("Content-Type", "multipart/form-data");

                MultiValueMap<String, Object> dataMap = mapString(dataEmail);
                HttpEntity<?> httpEntity = new HttpEntity<Object>(dataMap, requestHeaders);
                ResponseEntity<String> model = restTemplate.exchange(urlEmail, HttpMethod.POST, httpEntity, String.class);
                if (model.getBody().equals("OK")) {
                    responseObj.setRespHttpCode("200");
                    responseObj.setRespHttpMessage("Sucessfully");
                    StatusResponse = HttpStatus.OK;
                    motifTrn.insertTrnMotif("","", "","Send Email","Success","Send Email success!","",createby,dataEmail.getRequestBy());
                } else {
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage(model.getBody());
                    StatusResponse = HttpStatus.BAD_REQUEST;
                    motifLog.insertLogMotif("","","Send Email","Failed","Failed Send email : " + model.getBody(),dataEmail.getRequestBy());
                }
                //Delete dataTemp
                Delete(dataEmail.getAttachBytes());
            }catch (Exception e){
                motifLog.insertLogMotif("","","Send Email","Failed","Failed Send email : " + e.getMessage(),dataEmail.getRequestBy());
            }
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }

    //Set data
    private MultiValueMap mapString(sendEmaildto dataEmail) {
        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<>();
        dataMap.add("from", emailFrom);
        dataMap.add("paswd", emailPasswd);
        dataMap.add("subject", dataEmail.getSubject());
        dataMap.add("emailbody", dataEmail.getEmailBody());
        dinamicLoop("to", dataEmail.getTo(), null, dataMap);
        dinamicLoop("cc", dataEmail.getCc(), null, dataMap);
        dinamicLoop("attachName", dataEmail.getAttachName(), null, dataMap);
        dinamicLoop("attachBytes", null, dataEmail.getAttachBytes(), dataMap);

        return dataMap;
    }

    //set Data Loop
    String dinamicLoop(String key, String[] stringValue, MultipartFile[] attachFile, MultiValueMap dataMap) {
        if (key == "cc" && stringValue == null) {
            dataMap.add(key, stringValue);
        } else {
            if (key != "attachBytes") {
                for (String kV : stringValue) {
                    dataMap.add(key, kV);
                }
            } else {
                for (MultipartFile dataFile : attachFile) {
                    Resource rc = new FileSystemResource(convert(dataFile));
                    dataMap.add("attachBytes", rc);
                }
            }
        }
        return "OK";
    }

    //method delete file
    private void Delete(MultipartFile[] data) {
        for (MultipartFile dataFile : data) {
            File tempData = new File(dataFile.getOriginalFilename());
            tempData.delete();
        }
    }

    //create local file
    private static File convert(MultipartFile file) {

        File convFile = new File(file.getOriginalFilename());
        try {
            convFile.createNewFile();
            FileOutputStream fos = new FileOutputStream(convFile);
            fos.write(file.getBytes());
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return convFile;
    }

}

