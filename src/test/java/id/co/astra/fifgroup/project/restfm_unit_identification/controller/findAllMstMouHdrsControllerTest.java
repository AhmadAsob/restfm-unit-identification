//package id.co.astra.fifgroup.project.restfm_unit_identification.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstMouHdrs;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstMouHdrsService;
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
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@WebMvcTest(findAllMstMouHdrsController.class)
//@ActiveProfiles("test")
//public class findAllMstMouHdrsControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    findAllMstMouHdrsService  findAllMstMouHdrsService;
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
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("200");
//        responseFiduciaObj.setRespHttpMessage("Successfully");
//        responseFiduciaObj.setData(listBu);
//
//        when(findAllMstMouHdrsService.findAllMstMouHdrs()).thenReturn(new ResponseEntity(responseFiduciaObj, HttpStatus.OK));
//
//        ResultActions resultActions;
//        resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/restfmui/v1/find-all-mou-hdrs").contentType(MediaType.APPLICATION_JSON));
//
//        verify(findAllMstMouHdrsService).findAllMstMouHdrs();
//
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//    }
//}
