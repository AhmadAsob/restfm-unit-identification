package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.sendEmaildto;
import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.RemLogMotifErrGateway;
import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.sendEmailGateway;
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

    @Autowired
    public sendEmailGateway gateway;

    @Autowired
    private RemLogMotifErrGateway remLogMotifErrGateway;

    @Override
    public ResponseEntity sendEmail(sendEmaildto dataEmail) {

        responseObj responseObj = new responseObj();
        RestTemplate restTemplate = new RestTemplate();

        if(dataEmail.getSubject().isEmpty()){
            responseObj.setRespHttpMessage("Email Subject can't be null!");
            responseObj.setRespHttpCode("400");
            remLogMotifErrGateway.insertLogRemLogMotifErr(dataEmail, convertObjectToJson(responseObj, true), "POST_EMAIL", "Can't send Email");
            StatusResponse = HttpStatus.BAD_REQUEST;
        }else if(dataEmail.getTo().length == 0){
            responseObj.setRespHttpMessage("To can't be null!");
            responseObj.setRespHttpCode("400");
            remLogMotifErrGateway.insertLogRemLogMotifErr(dataEmail, convertObjectToJson(responseObj, true), "POST_EMAIL", "Can't send Email");
            StatusResponse = HttpStatus.BAD_REQUEST;
        }else if(dataEmail.getEmailBody().isEmpty()){
            responseObj.setRespHttpMessage("Email Body can't be null!");
            responseObj.setRespHttpCode("400");
            remLogMotifErrGateway.insertLogRemLogMotifErr(dataEmail, convertObjectToJson(responseObj, true), "POST_EMAIL", "Can't send Email");
            StatusResponse = HttpStatus.BAD_REQUEST;
        }else if(dataEmail.getRequestBy().isEmpty()){
            responseObj.setRespHttpMessage("Request By can't be null!");
            responseObj.setRespHttpCode("400");
            remLogMotifErrGateway.insertLogRemLogMotifErr(dataEmail, convertObjectToJson(responseObj, true), "POST_EMAIL", "Can't send Email");
            StatusResponse = HttpStatus.BAD_REQUEST;
        }else if(dataEmail.getAttachName() == null && dataEmail.getAttachName() != null ){
            responseObj.setRespHttpMessage("AttachName or AttachBytes can't be null!");
            responseObj.setRespHttpCode("400");
            remLogMotifErrGateway.insertLogRemLogMotifErr(dataEmail, convertObjectToJson(responseObj, true), "POST_EMAIL", "Can't send Email");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else if(dataEmail.getAttachName() != null && dataEmail.getAttachName() == null) {
            responseObj.setRespHttpMessage("AttachName or AttachBytes can't be null!");
            responseObj.setRespHttpCode("400");
            remLogMotifErrGateway.insertLogRemLogMotifErr(dataEmail, convertObjectToJson(responseObj, true), "POST_EMAIL", "Can't send Email");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
            try{
                ResponseEntity<String> model = gateway.sendEmail(dataEmail);
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
                if(dataEmail.getAttachBytes() != null) {
                    Delete(dataEmail.getAttachBytes());
                }
            }catch (Exception e){
                if(dataEmail.getAttachName() == null && dataEmail.getAttachBytes() != null) {
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage("AttachName and AttachBytes one of them cannot be null");
                    StatusResponse = HttpStatus.BAD_REQUEST;
                } else if(dataEmail.getAttachName() != null && dataEmail.getAttachBytes() == null) {
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage("AttachName and AttachBytes one of them cannot be null");
                    StatusResponse = HttpStatus.BAD_REQUEST;
                } else {
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage(e.getMessage());
                    StatusResponse = HttpStatus.BAD_REQUEST;
                }
                motifLog.insertLogMotif("","","Send Email","Failed","Failed Send email : " + e.getMessage(),dataEmail.getRequestBy());
            }
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }

    //method delete file
    private void Delete(MultipartFile[] data) {
        for (MultipartFile dataFile : data) {
            File tempData = new File(dataFile.getOriginalFilename());
            tempData.delete();
        }
    }


    private String convertObjectToJson(Object data, boolean isIncludeNull) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (isIncludeNull) {
            gsonBuilder.serializeNulls();
        }
        Gson gson = gsonBuilder.create();
        return gson.toJson(data);
    }


}

