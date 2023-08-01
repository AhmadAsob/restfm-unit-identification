//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//import com.sun.org.apache.regexp.internal.RE;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.mstMouHdrs;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifAppsRepo.MstMouHdrsRepository;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstMouHdrsService;
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
//public class findAllMstMouHdrsServiceImplTest {
//
//    @Autowired
//    findAllMstMouHdrsService findAllMstMouHdrsService;
//
//    @MockBean
//    MstMouHdrsRepository mstMouHdrsRepository;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<mstMouHdrs> listBu = new ArrayList<>();
//        mstMouHdrs bu = new mstMouHdrs();
//        bu.setMouNo("RK10100001011007");
//        bu.setMouDate(LocalDate.of(2007,10,1));
//        bu.setDescription(null);
//        bu.setStartDate(LocalDate.of(2007,10,1));
//        bu.setEndDate(LocalDate.of(2008,10,1));
//        bu.setStatus("CL");
//        bu.setCreatedBy("MIG");
//        bu.setCreatedTimestamp(LocalDate.from(LocalDateTime.of(2008,04,1,9,18,38)));
//        bu.setLastUpdateBy("SYSTEM");
//        bu.setLastUpdateTimestamp(LocalDate.from(LocalDateTime.of(2008,10,02,3,57,2)));
//        bu.setMouType("RK");
//        bu.setSuplCode("VS-23344");
//        bu.setOfficeCode("10100");
//        bu.setSuplRevisePrice("N");
//        bu.setAdminFee(125000);
//        bu.setReason(null);
//        bu.setCoyId("01");
//        bu.setOffsetFlag("N");
//        bu.setBigbuyerFlag("N");
//        bu.setRefinancingFlag("N");
//        bu.setRemarksCt(null);
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
//        when(mstMouHdrsRepository.findAll()).thenReturn(listBu);
//
//        //Request and Get Result
//        ResponseEntity result = findAllMstMouHdrsService.findAllMstMouHdrs();
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
//        when(mstMouHdrsRepository.findAll()).thenThrow(new RuntimeException());
//
//        ResponseEntity resp = findAllMstMouHdrsService.findAllMstMouHdrs();
//
//        System.out.println(resp);
//
//        verify(mstMouHdrsRepository).findAll();
//        //Verify Result
////        assertNotNull(resp);
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//}
