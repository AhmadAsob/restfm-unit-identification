//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.sendEmaildto;
//import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.sendEmailGateway;
//import id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl.motifLogServiceImpl;
//import id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl.motifTrnServiceImpl;
//import id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl.sendEmailServicesImpl;
//import org.json.JSONObject;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.*;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//import org.springframework.web.multipart.MultipartFile;
//
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ActiveProfiles("unittest")
//public class sendEmailServiceTest {
//
//    @Autowired
//    private sendEmailServicesImpl sendEmailServices;
//
//    @MockBean
//    sendEmailGateway gateway;
//
//    @Test
//    public void sendEmail_SubjectNull() throws Exception{
//
//        //Param input
//        JSONObject object = new JSONObject();
//        object.put("subject","");
//        object.put("emailBody","Try Send Email");
//        object.put("attachBytes","Test");
//        object.put("attachName","Data Test.pdf");
//        object.put("to","ahmadasob54@gmail.com");
//        object.put("requestBy","Mobile FMUI");
//
//
//
//        MultipartFile[] testAttachName = new MultipartFile[0];
//        String[] values = {"k"};
//        MultipartFile[] multiFile = testAttachName;
//
//        sendEmaildto input = new sendEmaildto();
//        input.setSubject("");
//        input.setEmailBody("Try Send Email");
//        input.setAttachBytes(multiFile);
//        input.setAttachName(values);
//        input.setTo(values);
//        input.setRequestBy("Mobile FMUI");
//
//        //Data out ext api
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("Email Subject can't be null!");
//
//        //Resp data ext api
//        ResponseEntity resp = sendEmailServices.sendEmail(input);
//
//        assertNotNull(resp);
//        assertEquals(resp.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//
//    }
//
//    @Test
//    public void sendEmail_ToNull() throws Exception{
//
//        //Param input
//        JSONObject object = new JSONObject();
//        object.put("subject","Test");
//        object.put("emailBody","Try Send Email");
//        object.put("attachBytes","Test");
//        object.put("attachName","Data Test.pdf");
//        object.put("to","");
//        object.put("requestBy","Mobile FMUI");
//
//
//        MultipartFile[] testAttachName = new MultipartFile[0];
//        String[] values2 = {"k"};
//        String[] values = {};
//        MultipartFile[] multiFile = testAttachName;
//
//        sendEmaildto input = new sendEmaildto();
//        input.setSubject("Test");
//        input.setEmailBody("Try Send Email");
//        input.setAttachBytes(multiFile);
//        input.setAttachName(values2);
//        input.setTo(values);
//        input.setRequestBy("Mobile FMUI");
//
//        //Data out ext api
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("To can't be null!");
//
//        //Resp data ext api
//        ResponseEntity resp = sendEmailServices.sendEmail(input);
//
//        assertNotNull(resp);
//        assertEquals(resp.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//
//    }
//
//    @Test
//    public void sendEmail_EmailBodyNull() throws Exception{
//
//        //Param input
//        JSONObject object = new JSONObject();
//        object.put("subject","Test");
//        object.put("emailBody","");
//        object.put("attachBytes","Test");
//        object.put("attachName","Data Test.pdf");
//        object.put("to","ahmadasob54@gmail.com");
//        object.put("requestBy","Mobile FMUI");
//
//
//        MultipartFile[] testAttachName = new MultipartFile[0];
//        String[] values = {"k"};
//        MultipartFile[] multiFile = testAttachName;
//
//        sendEmaildto input = new sendEmaildto();
//        input.setSubject("Test");
//        input.setEmailBody("");
//        input.setAttachBytes(multiFile);
//        input.setAttachName(values);
//        input.setTo(values);
//        input.setRequestBy("Mobile FMUI");
//
//        //Data out ext api
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("Email Body can't be null!");
//
//        //Resp data ext api
//        ResponseEntity resp = sendEmailServices.sendEmail(input);
//
//        assertNotNull(resp);
//        assertEquals(resp.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//
//    }
//
//    @Test
//    public void sendEmail_RequestByNull() throws Exception{
//
//        //Param input
//        JSONObject object = new JSONObject();
//        object.put("subject","Test");
//        object.put("emailBody","Try Send Email");
//        object.put("attachBytes","Test");
//        object.put("attachName","Data Test.pdf");
//        object.put("to","ahmadasob54@gmail.com");
//        object.put("requestBy","");
//
//
//        MultipartFile[] testAttachName = new MultipartFile[0];
//        String[] values = {"k"};
//        MultipartFile[] multiFile = testAttachName;
//
//        sendEmaildto input = new sendEmaildto();
//        input.setSubject("Test");
//        input.setEmailBody("Try Send Email");
//        input.setAttachBytes(multiFile);
//        input.setAttachName(values);
//        input.setTo(values);
//        input.setRequestBy("");
//
//        //Data out ext api
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("Request By can't be null!");
//
//        //Resp data ext api
//        ResponseEntity resp = sendEmailServices.sendEmail(input);
//
//        assertNotNull(resp);
//        assertEquals(resp.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//
//    }
//
//    @Test
//    public void sendEmail_Success() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        String[] values = new String[1];
//        values[0] = "test@fif.co.id";
//        MultipartFile[] multiFile = testAttachName;
//
//        //Param input
//        JSONObject object = new JSONObject();
//        object.put("subject","Test");
//        object.put("emailBody","Try Send Email");
//        object.put("attachBytes",testAttachName);
//        object.put("attachName",values);
//        object.put("to",values);
//        object.put("requestBy","Mobile FMUI");
//
//        sendEmaildto input = new sendEmaildto();
//        input.setSubject("Test");
//        input.setEmailBody("Try Send Email");
//        input.setAttachBytes(new MultipartFile[] {multiFile[0]});
//        input.setAttachName(new String[] {values[0]});
//        input.setTo(new String[]{values[0]});
//        input.setRequestBy("Mobile FMUI");
//
//        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<>();
//        dataMap.add("from", "apptest");
//        dataMap.add("paswd", "12345678Aa");
//        dataMap.add("subject", input.getSubject());
//        dataMap.add("emailbody", input.getEmailBody());
//        dataMap.add("to", "test@fif.co.id");
//        dataMap.add("cc", null);
//        dataMap.add("attachName", input.getAttachName());
//        dataMap.add("atttachBytes", input.getAttachBytes());
//        String response = "OK";
//
//        ResponseEntity<String> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
//
//        when(gateway.sendEmail(input)).thenReturn(responseEntity);
//
//        //Data out ext api
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Succesfully");
//
//        //Resp data ext api
//        ResponseEntity resp = sendEmailServices.sendEmail(input);
//
//        verify(gateway).sendEmail(input);
//
//        assertNotNull(resp);
//    }
//
//    @Test
//    public void sendEmail_BAD() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        String[] values = new String[1];
//        values[0] = "test@fif.co.id";
//        MultipartFile[] multiFile = testAttachName;
//
//        //Param input
//        JSONObject object = new JSONObject();
//        object.put("subject","Test");
//        object.put("emailBody","Try Send Email");
//        object.put("attachBytes",testAttachName);
//        object.put("attachName",values);
//        object.put("to",values);
//        object.put("requestBy","Mobile FMUI");
//
//        sendEmaildto input = new sendEmaildto();
//        input.setSubject("Test");
//        input.setEmailBody("Try Send Email");
//        input.setAttachBytes(new MultipartFile[] {multiFile[0]});
//        input.setAttachName(new String[] {values[0]});
//        input.setTo(new String[]{values[0]});
//        input.setRequestBy("Mobile FMUI");
//
//        MultiValueMap<String, Object> dataMap = new LinkedMultiValueMap<>();
//        dataMap.add("from", "apptest");
//        dataMap.add("paswd", "12345678Aa");
//        dataMap.add("subject", input.getSubject());
//        dataMap.add("emailbody", input.getEmailBody());
//        dataMap.add("to", "test@fif.co.id");
//        dataMap.add("cc", null);
//        dataMap.add("attachName", input.getAttachName());
//        dataMap.add("atttachBytes", input.getAttachBytes());
//
//        String response = "BAD";
//
//        ResponseEntity<String> responseEntity = new ResponseEntity<>(response, HttpStatus.OK);
//
//        when(gateway.sendEmail(input)).thenReturn(responseEntity);
//
//        //Data out ext api
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Succesfully");
//
//        //Resp data ext api
//        ResponseEntity resp = sendEmailServices.sendEmail(input);
//
//        verify(gateway).sendEmail(input);
//
//        assertNotNull(resp);
//    }
//}
