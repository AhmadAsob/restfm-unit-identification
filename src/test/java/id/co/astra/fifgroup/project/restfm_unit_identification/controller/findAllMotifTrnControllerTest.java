//package id.co.astra.fifgroup.project.restfm_unit_identification.controller;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
//import id.co.astra.fifgroup.project.restfm_unit_identification.entity.remTrnMotifBuckets;
//import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMotifTrnService;
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
//@WebMvcTest(findAllMotifTrnController.class)
//@ActiveProfiles("test")
//public class findAllMotifTrnControllerTest {
//
//
//    @Autowired
//    private MockMvc mockMvc;
//    @MockBean
//    private findAllMotifTrnService findAllMotifTrnService;
//
//
//    @Test
//    public void dataFound() throws Exception {
//
//        List<remTrnMotifBuckets> listBu = new ArrayList<>();
//        remTrnMotifBuckets bu = new remTrnMotifBuckets();
//        bu.setNoKontrak("709000645915");
//        bu.setCabangKontrak("PRAYA");
//        bu.setKodeCabangKontrak("70900");
//        bu.setNamaKonsumen("AGUS SUHARDI");
//        bu.setHariKeterlambatan(1092);
//        bu.setMerkMotor("HONDA");
//        bu.setModelMotor("BEATFIPOPCW");
//        bu.setWarnaMotor("HITAM");
//        bu.setTahunMotor(2015);
//        bu.setTanggalBayarTerakhir(LocalDate.of(2015,9,9));
//        bu.setHutangPokok(13543758);
//        bu.setNoMesin("JFS1E1103311");
//        bu.setNoRangka("MH1JFS118FK105270");
//        bu.setNoPolisi("DR3959TN");
//        bu.setNoFidusia("W2100032574AH0501-15");
//        bu.setAlamat("DUSUN LENDANG PAOK DESA SELEBUNG RT 000 RW 000 Kel Selebung Kec Batukliang Kab Lombok Tengah Prop Nusa Tenggara Barat 83555");
//        bu.setHp("087865186179");
//        listBu.add(bu);
//
//        responseFiduciaObj responseFiduciaObj = new responseFiduciaObj();
//        responseFiduciaObj.setRespHttpCode("200");
//        responseFiduciaObj.setRespHttpMessage("Successfully");
//        responseFiduciaObj.setData(listBu);
//
//        when(findAllMotifTrnService.findAllTrnMotif()).thenReturn(new ResponseEntity(responseFiduciaObj, HttpStatus.OK));
//
//        ResultActions resultActions;
//        resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/restfmui/v1/find-all-trn").contentType(MediaType.APPLICATION_JSON));
//
//        verify(findAllMotifTrnService).findAllTrnMotif();
//
//        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
//    }
//}
