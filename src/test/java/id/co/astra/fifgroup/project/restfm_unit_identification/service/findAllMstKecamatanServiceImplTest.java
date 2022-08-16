package id.co.astra.fifgroup.project.restfm_unit_identification.service;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstKecamatan;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstKecamatanRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstKecamatanService;
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
public class findAllMstKecamatanServiceImplTest {

    @Autowired
    findAllMstKecamatanService findAllMstKecamatanService;

    @MockBean
    MstKecamatanRepository mstKecamatanRepository;

    @Test
    public void dataFound() throws Exception{

        List<mstKecamatan> listBu = new ArrayList<>();
        mstKecamatan bu = new mstKecamatan();
        bu.setKecCode("3175010");
        bu.setKecamatan("Kec Pasar Rebo");
        bu.setCityCode("3175");
        listBu.add(bu);

        //out ext api
        JSONObject out = new JSONObject();
        out.put("kecCode","3175010");
        out.put("kecamatan","Kec Pasar Rebo");
        out.put("cityCode","3175");

        //out Service
        when(mstKecamatanRepository.findAll()).thenReturn(listBu);

        //Request and Get Result
        List<mstKecamatan> result = null;
        result = findAllMstKecamatanService.findAllMstKecamatanData();

        //Verify Result
        assertNotNull(result);

    }
}
