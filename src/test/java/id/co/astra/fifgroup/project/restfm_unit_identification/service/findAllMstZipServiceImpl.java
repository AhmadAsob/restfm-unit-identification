//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.mstZip;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifAppsRepo.MstZipRepository;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstZipService;
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
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ActiveProfiles("unittest")
//public class findAllMstZipServiceImpl {
//
//    @Autowired
//    findAllMstZipService findAllMstZipService;
//
//    @MockBean
//    MstZipRepository mstZipRepository;
//
//    @Test
//    public void dataFound() throws Exception{
//
//        List<mstZip> listBu = new ArrayList<>();
//        mstZip bu = new mstZip();
//        bu.setZipCode("10110");
//        bu.setZipDesc("Kel Gambir Kec Gambir Kota Jakarta Pusat  Prov DKI Jakarta");
//        bu.setProvCode("031");
//        bu.setCityCode("03171");
//        bu.setKecCode("0317101");
//        bu.setKelCode("0317101001");
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
//        when(mstZipRepository.findAll()).thenReturn(listBu);
//
//        //Request and Get Result
//        ResponseEntity result = findAllMstZipService.findAllMstZip();
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
//        when(mstZipRepository.findAll()).thenThrow(new RuntimeException());
//
//        ResponseEntity resp = findAllMstZipService.findAllMstZip();
//
//        System.out.println(resp);
//
//        verify(mstZipRepository).findAll();
//        //Verify Result
////        assertNotNull(resp);
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//}
