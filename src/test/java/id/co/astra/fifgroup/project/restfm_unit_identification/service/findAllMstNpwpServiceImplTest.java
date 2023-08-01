//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.mstNpwpKpp;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifAppsRepo.MstNpwpKppRepo;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstNpwpService;
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
//public class findAllMstNpwpServiceImplTest {
//
//    @Autowired
//    findAllMstNpwpService findAllMstNpwpService;
//
//    @MockBean
//    MstNpwpKppRepo mstNpwpKppRepo;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<mstNpwpKpp> listBu = new ArrayList<>();
//        mstNpwpKpp bu = new mstNpwpKpp();
//        bu.setNpwpKppId("101");
//        bu.setNpwpKppArea("SUMUT");
//        bu.setNpwpKppName("KPP Binjai");
//        bu.setNpwpKppWorkingArea("Kota Binjai  Kab. Langkat  Kec. Labuhan Deli  Kec. Sunggal  Kec. Pancur Batu  Kec. Hamparan Perak  Kec. Sibolangit  Kec. Kutalimbaru  Kab. Tanah Karo");
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
//        when(mstNpwpKppRepo.findAll()).thenReturn(listBu);
//
//        //Request and get result
//        ResponseEntity resultBl = findAllMstNpwpService.findAllMstNpwp();
//        assertNotNull(resultBl);
//        assertEquals(resultBl.getStatusCodeValue(),Integer.parseInt(responseObj.getRespHttpCode()));
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
//        when(mstNpwpKppRepo.findAll()).thenThrow(new RuntimeException());
//
//        ResponseEntity resp = findAllMstNpwpService.findAllMstNpwp();
//
//        System.out.println(resp);
//
//        verify(mstNpwpKppRepo).findAll();
//        //Verify Result
////        assertNotNull(resp);
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//}
