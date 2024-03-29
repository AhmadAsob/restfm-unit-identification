//package id.co.astra.fifgroup.project.restfm_unit_identification.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.mstOffice;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstOfficeService;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ActiveProfiles;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.ResultActions;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@WebMvcTest(findAllMstOfficeController.class)
//@ActiveProfiles("test")
//public class findAllMstOfficeControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    findAllMstOfficeService findAllMstOfficeService;
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
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("200");
//        responseFiduciaObj.setRespHttpMessage("Successfully");
//        responseFiduciaObj.setData(listBu);
//
//        when(findAllMstOfficeService.findAllMstOffice()).thenReturn(new ResponseEntity(responseFiduciaObj, HttpStatus.OK));
//
//        ResultActions resultActions;
//        resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/restfmui/v1/find-all-office").contentType(MediaType.APPLICATION_JSON));
//
//        verify(findAllMstOfficeService).findAllMstOffice();
//
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//    }
//}
