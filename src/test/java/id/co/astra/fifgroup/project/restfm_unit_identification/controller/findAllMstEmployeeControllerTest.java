//package id.co.astra.fifgroup.project.restfm_unit_identification.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.mstEmployees;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstEmployeeService;
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
//@WebMvcTest(findAllMstEmployeeController.class)
//@ActiveProfiles("test")
//public class findAllMstEmployeeControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    findAllMstEmployeeService findAllMstEmployeeService;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<mstEmployees> listBu = new ArrayList<>();
//        mstEmployees bu = new mstEmployees();
//        bu.setEmplCode("10360");
//        bu.setEmplBranch("27500");
//        bu.setEmplPospopId("27500");
//        bu.setEmplName("MHD. BASRI");
//        bu.setEmplJob("J15");
//        bu.setEmplStatus("PM");
//        bu.setEmplSecujob("G00253");
//        bu.setJobDescription("CREDIT APPLICATION PROCESSOR UF KP");
//        listBu.add(bu);
//
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("200");
//        responseFiduciaObj.setRespHttpMessage("Successfully");
//        responseFiduciaObj.setData(listBu);
//
//        when(findAllMstEmployeeService.findAllMstEmployees()).thenReturn(new ResponseEntity(responseFiduciaObj, HttpStatus.OK));
//
//        ResultActions resultActions;
//        resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/restfmui/v1/find-all-employee").contentType(MediaType.APPLICATION_JSON));
//
//        verify(findAllMstEmployeeService).findAllMstEmployees();
//
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//    }
//}
