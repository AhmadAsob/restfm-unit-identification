package id.co.astra.fifgroup.project.restfm_unit_identification.service;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstMouHdrs;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstMouHdrsRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstMouHdrsService;
import org.apache.tomcat.jni.Local;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
//@ActiveProfiles("test")
public class findAllMstMouHdrsServiceImplTest {

    @Autowired
    findAllMstMouHdrsService findAllMstMouHdrsService;

    @MockBean
    MstMouHdrsRepository mstMouHdrsRepository;

    @Test
    public void dataFound() throws Exception {

        List<mstMouHdrs> listBu = new ArrayList<>();
        mstMouHdrs bu = new mstMouHdrs();
        bu.setMouNo("RK10100001011007");
        bu.setMouDate(LocalDate.of(2007,10,1));
        bu.setDescription(null);
        bu.setStartDate(LocalDate.of(2007,10,1));
        bu.setEndDate(LocalDate.of(2008,10,1));
        bu.setStatus("CL");
        bu.setCreatedBy("MIG");
        bu.setCreatedTimestamp(LocalDate.from(LocalDateTime.of(2008,04,1,9,18,38)));
        bu.setLastUpdateBy("SYSTEM");
        bu.setLastUpdateTimestamp(LocalDate.from(LocalDateTime.of(2008,10,02,3,57,2)));
        bu.setMouType("RK");
        bu.setSuplCode("VS-23344");
        bu.setOfficeCode("10100");
        bu.setSuplRevisePrice("N");
        bu.setAdminFee(125000);
        bu.setReason(null);
        bu.setCoyId("01");
        bu.setOffsetFlag("N");
        bu.setBigbuyerFlag("N");
        bu.setRefinancingFlag("N");
        bu.setRemarksCt(null);
        listBu.add(bu);

        //output ext api
        JSONObject out = new JSONObject();
        out.put("mouNo", "RK10100001011007");
        out.put("mouDate",LocalDate.of(2007,10,01));
        out.put("description", null);
        out.put("startDate", LocalDate.of(2007,10,01));
        out.put("endDate", LocalDate.of(2008,10,01));
        out.put("status","CL");
        out.put("createdBy","MIG");
        out.put("createdTimestamp",LocalDate.from(LocalDateTime.of(2008,04,01,9,18,38)));
        out.put("lastUpdateBy","SYSTEM");
        out.put("lastUpdateTimestamp",LocalDate.from(LocalDateTime.of(2008,10,02,03,57,02)));
        out.put("mouType","RK");
        out.put("suplCode","VS-23344");
        out.put("officeCode","10100");
        out.put("suplRevisePrice","N");
        out.put("adminFee",125000);
        out.put("reason",null);
        out.put("coyId","01");
        out.put("offsetFlag","N");
        out.put("bigBuyerFlag","N");
        out.put("refinancingFlag","N");
        out.put("remarks",null);

        //out Service
        when(mstMouHdrsRepository.findAll()).thenReturn(listBu);

        //Request and Get Result
        List<mstMouHdrs> result = null;
        result = findAllMstMouHdrsService.findAllMstMouHdrsData();

        //Verify Result
        assertNotNull(result);

    }
}
