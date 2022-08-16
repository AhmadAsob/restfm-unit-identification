package id.co.astra.fifgroup.project.restfm_unit_identification.service;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstNpwpKpp;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstNpwpKppRepo;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstNpwpService;
import org.json.JSONException;
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
public class findAllMstNpwpServiceImplTest {

    @Autowired
    findAllMstNpwpService findAllMstNpwpService;

    @MockBean
    MstNpwpKppRepo mstNpwpKppRepo;

    @Test
    public void dataFound() throws Exception {

        List<mstNpwpKpp> listBu = new ArrayList<>();
        mstNpwpKpp bu = new mstNpwpKpp();
        bu.setNpwpKppId("101");
        bu.setNpwpKppArea("SUMUT");
        bu.setNpwpKppName("KPP Binjai");
        bu.setNpwpKppWorkingArea("Kota Binjai  Kab. Langkat  Kec. Labuhan Deli  Kec. Sunggal  Kec. Pancur Batu  Kec. Hamparan Perak  Kec. Sibolangit  Kec. Kutalimbaru  Kab. Tanah Karo");
        listBu.add(bu);

        //output ext api
        JSONObject out = new JSONObject();
        out.put("npwpKppId", "101");
        out.put("npwpKppArea", "SUMUT");
        out.put("npwpKppName", "KPP Binjai");
        out.put("npwpKppWorkingArea", "Kota Binjai  Kab. Langkat  Kec. Labuhan Deli  Kec. Sunggal  Kec. Pancur Batu  Kec. Hamparan Perak  Kec. Sibolangit  Kec. Kutalimbaru  Kab. Tanah Karo");

        //out Service
        when(mstNpwpKppRepo.findAll()).thenReturn(listBu);

        //Request and get result
        List<mstNpwpKpp> resultBl = null;
        resultBl = findAllMstNpwpService.findAllMstNpwpData();

        assertNotNull(resultBl);

    }
}
