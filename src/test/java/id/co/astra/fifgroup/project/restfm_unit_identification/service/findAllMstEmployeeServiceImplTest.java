//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.mstEmployees;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifAppsRepo.MstEmployeesRepository;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstEmployeeService;
//import oracle.jdbc.driver.json.binary.JsonpOsonObject;
//import org.json.JSONObject;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ActiveProfiles;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ActiveProfiles("unittest")
//public class findAllMstEmployeeServiceImplTest {
//
//    @Autowired
//    findAllMstEmployeeService findAllMstEmployeeService;
//
//    @MockBean
//    MstEmployeesRepository mstEmployeesRepository;
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
//        //output ext api
//        responseFiduciaObj responseObj = new responseFiduciaObj();
//
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Succesfully");
//        responseObj.setData(listBu);
//
//        //out Service
//        when(mstEmployeesRepository.findAll()).thenReturn(listBu);
//
//        //Request and Get Result
//        ResponseEntity result = findAllMstEmployeeService.findAllMstEmployees();
//        //Verify Result
//        assertNotNull(result);
//        assertEquals(result.getStatusCodeValue(),Integer.parseInt(responseObj.getRespHttpCode()));
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
//        when(mstEmployeesRepository.findAll()).thenThrow(new RuntimeException());
//
//        ResponseEntity resp = findAllMstEmployeeService.findAllMstEmployees();
//        System.out.println(resp);
//
//        verify(mstEmployeesRepository).findAll();
//        //Verify Result
////        assertNotNull(resp);
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//}
