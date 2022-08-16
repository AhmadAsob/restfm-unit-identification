package id.co.astra.fifgroup.project.restfm_unit_identification.service;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstOffice;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstOfficeRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstOfficeService;
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
public class findAllMstOfficeServiceImplTest {

    @Autowired
    findAllMstOfficeService findAllMstOfficeService;

    @MockBean
    MstOfficeRepository mstOfficeRepository;

    @Test
    public void dataFound() throws Exception {

        List<mstOffice> listBu = new ArrayList<>();;
        mstOffice bu = new mstOffice();
        bu.setOfficeCode("21400");
        bu.setOfficeName("PADANG");
        bu.setRegionalId("0032");
        bu.setRegionalName("SUMBAR");
        bu.setAddress1("JL AGUS SALIM 18");
        bu.setAddress2("PADANG");
        bu.setPhoneNo("0751-840400");
        bu.setLatitude(1);
        bu.setLongitude(100);
        listBu.add(bu);

        //output ext api
        JSONObject out = new JSONObject();
        out.put("officeCode","21400");
        out.put("officeName","PADANG");
        out.put("regionalId","0032");
        out.put("regionalName","SUMBAR");
        out.put("address1","JL AGUS SALIM 18");
        out.put("address","PADANG");
        out.put("phoneNo","0751-840400");
        out.put("latitude",1);
        out.put("longitude",100);

        //out Service
        when(mstOfficeRepository.findAll()).thenReturn(listBu);

        //Request and Get Result
        List<mstOffice> result = null;
        result = findAllMstOfficeService.findAllMstOfficeData();

        //Verify Result
        assertNotNull(result);

    }
}
