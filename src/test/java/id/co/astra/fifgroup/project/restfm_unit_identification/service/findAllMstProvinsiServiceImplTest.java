//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstProvinsi;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstProvinsiRepository;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstProvinsiService;
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
//import java.util.concurrent.CompletableFuture;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ActiveProfiles("unittest")
//public class findAllMstProvinsiServiceImplTest {
//
//    @Autowired
//    private findAllMstProvinsiService findAllMstProvinsiService;
//
//    @MockBean
//    private MstProvinsiRepository mstProvinsiRepository;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<mstProvinsi> listBu = new ArrayList<>();
//        mstProvinsi bu = new mstProvinsi();
//        bu.setProvinsi("Provinsi Aceh");
//        bu.setProvCode("011");
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
//        when(mstProvinsiRepository.findAll()).thenReturn(listBu);
//
//        //Request and get result
//        ResponseEntity result = findAllMstProvinsiService.findAllMstProvinsi();
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
//        when(mstProvinsiRepository.findAll()).thenThrow(new RuntimeException());
//
//        ResponseEntity resp = findAllMstProvinsiService.findAllMstProvinsi();
//
//        System.out.println(resp);
//
//        verify(mstProvinsiRepository).findAll();
//        //Verify Result
////        assertNotNull(resp);
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//}
