package id.co.astra.fifgroup.project.restfm_unit_identification.service;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstTransType;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstTransTypeRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstTransTypeService;
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
public class findAllMstTransTypeServiceImpl {

    @Autowired
    findAllMstTransTypeService findAllMstTransTypeService;

    @MockBean
    MstTransTypeRepository mstTransTypeRepository;

    @Test
    public void dataFound() throws Exception {

        List<mstTransType> listBu = new ArrayList<>();
        mstTransType bu = new mstTransType();
        bu.setTransType("ARTHAJASA");
        bu.setTransDesc("Kantor Pos Online");
        bu.setCreatedBy("9658");
        bu.setCreatedTimestamp(LocalDate.of(2008,04,01));
        bu.setGlCreatedName("CR Trans");
        bu.setAccountType1(null);
        bu.setAccountType2(null);
        bu.setAccountType3(null);
        bu.setAccountType4(null);
        bu.setAccountType5(null);
        bu.setModuleId(5);
        bu.setRvType("N");
        bu.setViaInterface("Y");
        listBu.add(bu);

        //output ext api
        JSONObject out = new JSONObject();
        out.put("transType","ARTHAJASA");
        out.put("transDesc","Kantor Pos Online");
        out.put("createdBy","9658");
        out.put("createdTimestamp","2008-04-01");
        out.put("glCreatedName","CR Trans");
        out.put("accountType1",null);
        out.put("accountType2",null);
        out.put("accountType3",null);
        out.put("accountType4",null);
        out.put("accountType5",null);
        out.put("moduleId",5);
        out.put("rvType", "N");
        out.put("viaInterface","Y");

        //out Service
        when(mstTransTypeRepository.findAll()).thenReturn(listBu);


        //Request and Get Result
        List<mstTransType> result = null;
        result = findAllMstTransTypeService.findAllMstTransTypeData();

        //Verify Result
        assertNotNull(result);

    }
}
