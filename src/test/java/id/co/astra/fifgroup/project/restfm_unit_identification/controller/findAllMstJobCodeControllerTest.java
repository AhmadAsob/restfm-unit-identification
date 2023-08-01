//package id.co.astra.fifgroup.project.restfm_unit_identification.controller;
//
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.mstJobCodes;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstJobCodesService;
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
//@WebMvcTest(findAllMstJobCodesController.class)
//@ActiveProfiles("test")
//public class findAllMstJobCodeControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    findAllMstJobCodesService findAllMstJobCodesService;
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
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("200");
//        responseFiduciaObj.setRespHttpMessage("Successfully");
//        responseFiduciaObj.setData(listBu);
//
//        when(findAllMstJobCodesService.findAllMstJobCodes()).thenReturn(new ResponseEntity(responseFiduciaObj, HttpStatus.OK));
//
//        ResultActions resultActions;
//        resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/restfmui/v1/find-all-job-codes").contentType(MediaType.APPLICATION_JSON));
//
//        verify(findAllMstJobCodesService).findAllMstJobCodes();
//
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//    }
//}
