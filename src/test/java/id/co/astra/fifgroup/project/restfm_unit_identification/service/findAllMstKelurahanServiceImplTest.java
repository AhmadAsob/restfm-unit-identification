//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstKelurahan;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstKelurahanRepository;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstKelurahanService;
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
//public class findAllMstKelurahanServiceImplTest {
//
//    @Autowired
//    findAllMstKelurahanService findAllMstKelurahanService;
//
//    @MockBean
//    MstKelurahanRepository mstKelurahanRepository;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<mstKelurahan> listBu = new ArrayList<>();
//        mstKelurahan bu = new mstKelurahan();
//        bu.setKelCode("0351415017");
//        bu.setKelurahan("Kel Tampung");
//        bu.setKecCode("0351415");
//        listBu.add(bu);
//
//        //ext out api
//        responseFiduciaObj responseObj = new responseFiduciaObj();
//
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Succesfully");
//        responseObj.setData(listBu);
//
//        //out Service
//        when(mstKelurahanRepository.findAll()).thenReturn(listBu);
//
//        //Request and Get Result
//        ResponseEntity result = findAllMstKelurahanService.findAllMstKelurahan();
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
//        when(mstKelurahanRepository.findAll()).thenThrow(new RuntimeException());
//
//        ResponseEntity resp = findAllMstKelurahanService.findAllMstKelurahan();
//
//        System.out.println(resp);
//
//        verify(mstKelurahanRepository).findAll();
//        //Verify Result
////        assertNotNull(resp);
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//}
