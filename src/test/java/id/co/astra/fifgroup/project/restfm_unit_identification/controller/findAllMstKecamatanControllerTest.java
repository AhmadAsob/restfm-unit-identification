//package id.co.astra.fifgroup.project.restfm_unit_identification.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstKecamatan;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstKecamatanService;
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
//@WebMvcTest(findAllMstKecamatanController.class)
//@ActiveProfiles("test")
//public class findAllMstKecamatanControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    findAllMstKecamatanService findAllMstKecamatanService;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<mstKecamatan> listBu = new ArrayList<>();
//        mstKecamatan bu = new mstKecamatan();
//        bu.setKecCode("3175010");
//        bu.setKecamatan("Kec Pasar Rebo");
//        bu.setCityCode("3175");
//        listBu.add(bu);
//
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("200");
//        responseFiduciaObj.setRespHttpMessage("Successfully");
//        responseFiduciaObj.setData(listBu);
//
//        when(findAllMstKecamatanService.findAllMstKecamatan()).thenReturn(new ResponseEntity(responseFiduciaObj, HttpStatus.OK));
//
//        ResultActions resultActions;
//        resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/restfmui/v1/find-all-kecamatan").contentType(MediaType.APPLICATION_JSON));
//
//        verify(findAllMstKecamatanService).findAllMstKecamatan();
//
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//    }
//}
