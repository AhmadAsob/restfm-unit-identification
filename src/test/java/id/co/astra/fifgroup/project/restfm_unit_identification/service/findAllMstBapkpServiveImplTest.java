package id.co.astra.fifgroup.project.restfm_unit_identification.service;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstBapkp;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstBapkpRepo;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstBapkpService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
//@ActiveProfiles("test")
public class findAllMstBapkpServiveImplTest {

    @Autowired
    findAllMstBapkpService findAllMstBapkpService;

    @MockBean
    MstBapkpRepo mstBapkpRepo;

    @Test
    public void dataFound() throws Exception {

        List<mstBapkp> listBu = new ArrayList<>();
        mstBapkp bu = new mstBapkp();
        bu.setOfficeCode("21200");
        bu.setBastbjNo("2120014-000075");
        bu.setBastbjOnHand("O62802");
        bu.setBastbjDate(String.valueOf(LocalDateTime.of(2014,8,19,00,00,00)));
        bu.setBastbjStatus("VL");
        bu.setDistributionBy("23304");
        listBu.add(bu);

        //out service
        when(mstBapkpRepo.findAll()).thenReturn(listBu);

        //Request and Get Result
        List<mstBapkp> resultBl = null;
        resultBl = findAllMstBapkpService.findAllMstBapkpData();

        //Verify Result
        assertNotNull(resultBl);

    }
}
