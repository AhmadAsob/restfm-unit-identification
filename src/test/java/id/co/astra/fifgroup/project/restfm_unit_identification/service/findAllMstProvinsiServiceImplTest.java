package id.co.astra.fifgroup.project.restfm_unit_identification.service;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstProvinsi;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstProvinsiRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstProvinsiService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class findAllMstProvinsiServiceImplTest {

    @Autowired
    private findAllMstProvinsiService findAllMstProvinsiService;

    @MockBean
    private MstProvinsiRepository mstProvinsiRepository;

    @Test
    public void dataFound() throws Exception {

        List<mstProvinsi> listBu = new ArrayList<>();
        mstProvinsi bu = new mstProvinsi();
        bu.setProvinsi("Provinsi Aceh");
        bu.setProvCode("011");
        listBu.add(bu);

        //output ext api
        JSONObject out = new JSONObject();
        out.put("provCode", "011");
        out.put("provinsi", "Provinsi Aceh");

        //out Service
        when(mstProvinsiRepository.findAll()).thenReturn(listBu);

        //Request and get result
        List<mstProvinsi> resultBl = null;
        resultBl = findAllMstProvinsiService.findAllMstProvinsiData();

        assertNotNull(resultBl);
        assertEquals(resultBl.get(0).getProvCode(),out.get("provCode"));

    }
}
