//package id.co.astra.fifgroup.project.restfm_unit_identification.controller;
//
//import com.google.gson.Gson;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.*;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.getFiduciaServices;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.sendEmailServices;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.uploadFileServices;
//import org.json.JSONObject;
//import org.junit.jupiter.api.Test;
//import org.mockito.ArgumentMatchers;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.json.GsonJsonParser;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.json.GsonTester;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.File;
//import java.io.FileInputStream;
//
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.ArgumentMatchers.isA;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@WebMvcTest(FmUIController.class)
//@ActiveProfiles("test")
//public class FMUIControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    sendEmailServices sendEmail;
//
//    @MockBean
//    uploadFileServices uploadFile;
//
//    @MockBean
//    getFiduciaServices getFiducia;
//
//
//    @Test
//    public void sendEmail() throws Exception{
//
//        File file = new File("C:/Ahmad Asob/FM_UI/REGISTRASI/PC/PC1/Putty.txt");
//        FileInputStream input = new FileInputStream(file);
//        MultipartFile testAttachName = new MockMultipartFile("file", file.getName(), "", input);
//        String[] values = new String[2];
////        values[0] = "test@fif.co.id";
//        values[0] = "Putty.txt";
//        MultipartFile[] multiFile = new MultipartFile[1];
//        multiFile[0] = testAttachName;
//
//        JSONObject object = new JSONObject();
//        object.put("subject", "Test Send Email Apps Motif");
//        object.put("emailBody", "Try Send Email");
//        object.put("attachBytes", multiFile);
//        object.put("attachName", "Putty.txt");
//        object.put("to", values);
//        object.put("cc", values);
//        object.put("requestBy", "Mobile FMUI");
//
//        sendEmaildto sendData = new sendEmaildto();
//        sendData.setSubject(object.getString("subject"));
//        sendData.setEmailBody(object.getString("emailBody"));
//        sendData.setAttachBytes(multiFile);
//        sendData.setAttachName(values);
//        sendData.setTo(values);
//        sendData.setCc(values);
//        sendData.setRequestBy(object.getString("requestBy"));
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Succesfully");
//
//        when(sendEmail.sendEmail(sendData)).thenReturn(new ResponseEntity(responseObj, HttpStatus.OK));
//
//        ResultActions resultActions;
//        resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/restfmui/v1/send-email")
//                        .contentType(MediaType.MULTIPART_FORM_DATA)
//                        .content(sendData.getAttachBytes().toString()))
//                .andExpect(MockMvcResultMatchers.status().isOk());
////                .andExpect(MockMvcResultMatchers.jsonPath("$.respHttpCode").value(responseObj.getRespHttpCode()));
//    }
//
//    @Test
//    public void registrasi() throws Exception{
//
//        File file = new File("C:/Ahmad Asob/FM_UI/REGISTRASI/PC/PC1/Putty.txt");
//        FileInputStream input = new FileInputStream(file);
//        MultipartFile testAttachName = new MockMultipartFile("file", file.getName(), "", input);
//        String[] values = new String[2];
////        values[0] = "test@fif.co.id";
//        values[0] = "Putty.txt";
//        MultipartFile[] multiFile = new MultipartFile[1];
//        multiFile[0] = testAttachName;
//
//        JSONObject object = new JSONObject();
//        object.put("mitraType", "PC");
//        object.put("pcId", "PC1");
//        object.put("type", "ANGGOTA");
//        object.put("pcaId", "Putty.txt");
//        object.put("fileName", values);
//        object.put("file", testAttachName);
//        object.put("requestBy", "Mobile FMUI");
//
//        uploadFileRegistrasidto sendData = new uploadFileRegistrasidto();
//        sendData.setmitraType(object.getString("mitraType"));
//        sendData.setPcId(object.getString("pcId"));
//        sendData.setType(object.getString("type"));
//        sendData.setPcaId(object.getString("pcaId"));
//        sendData.setFileName(values);
//        sendData.setFile(multiFile);
//        sendData.setRequestBy(object.getString("requestBy"));
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Succesfully");
//
//        when(uploadFile.uploadFileRegistrasi(sendData)).thenReturn(new ResponseEntity(responseObj, HttpStatus.OK));
//
//        ResultActions resultActions;
//        resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/restfmui/v1/registrasi")
//                        .contentType(MediaType.MULTIPART_FORM_DATA)
//                        .content(sendData.getFile().toString()))
//                .andExpect(MockMvcResultMatchers.status().isOk());
////                .andExpect(MockMvcResultMatchers.jsonPath("$.respHttpCode").value(responseObj.getRespHttpCode()));
//    }
//
//    @Test
//    public void uploadFileSKPC() throws Exception{
//
//        File file = new File("C:/Ahmad Asob/FM_UI/REGISTRASI/PC/PC1/Putty.txt");
//        FileInputStream input = new FileInputStream(file);
//        MultipartFile testAttachName = new MockMultipartFile("file", file.getName(), "", input);
//        String[] values = new String[2];
////        values[0] = "test@fif.co.id";
//        values[0] = "Putty.txt";
//        MultipartFile[] multiFile = new MultipartFile[1];
//        multiFile[0] = testAttachName;
//
//        JSONObject object = new JSONObject();
//        object.put("officeCode", "PC");
//        object.put("pcId", "PC1");
//        object.put("customerNo", "ANGGOTA");
//        object.put("skpcNo", "Putty.txt");
//        object.put("contractNo", "082391736781");
//        object.put("fileName", values);
//        object.put("file", multiFile);
//        object.put("requestBy", "Mobile FMUI");
//
//        uploadFileSKPCdto sendData = new uploadFileSKPCdto();
//        sendData.setOfficeCode(object.getString("officeCode"));
//        sendData.setPcId(object.getString("pcId"));
//        sendData.setCustomerNo(object.getString("customerNo"));
//        sendData.setSkpcNo(object.getString("skpcNo"));
//        sendData.setContractNo(object.getString("contractNo"));
//        sendData.setFileName(values);
//        sendData.setFile(multiFile);
//        sendData.setRequestBy(object.getString("requestBy"));
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Succesfully");
//
//        when(uploadFile.uploadFileSKPC(sendData)).thenReturn(new ResponseEntity(responseObj, HttpStatus.OK));
//
//        ResultActions resultActions;
//        resultActions = mockMvc.perform(MockMvcRequestBuilders.post("/restfmui/v1/transaksi")
//                        .contentType(MediaType.MULTIPART_FORM_DATA)
//                        .content(sendData.getFile().toString()))
//                .andExpect(MockMvcResultMatchers.status().isOk());
////                .andExpect(MockMvcResultMatchers.jsonPath("$.respHttpCode").value(responseObj.getRespHttpCode()));
//    }
//
//    @Test
//    public void getIdFiducia() throws Exception{
//
//        JSONObject object = new JSONObject();
//        object.put("contractNo","1243143234324");
//        object.put("requestBy","Mobile FMUI");
//
//        String contractNo = object.getString("contractNo");
//        String requestBy = object.getString("requestBy");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Succesfully");
//
//        when(getFiducia.getfiducia(contractNo, requestBy)).thenReturn(new ResponseEntity(responseObj, HttpStatus.OK));
//
//        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/restfmui/v1/fiducia")
//                .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(MockMvcResultMatchers.status().isOk());
//
////        verify(getFiducia).getfiducia(contractNo, requestBy);
//
////        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//
//    }
//}