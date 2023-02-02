//package id.co.astra.fifgroup.project.restfm_unit_identification.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstCompany;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstCompanyService;
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
//@WebMvcTest(findAllMstCompanyController.class)
//@ActiveProfiles("test")
//public class findAllMstCompanyControllerTest {
//
//    @Autowired
//    MockMvc mockMvc;
//    @MockBean
//    findAllMstCompanyService findAllMstCompanyService;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<mstCompany> listBu = new ArrayList<>();
//        mstCompany bu = new mstCompany();
//        bu.setCoyId("01");
//        bu.setCoyName("PT FEDERAL INTERNATIONAL FINANCE");
//        bu.setSegementCoy("01");
//        bu.setSetOfBookId("2021");
//        bu.setCreateBy("1000");
//        bu.setCreateDate(LocalDate.of(2007,3,20));
//        bu.setUpdateBy("IRMA");
//        bu.setUpdateDate(LocalDate.of(0007,5,2));
//        bu.setSegmentNo(8);
//        bu.setPrefJeCategory(null);
//        bu.setDefaultPlatform("K");
//        bu.setNameShort("FIF");
//        listBu.add(bu);
//
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("200");
//        responseFiduciaObj.setRespHttpMessage("Successfully");
//        responseFiduciaObj.setData(listBu);
//
//        when(findAllMstCompanyService.findAllMstCompany()).thenReturn(new ResponseEntity(responseFiduciaObj, HttpStatus.OK));
//
//        ResultActions resultActions;
//        resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/restfmui/v1/find-all-company").contentType(MediaType.APPLICATION_JSON));
//
//        verify(findAllMstCompanyService).findAllMstCompany();
//
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//    }
//}
