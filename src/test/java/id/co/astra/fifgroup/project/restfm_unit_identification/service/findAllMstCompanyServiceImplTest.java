package id.co.astra.fifgroup.project.restfm_unit_identification.service;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstCompany;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstCompanyRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstCompanyService;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
//@ActiveProfiles("test")
public class findAllMstCompanyServiceImplTest {

    @Autowired
    findAllMstCompanyService findAllMstCompanyService;

    @MockBean
    MstCompanyRepository mstCompanyRepository;

    @Test
    public void dataFound() throws Exception {

        List<mstCompany> listBu = new ArrayList<>();
        mstCompany bu = new mstCompany();
        bu.setCoyId("01");
        bu.setCoyName("PT FEDERAL INTERNATIONAL FINANCE");
        bu.setSegementCoy("01");
        bu.setSetOfBookId("2021");
        bu.setCreateBy("1000");
        bu.setCreateDate(LocalDate.of(2007,3,20));
        bu.setUpdateBy("IRMA");
        bu.setUpdateDate(LocalDate.of(0007,5,2));
        bu.setSegmentNo(8);
        bu.setPrefJeCategory(null);
        bu.setDefaultPlatform("K");
        bu.setNameShort("FIF");
        listBu.add(bu);

        //output ext api
        JSONObject out = new JSONObject();
        out.put("coyId","01");
        out.put("coyName","PT FEDERAL INTERNATIONAL FINANCE");
        out.put("segementCoy","01");
        out.put("setOfBookId","2021");
        out.put("createBy","1000");
        out.put("createDate",LocalDate.of(2007,3,20));
        out.put("updateBy","IRMA");
        out.put("updateDate",LocalDate.of(0007,5,20));
        out.put("segmentNo",8);
        out.put("prefJeCategory",null);
        out.put("defaultPlatform","K");
        out.put("nameShort","FIF");

        //out Service
        when(mstCompanyRepository.findAll()).thenReturn(listBu);

        //Request and Get Result
        List<mstCompany> result = null;
        result = findAllMstCompanyService.findAllMstCompanyData();

        //Verify Result
        assertNotNull(result);

    }
}
