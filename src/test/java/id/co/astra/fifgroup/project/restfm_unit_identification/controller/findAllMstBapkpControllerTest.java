//package id.co.astra.fifgroup.project.restfm_unit_identification.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstBapkp;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstBapkpService;
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
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@WebMvcTest(findAllMstBapkpController.class)
//@ActiveProfiles("test")
//public class findAllMstBapkpControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//
//    @MockBean
//    findAllMstBapkpService findAllMstBapkpService;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<mstBapkp> listBu = new ArrayList<>();
//        mstBapkp bu = new mstBapkp();
//        bu.setOfficeCode("21200");
//        bu.setBastbjNo("2120014-000075");
//        bu.setBastbjOnHand("O62802");
//        bu.setBastbjDate(String.valueOf(LocalDateTime.of(2014,8,19,00,00,00)));
//        bu.setBastbjStatus("VL");
//        bu.setDistributionBy("23304");
//        listBu.add(bu);
//
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("200");
//        responseFiduciaObj.setRespHttpMessage("Successfully");
//        responseFiduciaObj.setData(listBu);
//
//        when(findAllMstBapkpService.findAllMstBapkp()).thenReturn(new ResponseEntity(responseFiduciaObj, HttpStatus.OK));
//
//        ResultActions resultActions;
//        resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/restfmui/v1/find-all-bapkp").contentType(MediaType.APPLICATION_JSON));
//
//        verify(findAllMstBapkpService).findAllMstBapkp();
//
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//    }
//}
