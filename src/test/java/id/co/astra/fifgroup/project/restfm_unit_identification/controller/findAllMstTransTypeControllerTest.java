//package id.co.astra.fifgroup.project.restfm_unit_identification.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.mstTransType;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstTransTypeService;
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
//@WebMvcTest(findAllMstTransTypeController.class)
//@ActiveProfiles("test")
//public class findAllMstTransTypeControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    findAllMstTransTypeService findAllMstTransTypeService;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<mstTransType> listBu = new ArrayList<>();
//        mstTransType bu = new mstTransType();
//        bu.setTransType("ARTHAJASA");
//        bu.setTransDesc("Kantor Pos Online");
//        bu.setCreatedBy("9658");
//        bu.setCreatedTimestamp(LocalDate.of(2008,04,01));
//        bu.setGlCreatedName("CR Trans");
//        bu.setAccountType1(null);
//        bu.setAccountType2(null);
//        bu.setAccountType3(null);
//        bu.setAccountType4(null);
//        bu.setAccountType5(null);
//        bu.setModuleId(5);
//        bu.setRvType("N");
//        bu.setViaInterface("Y");
//        listBu.add(bu);
//
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("200");
//        responseFiduciaObj.setRespHttpMessage("Successfully");
//        responseFiduciaObj.setData(listBu);
//
//        when(findAllMstTransTypeService.findAllMstTransType()).thenReturn(new ResponseEntity(responseFiduciaObj, HttpStatus.OK));
//
//        ResultActions resultActions;
//        resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/restfmui/v1/find-all-trans-type").contentType(MediaType.APPLICATION_JSON));
//
//        verify(findAllMstTransTypeService).findAllMstTransType();
//
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//    }
//}
