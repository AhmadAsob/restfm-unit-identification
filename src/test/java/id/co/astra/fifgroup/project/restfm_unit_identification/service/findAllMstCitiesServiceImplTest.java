//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.mstCities;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifAppsRepo.MstCitiesRepository;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstCitiesService;
//import org.json.JSONObject;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ActiveProfiles;
//import springfox.documentation.spring.web.readers.operation.ResponseMessagesReader;
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
//public class findAllMstCitiesServiceImplTest {
//
//    @Autowired
//    findAllMstCitiesService findAllMstCitiesService;
//
//    @MockBean
//    MstCitiesRepository mstCitiesRepository;
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<mstCities> listBu = new ArrayList<>();
//        mstCities bu =new mstCities();
//        bu.setCityCode("09201");
//        bu.setCity("Kabupaten Sorong");
//        bu.setProvCode("092");
//        listBu.add(bu);
//
//        //out ext api
//        responseFiduciaObj responseObj = new responseFiduciaObj();
//
//        responseObj.setRespHttpCode("200");
//        responseObj.setRespHttpMessage("Succesfully");
//        responseObj.setData(listBu);
//
//        //out Service
//        when(mstCitiesRepository.findAll()).thenReturn(listBu);
//
//        //Request and Get Result
//        ResponseEntity result = findAllMstCitiesService.findAllMstCities();
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
//        when(mstCitiesRepository.findAll()).thenThrow(new RuntimeException());
//
//        ResponseEntity resp = findAllMstCitiesService.findAllMstCities();
//
//        System.out.println(resp);
//
//        verify(mstCitiesRepository).findAll();
//        //Verify Result
////        assertNotNull(resp);
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//}
