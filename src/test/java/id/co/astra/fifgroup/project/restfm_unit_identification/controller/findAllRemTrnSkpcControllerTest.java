//package id.co.astra.fifgroup.project.restfm_unit_identification.controller;
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.RemTrnSkpc;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.RemTrnSkpcId;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllRemTrnSkpcService;
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
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@WebMvcTest(findAllRemTrnSkpcControllerTest.class)
//@ActiveProfiles("test")
//public class findAllRemTrnSkpcControllerTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private findAllRemTrnSkpcService findAllRemTrnSkpcService;
//
//    @Test
//    public void dataFound() throws Exception{
//
//        List<RemTrnSkpc> listBu = new ArrayList<>();
//        RemTrnSkpc bu =  new RemTrnSkpc();
//        RemTrnSkpcId by = new RemTrnSkpcId();
//        by.setSkpcNo("1");
//        by.setSeqNo(1L);
//        bu.setId(by);
//        bu.setSkpcExpiredDate(LocalDate.of(2015,9,9));
//        bu.setPc("A");
//        bu.setContractNo("1");
//        bu.setStatusSkpc("A");
//        bu.setCreatedBy("A");
//        bu.setCreatedTimestamp(LocalDate.of(2015,9,9));
//        bu.setLastupdateBy("A");
//        bu.setLastupdateTimestamp(LocalDate.of(2015,9,9));
//        bu.setOfficeCode("1");
//        bu.setCoyId("1");
//        bu.setFreezeDate(LocalDate.of(2015,9,9));
//        bu.setPrintCtr(1L);
//        bu.setPalNo("1");
//        listBu.add(bu);
//
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("200");
//        responseFiduciaObj.setRespHttpMessage("Successfully");
//        responseFiduciaObj.setData(listBu);
//
//        when(findAllRemTrnSkpcService.findAllRemTrnSkpc()).thenReturn(new ResponseEntity(responseFiduciaObj, HttpStatus.OK));
//
//        ResultActions resultActions;
//        resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/restfmui/v1/find-all-skpc").contentType(MediaType.APPLICATION_JSON));
//
////        verify(findAllRemTrnSkpcService).findAllRemTrnSkpc();
//
////        resultActions.andExpect(MockMvcResultMatchers.status().isNotFound()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//    }
//}
