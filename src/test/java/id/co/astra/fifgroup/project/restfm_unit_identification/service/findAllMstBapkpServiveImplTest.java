//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.mstBapkp;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifAppsRepo.MstBapkpRepo;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstBapkpService;
//import org.json.JSONObject;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.time.LocalDateTime;
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
//public class findAllMstBapkpServiveImplTest {
//
//    @Autowired
//    findAllMstBapkpService findAllMstBapkpService;
//
//    @MockBean
//    MstBapkpRepo mstBapkpRepo;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<mstBapkp> listBu = new ArrayList<>();
//        mstBapkp bu = new mstBapkp();
//        bu.setOfficeCode("21200");
//        bu.setBastbjNo("2120014-000075");
//        bu.setBastbjOnHand("O62802");
//        bu.setBastbjDate(String.valueOf(LocalDateTime.of(2014,8,19,00,00,00)));
//        bu.setBastbjStatus("VL");
//        bu.setDistributionBy("23304");
//        listBu.add(bu);
//
//        //output ext api
//        responseFiduciaObj responseObj = new responseFiduciaObj();
//
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Succesfully");
//        responseObj.setData(listBu);
//
//        //out service
//        when(mstBapkpRepo.findAll()).thenReturn(listBu);
//
//        //Request and Get Result
//        ResponseEntity result = findAllMstBapkpService.findAllMstBapkp();
//
//        //Verify Result
//        assertNotNull(result);
//        assertEquals(result.getStatusCodeValue(),Integer.parseInt(responseObj.getRespHttpCode()));
//
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
//        when(mstBapkpRepo.findAll()).thenThrow(new RuntimeException());
//
//        ResponseEntity resp = findAllMstBapkpService.findAllMstBapkp();
//
//        System.out.println(resp);
//
//        verify(mstBapkpRepo).findAll();
//        //Verify Result
////        assertNotNull(resp);
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//}
