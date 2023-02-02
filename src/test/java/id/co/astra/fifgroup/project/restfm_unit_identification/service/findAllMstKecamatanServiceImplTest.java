//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstKecamatan;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstKecamatanRepository;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstKecamatanService;
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
//public class findAllMstKecamatanServiceImplTest {
//
//    @Autowired
//    findAllMstKecamatanService findAllMstKecamatanService;
//
//    @MockBean
//    MstKecamatanRepository mstKecamatanRepository;
//
//    @Test
//    public void dataFound() throws Exception{
//
//        List<mstKecamatan> listBu = new ArrayList<>();
//        mstKecamatan bu = new mstKecamatan();
//        bu.setKecCode("3175010");
//        bu.setKecamatan("Kec Pasar Rebo");
//        bu.setCityCode("3175");
//        listBu.add(bu);
//
//        //out ext api
//        responseFiduciaObj responseObj = new responseFiduciaObj();
//
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Succesfully");
//        responseObj.setData(listBu);
//
//        //out Service
//        when(mstKecamatanRepository.findAll()).thenReturn(listBu);
//
//        //Request and Get Result
//        ResponseEntity result = findAllMstKecamatanService.findAllMstKecamatan();
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
//        when(mstKecamatanRepository.findAll()).thenThrow(new RuntimeException());
//
//        ResponseEntity resp = findAllMstKecamatanService.findAllMstKecamatan();
//
//        System.out.println(resp);
//
//        verify(mstKecamatanRepository).findAll();
//        //Verify Result
////        assertNotNull(resp);
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//}
