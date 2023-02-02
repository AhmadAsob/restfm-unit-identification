//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstOffice;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstOfficeRepository;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstOfficeService;
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
//public class findAllMstOfficeServiceImplTest {
//
//    @Autowired
//    findAllMstOfficeService findAllMstOfficeService;
//
//    @MockBean
//    MstOfficeRepository mstOfficeRepository;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<mstOffice> listBu = new ArrayList<>();;
//        mstOffice bu = new mstOffice();
//        bu.setOfficeCode("21400");
//        bu.setOfficeName("PADANG");
//        bu.setRegionalId("0032");
//        bu.setRegionalName("SUMBAR");
//        bu.setAddress1("JL AGUS SALIM 18");
//        bu.setAddress2("PADANG");
//        bu.setPhoneNo("0751-840400");
//        bu.setLatitude(1);
//        bu.setLongitude(100);
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
//        when(mstOfficeRepository.findAll()).thenReturn(listBu);
//
//        //Request and Get Result
//        ResponseEntity result = findAllMstOfficeService.findAllMstOffice();
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
//        when(mstOfficeRepository.findAll()).thenThrow(new RuntimeException());
//
//        ResponseEntity resp = findAllMstOfficeService.findAllMstOffice();
//
//        System.out.println(resp);
//
//        verify(mstOfficeRepository).findAll();
//        //Verify Result
////        assertNotNull(resp);
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//}
