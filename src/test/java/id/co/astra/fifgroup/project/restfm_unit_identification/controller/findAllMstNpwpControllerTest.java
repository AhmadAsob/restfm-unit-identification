//package id.co.astra.fifgroup.project.restfm_unit_identification.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.mstNpwpKpp;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstNpwpService;
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
//@WebMvcTest(findAllMstNpwpController.class)
//@ActiveProfiles("test")
//public class findAllMstNpwpControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    findAllMstNpwpService findAllMstNpwpService;
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
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("200");
//        responseFiduciaObj.setRespHttpMessage("Successfully");
//        responseFiduciaObj.setData(listBu);
//
//        when(findAllMstNpwpService.findAllMstNpwp()).thenReturn(new ResponseEntity(responseFiduciaObj, HttpStatus.OK));
//
//        ResultActions resultActions;
//        resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/restfmui/v1/find-all-npwp").contentType(MediaType.APPLICATION_JSON));
//
//        verify(findAllMstNpwpService).findAllMstNpwp();
//
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//    }
//}
