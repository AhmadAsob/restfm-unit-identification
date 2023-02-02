package id.co.astra.fifgroup.project.restfm_unit_identification.gateway;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.sendEmaildto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

@Component
public class sendEmailGateway {

    @Value("${email.from}")
    private String emailFrom;
    @Value("${email.passwd}")
    private String emailPasswd;
    @Value("${url.APISendEmail}")
    private String urlEmail;

    public ResponseEntity<String> sendEmail(sendEmaildto param) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Content-Type", "multipart/form-data");

        MultiValueMap<String, Object> dataMap = mapString(param);
        HttpEntity<?> httpEntity = new HttpEntity<Object>(dataMap, requestHeaders);
        return restTemplate.exchange(urlEmail, HttpMethod.POST, httpEntity, String.class);
    }

    //Set data
    public MultiValueMap mapString(sendEmaildto dataEmail) {
        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<>();
        dataMap.add("from", emailFrom);
        dataMap.add("paswd", emailPasswd);
        dataMap.add("subject", dataEmail.getSubject());
        dataMap.add("emailbody", dataEmail.getEmailBody());
        dinamicLoop("to", dataEmail.getTo(), null, dataMap);
        dinamicLoop("cc", dataEmail.getCc(), null, dataMap);

        if (dataEmail.getAttachName() == null && dataEmail.getAttachBytes() == null) {
            dataMap.add("attachName", null);
            dataMap.add("attachBytes", null);
        } else {
            dinamicLoop("attachName", dataEmail.getAttachName(), null, dataMap);
            dinamicLoop("attachBytes", null, dataEmail.getAttachBytes(), dataMap);
        }

        return dataMap;
    }

    //set Data Loop
    public String dinamicLoop(String key, String[] stringValue, MultipartFile[] attachFile, MultiValueMap dataMap) {
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
