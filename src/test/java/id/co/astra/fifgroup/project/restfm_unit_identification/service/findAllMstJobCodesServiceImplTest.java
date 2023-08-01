//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.mstJobCodes;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifAppsRepo.MstJobCodesRepository;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstJobCodesService;
//import org.apache.tomcat.jni.Local;
//import org.json.JSONObject;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.ArgumentMatchers.nullable;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ActiveProfiles("unittest")
//public class findAllMstJobCodesServiceImplTest {
//
//    @Autowired
//    findAllMstJobCodesService findAllMstJobCodesService;
//
//    @MockBean
//    MstJobCodesRepository mstJobCodesRepository;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<mstJobCodes> listBu = new ArrayList<>();
//        mstJobCodes bu = new mstJobCodes();
//        bu.setJobCode("G00000");
//        bu.setDescription("PRESIDENT DIRECTOR");
//        bu.setOfficeCode("00001");
//        bu.setCreatedBy("FIFDB");
//        bu.setCreatedTimestamp(LocalDate.of(2006,02,18));
//        bu.setLastupdateBy(null);
//        bu.setLastupdateTimestamp(null);
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
//        when(mstJobCodesRepository.findAll()).thenReturn(listBu);
//
//        //Request and Get Result
//        ResponseEntity result = findAllMstJobCodesService.findAllMstJobCodes();
//        //Verify Result
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
//        when(mstJobCodesRepository.findAll()).thenThrow(new RuntimeException());
//
//        ResponseEntity resp = findAllMstJobCodesService.findAllMstJobCodes();
//
//        System.out.println(resp);
//
//        verify(mstJobCodesRepository).findAll();
//        //Verify Result
////        assertNotNull(resp);
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//}
