//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.mstTransType;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifAppsRepo.MstTransTypeRepository;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstTransTypeService;
//import org.json.JSONObject;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.ArgumentMatchers.nullable;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ActiveProfiles("unittest")
//public class findAllMstTransTypeServiceImpl {
//
//    @Autowired
//    findAllMstTransTypeService findAllMstTransTypeService;
//
//    @MockBean
//    MstTransTypeRepository mstTransTypeRepository;
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
//        //output ext api
//        responseFiduciaObj responseObj = new responseFiduciaObj();
//
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Succesfully");
//        responseObj.setData(listBu);
//
//        //out Service
//        when(mstTransTypeRepository.findAll()).thenReturn(listBu);
//
//
//        //Request and Get Result
//        ResponseEntity result = findAllMstTransTypeService.findAllMstTransType();
//        //Verify Result
//        assertNotNull(result);
//        assertEquals(result.getStatusCodeValue(),Integer.parseInt(responseObj.getRespHttpCode()));
//
//    }
//
//    @Test
//    public void dataNotFound() throws Exception {
//
//        //output ext api
//        responseFiduciaObj responseObj = new responseFiduciaObj();
//
//        responseObj.setRespHttpCode("400");
//        responseObj.setRespHttpMessage("Not Found");
//        responseObj.setData(Collections.emptyList());
//
//        String response = "NOT FOUND";
//
//        ResponseEntity result = new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        when(mstTransTypeRepository.findAll()).thenThrow(new RuntimeException());
//
//        ResponseEntity resp = findAllMstTransTypeService.findAllMstTransType();
//
//        System.out.println(resp);
//
//        verify(mstTransTypeRepository).findAll();
//        //Verify Result
////        assertNotNull(resp);
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//}
