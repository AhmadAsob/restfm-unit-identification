package id.co.astra.fifgroup.project.restfm_unit_identification.service;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstJobCodes;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstJobCodesRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstJobCodesService;
import org.apache.tomcat.jni.Local;
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
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
//@ActiveProfiles("test")
public class findAllMstJobCodesServiceImplTest {

    @Autowired
    findAllMstJobCodesService findAllMstJobCodesService;

    @MockBean
    MstJobCodesRepository mstJobCodesRepository;

    @Test
    public void dataFound() throws Exception {

        List<mstJobCodes> listBu = new ArrayList<>();
        mstJobCodes bu = new mstJobCodes();
        bu.setJobCode("G00000");
        bu.setDescription("PRESIDENT DIRECTOR");
        bu.setOfficeCode("00001");
        bu.setCreatedBy("FIFDB");
        bu.setCreatedTimestamp(LocalDate.of(2006,02,18));
        bu.setLastupdateBy(null);
        bu.setLastupdateTimestamp(null);
        listBu.add(bu);

        //output ext api
        JSONObject out = new JSONObject();
        out.put("jobCode","G00000");
        out.put("description","PRESIDENT DIRECTOR");
        out.put("officeCode","00001");
        out.put("createdBy","FIFDB");
        out.put("createdTimestamp",LocalDate.of(2006,02,18));
        out.put("lastupdateBy",null);
        out.put("lastupdateTimestamp",null);

        //out Service
        when(mstJobCodesRepository.findAll()).thenReturn(listBu);

        //Request and Get Result
        List<mstJobCodes> result = null;
        result = findAllMstJobCodesService.findAllMstJobCodesData();

        //Verify Result
        assertNotNull(result);

    }
}
