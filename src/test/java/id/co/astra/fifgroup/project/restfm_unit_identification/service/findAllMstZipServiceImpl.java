package id.co.astra.fifgroup.project.restfm_unit_identification.service;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstZip;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstZipRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstZipService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@SpringBootTest
//@ActiveProfiles("test")
public class findAllMstZipServiceImpl {

    @Autowired
    findAllMstZipService findAllMstZipService;

    @MockBean
    MstZipRepository mstZipRepository;

    @Test
    public void dataFound() throws Exception{

        List<mstZip> listBu = new ArrayList<>();
        mstZip bu = new mstZip();
        bu.setZipCode("10110");
        bu.setZipDesc("Kel Gambir Kec Gambir Kota Jakarta Pusat  Prov DKI Jakarta");
        bu.setProvCode("031");
        bu.setCityCode("03171");
        bu.setKecCode("0317101");
        bu.setKelCode("0317101001");
        listBu.add(bu);

        //Request and Get Result
        List<mstZip> result = null;
        result = findAllMstZipService.findAllMstZipData();

        //Verify Result
        assertNotNull(result);

    }
}
