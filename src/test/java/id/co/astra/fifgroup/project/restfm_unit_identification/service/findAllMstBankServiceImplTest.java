//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstBank;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstBankRepo;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstBankService;
//import org.json.JSONException;
//import org.json.JSONObject;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ActiveProfiles("unittest")
//public class findAllMstBankServiceImplTest {
//
//    @Autowired
//    findAllMstBankService findAllMstBankService;
//
//    @MockBean
//    MstBankRepo mstBankRepo;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        //output
//        List<mstBank> listBu = new ArrayList<>();
//        mstBank bu = new mstBank();
//        bu.setBankId("XX059");
//        bu.setBankName("DANAHUTAMA");
//        listBu.add(bu);
//
//        //output ext api
//        responseFiduciaObj responseObj = new responseFiduciaObj();
//
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Succesfully");
//        responseObj.setData(listBu);
//
//        //out Service
//        when(mstBankRepo.findAll()).thenReturn(listBu);
//
//        //Request and get result
//        ResponseEntity result = findAllMstBankService.findAllMstBank();
//
//        assertNotNull(result);
//        assertEquals(result.getStatusCodeValue(),Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//
//    @Test
//    public void dataNotFound() throws Exception {
//
//        //output ext api
//        responseFiduciaObj responseObj = new responseFiduciaObj();
//
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("Not Found");
//        responseObj.setData(Collections.emptyList());
//
//        String response = "NOT FOUND";
//
//        ResponseEntity result = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        when(mstBankRepo.findAll()).thenThrow(new RuntimeException());
//
//        ResponseEntity resp = findAllMstBankService.findAllMstBank();
//
//        System.out.println(resp);
//
//        verify(mstBankRepo).findAll();
//        //Verify Result
////        assertNotNull(resp);
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//}
