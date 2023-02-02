//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.uploadFileRegistrasidto;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.uploadFileSKPCdto;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.uploadFileServices;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.mock.web.MockMultipartFile;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.web.multipart.MultipartFile;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import java.awt.geom.RectangularShape;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ActiveProfiles("unittest")
//public class uploadFileServiceTest {
//
//    @Autowired
//    private uploadFileServices uploadFileServices;
//
//    @Test
//    public void mitraType_isEmpty() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        MultipartFile[] multipartFiles = testAttachName;
//
//        uploadFileRegistrasidto input = new uploadFileRegistrasidto();
//        input.setmitraType("");
//        input.setPcId("PCID");
//        input.setType("PCID");
//        input.setPcaId("A");
//        input.setFile(new MultipartFile[] {multipartFiles[0]});
//        input.setRequestBy("A");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("Mitra ID can't be null!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileRegistrasi(input);
//
//        assertNotNull(responseEntity);
//        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void PcID_isEmpty() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        MultipartFile[] multipartFiles = testAttachName;
//
//        uploadFileRegistrasidto input = new uploadFileRegistrasidto();
//        input.setmitraType("PCID");
//        input.setPcId("");
//        input.setType("PCID");
//        input.setPcaId("A");
//        input.setFile(new MultipartFile[] {multipartFiles[0]});
//        input.setRequestBy("A");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("PC ID be null!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileRegistrasi(input);
//
//
//
//        assertNotNull(responseEntity);
//        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void RequestBy_isEmpty() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        MultipartFile[] multipartFiles = testAttachName;
//
//        uploadFileRegistrasidto input = new uploadFileRegistrasidto();
//        input.setmitraType("PCID");
//        input.setPcId("PC");
//        input.setType("PCID");
//        input.setPcaId("A");
//        input.setFile(new MultipartFile[] {multipartFiles[0]});
//        input.setRequestBy("");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("Request By can't be null!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileRegistrasi(input);
//
//        assertNotNull(responseEntity);
//        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void PCAID_isEmpty() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        MultipartFile[] multipartFiles = testAttachName;
//
//        uploadFileRegistrasidto input = new uploadFileRegistrasidto();
//        input.setmitraType("PC");
//        input.setPcId("PC1");
//        input.setType("ANGGOTA");
//        input.setPcaId("");
//        input.setFileName(new String[] {"k"});
//        input.setFile(new MultipartFile[] {multipartFiles[1]});
//        input.setRequestBy("A");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("PCA ID can't be null!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileRegistrasi(input);
//
//        assertNotNull(responseEntity);
//        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void TypeCanNotBeNull() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        MultipartFile[] multipartFiles = testAttachName;
//
//        uploadFileRegistrasidto input = new uploadFileRegistrasidto();
//        input.setmitraType("PC");
//        input.setPcId("PC1");
//        input.setType(" ");
//        input.setPcaId("");
//        input.setFileName(new String[] {"k"});
//        input.setFile(new MultipartFile[] {multipartFiles[1]});
//        input.setRequestBy("A");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("PCA ID can't be null!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileRegistrasi(input);
//
//        assertNotNull(responseEntity);
//        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void Status_BadRequest() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        MultipartFile[] multipartFiles = testAttachName;
//
//        uploadFileRegistrasidto input = new uploadFileRegistrasidto();
//        input.setmitraType("PC");
//        input.setPcId("PC1");
//        input.setType("PCID");
//        input.setPcaId("A");
//        input.setFileName(new String[] {"k"});
//        input.setFile(new MultipartFile[] {multipartFiles[1]});
//        input.setRequestBy("A");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("PCA ID can't be null!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileRegistrasi(input);
//
//        System.out.println(responseEntity.getBody());
//
//        assertNotNull(responseEntity);
//        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void Type_isEmpty() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        MultipartFile[] multipartFiles = testAttachName;
//
//        uploadFileRegistrasidto input = new uploadFileRegistrasidto();
//        input.setmitraType("PC");
//        input.setPcId("PC1");
//        input.setType("");
//        input.setPcaId("A");
//        input.setFileName(new String[] {"k"});
//        input.setFile(new MultipartFile[] {multipartFiles[1]});
//        input.setRequestBy("A");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("Type can't be null!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileRegistrasi(input);
//
//        System.out.println(responseEntity.getBody());
//
//        assertNotNull(responseEntity);
//        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void SetupRegistrasi_isNotPCID() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        MultipartFile[] multipartFiles = testAttachName;
//
//        uploadFileRegistrasidto input = new uploadFileRegistrasidto();
//        input.setmitraType("PC");
//        input.setPcId("PC1");
//        input.setType("ANGGOTA");
//        input.setPcaId("A");
//        input.setFileName(new String[] {"k"});
//        input.setFile(new MultipartFile[] {multipartFiles[1]});
//        input.setRequestBy("A");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("PCA ID can't be null!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileRegistrasi(input);
//
//        assertNotNull(responseEntity);
//        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void officeCode_isEmpty() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        MultipartFile[] multipartFiles = testAttachName;
//
//        uploadFileSKPCdto input = new uploadFileSKPCdto();
//        input.setOfficeCode("");
//        input.setPcId("PC1");
//        input.setCustomerNo("cus1");
//        input.setSkpcNo("SKPC123");
//        input.setContractNo("contract123");
//        input.setFileName(new String[] {"k"});
//        input.setFile(new MultipartFile[] {multipartFiles[1]});
//        input.setRequestBy("Mobile FMUI");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("Office Code can't be null!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileSKPC(input);
//
//        assertNotNull(responseEntity);
//        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void PcId_isEmpty() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        MultipartFile[] multipartFiles = testAttachName;
//
//        uploadFileSKPCdto input = new uploadFileSKPCdto();
//        input.setOfficeCode("10100");
//        input.setPcId("");
//        input.setCustomerNo("cus1");
//        input.setSkpcNo("SKPC123");
//        input.setContractNo("contract123");
//        input.setFileName(new String[] {"k"});
//        input.setFile(new MultipartFile[] {multipartFiles[1]});
//        input.setRequestBy("Mobile FMUI");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("PC ID can't be null!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileSKPC(input);
//
//        assertNotNull(responseEntity);
//        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void CustomerNo_isEmpty() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        MultipartFile[] multipartFiles = testAttachName;
//
//        uploadFileSKPCdto input = new uploadFileSKPCdto();
//        input.setOfficeCode("10100");
//        input.setPcId("PC1");
//        input.setCustomerNo("");
//        input.setSkpcNo("SKPC123");
//        input.setContractNo("contract123");
//        input.setFileName(new String[] {"k"});
//        input.setFile(new MultipartFile[] {multipartFiles[1]});
//        input.setRequestBy("Mobile FMUI");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("Customer No can't be null!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileSKPC(input);
//
//        assertNotNull(responseEntity);
//        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void ContractNo_isEmpty() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        MultipartFile[] multipartFiles = testAttachName;
//
//        uploadFileSKPCdto input = new uploadFileSKPCdto();
//        input.setOfficeCode("10100");
//        input.setPcId("PC1");
//        input.setCustomerNo("cus1");
//        input.setSkpcNo("SKPC123");
//        input.setContractNo("");
//        input.setFileName(new String[] {"k"});
//        input.setFile(new MultipartFile[] {multipartFiles[1]});
//        input.setRequestBy("Mobile FMUI");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("Contract No can't be null!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileSKPC(input);
//
//        assertNotNull(responseEntity);
//        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void RequestBySKPC_isEmpty() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        MultipartFile[] multipartFiles = testAttachName;
//
//        uploadFileSKPCdto input = new uploadFileSKPCdto();
//        input.setOfficeCode("10100");
//        input.setPcId("PC1");
//        input.setCustomerNo("cus1");
//        input.setSkpcNo("SKPC123");
//        input.setContractNo("contract123");
//        input.setFileName(new String[] {"k"});
//        input.setFile(new MultipartFile[] {multipartFiles[1]});
//        input.setRequestBy("");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("Contract No can't be null!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileSKPC(input);
//
//        assertNotNull(responseEntity);
//        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void SKPC_BadRequest() throws Exception{
//
//        MultipartFile[] testAttachName = new MultipartFile[7];
//        MultipartFile[] multipartFiles = testAttachName;
//
//        uploadFileSKPCdto input = new uploadFileSKPCdto();
//        input.setOfficeCode("10100");
//        input.setPcId("PC1");
//        input.setCustomerNo("cus1");
//        input.setSkpcNo("SKPC123");
//        input.setContractNo("contract123");
//        input.setFileName(new String[] {"k"});
//        input.setFile(new MultipartFile[] {multipartFiles[1]});
//        input.setRequestBy("Mobile FMUI");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("Contract No can't be null!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileSKPC(input);
//
//        assertNotNull(responseEntity);
//        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void Status_Success() throws Exception{
//
//        File file = new File("C:/Ahmad Asob/FM_UI/REGISTRASI/PC/PC1/Putty.txt");
//        FileInputStream inputFile = new FileInputStream(file);
//        MultipartFile testAttachName = new MockMultipartFile("file", file.getName(), "", inputFile);
//        String[] values = new String[2];
////        values[0] = "test@fif.co.id";
//        values[0] = "Putty.txt";
//        MultipartFile[] multiFile = new MultipartFile[1];
//        multiFile[0] = testAttachName;
//
//        uploadFileRegistrasidto input = new uploadFileRegistrasidto();
//        input.setmitraType("PC");
//        input.setPcId("PC1");
//        input.setType("PCID");
//        input.setPcaId("A");
//        input.setFileName(values);
//        input.setFile(multiFile);
//        input.setRequestBy("A");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("424");
//        responseObj.setRespHttpMessage("Failed");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileRegistrasi(input);
//
//        assertNotNull(responseEntity);
////        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void SKPC_Success() throws Exception{
//
//        File file = new File("C:/Ahmad Asob/FM_UI/REGISTRASI/PC/PC1/Putty.txt");
//        FileInputStream inputFile = new FileInputStream(file);
//        MultipartFile testAttachName = new MockMultipartFile("file", file.getName(), "", inputFile);
//        String[] values = new String[2];
////        values[0] = "test@fif.co.id";
//        values[0] = "Putty.txt";
//        MultipartFile[] multiFile = new MultipartFile[1];
//        multiFile[0] = testAttachName;
//
//        uploadFileSKPCdto input = new uploadFileSKPCdto();
//        input.setOfficeCode("10100");
//        input.setPcId("PC1");
//        input.setCustomerNo("cus1");
//        input.setSkpcNo("SKPC123");
//        input.setContractNo("1232342545");
//        input.setFileName(values);
//        input.setFile(multiFile);
//        input.setRequestBy("Mobile FMUI");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Success");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileSKPC(input);
//
//        assertNotNull(responseEntity);
////        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void StatusTypeAnggota_Success() throws Exception{
//
//        File file = new File("C:/Ahmad Asob/FM_UI/REGISTRASI/PC/PC1/Putty.txt");
//        FileInputStream inputFile = new FileInputStream(file);
//        MultipartFile testAttachName = new MockMultipartFile("file", file.getName(), "", inputFile);
//        String[] values = new String[2];
////        values[0] = "test@fif.co.id";
//        values[0] = "Putty.txt";
//        MultipartFile[] multiFile = new MultipartFile[1];
//        multiFile[0] = testAttachName;
//
//        uploadFileRegistrasidto input = new uploadFileRegistrasidto();
//        input.setmitraType("PC");
//        input.setPcId("PC1");
//        input.setType("ANGGOTA");
//        input.setPcaId("A");
//        input.setFileName(values);
//        input.setFile(multiFile);
//        input.setRequestBy("A");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Upload Data Sucessfully!!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileRegistrasi(input);
//
//        assertNotNull(responseEntity);
////        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//    @Test
//    public void Status_Failed() throws Exception{
//
//        File file = new File("C:/Ahmad Asob/FM_UI/REGISTRASI/PC/PC1/Putty.txt");
//        file.getPath().isEmpty();
//        FileInputStream inputFile = new FileInputStream(file);
//        MultipartFile testAttachName = new MockMultipartFile("file", file.getName(), "", inputFile);
//        String[] values = new String[2];
////        values[0] = "test@fif.co.id";
//        values[0] = "Putty.txt";
//        MultipartFile[] multiFile = new MultipartFile[1];
//        multiFile[0] = testAttachName;
//
//        uploadFileRegistrasidto input = new uploadFileRegistrasidto();
//        input.setmitraType("PC");
//        input.setPcId("PC1");
//        input.setType("PCID");
//        input.setPcaId("A");
//        input.setFileName(values);
//        input.setFile(multiFile);
//        input.setRequestBy("A");
//
//        responseObj responseObj = new responseObj();
//        responseObj.setRespHttpCode("424");
//        responseObj.setRespHttpMessage("Upload Data Failed!");
//
//        ResponseEntity response = new ResponseEntity(responseObj, HttpStatus.BAD_REQUEST);
//
//        ResponseEntity responseEntity = uploadFileServices.uploadFileRegistrasi(input);
//
//        assertNotNull(responseEntity);
////        assertEquals(response.getStatusCode(), responseEntity.getStatusCode());
//    }
//
//}
