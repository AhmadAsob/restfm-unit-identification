//package id.co.astra.fifgroup.project.restfm_unit_identification.service;
//
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.RemTrnSkpc;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifAppsEntity.RemTrnSkpcId;
//import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifAppsRepo.RemTrnSKPCRepository;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllRemTrnSkpcService;
//import org.apache.tomcat.jni.Local;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.io.TempDir;
//import org.mockito.Mock;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.test.context.ActiveProfiles;
//
//import javax.xml.bind.SchemaOutputResolver;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.when;
//
//@SpringBootTest
//@ActiveProfiles("unittest")
//public class findAllRemTrnSkpcServiceTest {
//
//    @Autowired
//    findAllRemTrnSkpcService findAllRemTrnSkpcService;
//
//    @MockBean
//    RemTrnSKPCRepository remTrnSKPCRepository;
//
//    @Test
//    public void dataFound() throws Exception{
//
//        //output
//        List<RemTrnSkpc> listBu = new ArrayList<>();
//        RemTrnSkpc bu =  new RemTrnSkpc();
//        RemTrnSkpcId by = new RemTrnSkpcId();
//        by.setSkpcNo("1");
//        by.setSeqNo(1L);
//        bu.setId(by);
//        bu.setSkpcExpiredDate(LocalDate.of(2015,9,9));
//        bu.setPc("A");
//        bu.setContractNo("1");
//        bu.setStatusSkpc("A");
//        bu.setCreatedBy("A");
//        bu.setCreatedTimestamp(LocalDate.of(2015,9,9));
//        bu.setLastupdateBy("A");
//        bu.setLastupdateTimestamp(LocalDate.of(2015,9,9));
//        bu.setOfficeCode("1");
//        bu.setCoyId("1");
//        bu.setFreezeDate(LocalDate.of(2015,9,9));
//        bu.setPrintCtr(1L);
//        bu.setPalNo("1");
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
//        when(remTrnSKPCRepository.findAll()).thenReturn(Collections.emptyList());
//
//        //Request and Get Result
//
//        ResponseEntity result = findAllRemTrnSkpcService.findAllRemTrnSkpc();
//
//        verify(remTrnSKPCRepository).findAll();
//
//        //Verify Result
//        assertNotNull(result);
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//
//        System.out.println(result);
//    }
//
//    @Test
//    public void dataNotFoundd() throws Exception{
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
//        when(remTrnSKPCRepository.findAll()).thenThrow(new RuntimeException());
//
//        ResponseEntity resp = findAllRemTrnSkpcService.findAllRemTrnSkpc();
//
//        System.out.println(resp);
//
//        verify(remTrnSKPCRepository).findAll();
//
//        assertEquals(result.getStatusCodeValue(), Integer.parseInt(responseObj.getRespHttpCode()));
//    }
//}
