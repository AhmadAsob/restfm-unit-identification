package id.co.astra.fifgroup.project.restfm_unit_identification.service;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstBank;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstBankRepo;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstBankService;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
//@ActiveProfiles("test")
public class findAllMstBankServiceImplTest {

    @Autowired
    findAllMstBankService findAllMstBankService;

    @MockBean
    MstBankRepo mstBankRepo;

    @Test
    public void dataFound() throws Exception {

        //output
        List<mstBank> listBu = new ArrayList<>();
        mstBank bu = new mstBank();
        bu.setBankId("XX059");
        bu.setBankName("DANAHUTAMA");
        listBu.add(bu);

        //out Service
        when(mstBankRepo.findAll()).thenReturn(listBu);

        //Request and get result
        List<mstBank> resultBl = null;
        resultBl= findAllMstBankService.findAllMstBankData();

        assertNotNull(resultBl);
    }
}
