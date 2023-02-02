//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstCompany;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstCompanyRepository;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstCompanyService;
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
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ActiveProfiles("unittest")
//public class findAllMstCompanyServiceImplTest {
//
//    @Autowired
//    findAllMstCompanyService findAllMstCompanyService;
//
//    @MockBean
//    MstCompanyRepository mstCompanyRepository;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<mstCompany> listBu = new ArrayList<>();
//        mstCompany bu = new mstCompany();
//        bu.setCoyId("01");
//        bu.setCoyName("PT FEDERAL INTERNATIONAL FINANCE");
//        bu.setSegementCoy("01");
//        bu.setSetOfBookId("2021");
//        bu.setCreateBy("1000");
//        bu.setCreateDate(LocalDate.of(2007,3,20));
//        bu.setUpdateBy("IRMA");
//        bu.setUpdateDate(LocalDate.of(0007,5,2));
//        bu.setSegmentNo(8);
//        bu.setPrefJeCategory(null);
//        bu.setDefaultPlatform("K");
//        bu.setNameShort("FIF");
//        listBu.add(bu);
//
//        //output ext api
//        responseFiduciaObj responseObj = new responseFiduciaObj();
//
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Succesfully");
//        responseObj.setData(listBu);
//        //out Service
//        when(mstCompanyRepository.findAll()).thenReturn(listBu);
//
//        //Request and Get Result
//        ResponseEntity result = findAllMstCompanyService.findAllMstCompany();
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
//        when(mstCompanyRepository.findAll()).thenThrow(new RuntimeException());
//
//        ResponseEntity resp = findAllMstCompanyService.findAllMstCompany();
//        System.out.println(resp);
//
//        verify(mstCompanyRepository).findAll();
//        //Verify Result
////        assertNotNull(resp);
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//}
