//package id.co.astra.fifgroup.project.restfm_unit_identification.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstZip;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstZipService;
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
//@WebMvcTest(findAllMstZipController.class)
//@ActiveProfiles("test")
//public class findAllMstZipControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    findAllMstZipService findAllMstZipService;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<mstZip> listBu = new ArrayList<>();
//        mstZip bu = new mstZip();
//        bu.setZipCode("10110");
//        bu.setZipDesc("Kel Gambir Kec Gambir Kota Jakarta Pusat  Prov DKI Jakarta");
//        bu.setProvCode("031");
//        bu.setCityCode("03171");
//        bu.setKecCode("0317101");
//        bu.setKelCode("0317101001");
//        listBu.add(bu);
//
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("200");
//        responseFiduciaObj.setRespHttpMessage("Successfully");
//        responseFiduciaObj.setData(listBu);
//
//        when(findAllMstZipService.findAllMstZip()).thenReturn(new ResponseEntity(responseFiduciaObj, HttpStatus.OK));
//
//        ResultActions resultActions;
//        resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/restfmui/v1/find-all-zip").contentType(MediaType.APPLICATION_JSON));
//
//        verify(findAllMstZipService).findAllMstZip();
//
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//    }
//}
