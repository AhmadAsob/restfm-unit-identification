package id.co.astra.fifgroup.project.restfm_unit_identification.service;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstKelurahan;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstKelurahanRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstKelurahanService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
//@ActiveProfiles("test")
public class findAllMstKelurahanServiceImplTest {

    @Autowired
    findAllMstKelurahanService findAllMstKelurahanService;

    @MockBean
    MstKelurahanRepository mstKelurahanRepository;

    @Test
    public void dataFound() throws Exception {

        List<mstKelurahan> listBu = new ArrayList<>();
        mstKelurahan bu = new mstKelurahan();
        bu.setKelCode("0351415017");
        bu.setKelurahan("Kel Tampung");
        bu.setKecCode("0351415");
        listBu.add(bu);

        //ext out api
        JSONObject out = new JSONObject();
        out.put("kelCode","0351415017");
        out.put("kelurahan","Kel Tampung");
        out.put("kecCode","0351415");

        //out Service
        when(mstKelurahanRepository.findAll()).thenReturn(listBu);

        //Request and Get Result
        List<mstKelurahan> result = null;
        result = findAllMstKelurahanService.findAllMstKelurahanData();

        //Verify Result
        assertNotNull(result);

    }
}
