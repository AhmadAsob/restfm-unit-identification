package id.co.astra.fifgroup.project.restfm_unit_identification.service;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstEmployees;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstEmployeesRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstEmployeeService;
import oracle.jdbc.driver.json.binary.JsonpOsonObject;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
//@ActiveProfiles("test")
public class findAllMstEmployeeServiceImplTest {

    @Autowired
    findAllMstEmployeeService findAllMstEmployeeService;

    @MockBean
    MstEmployeesRepository mstEmployeesRepository;

    @Test
    public void dataFound() throws Exception {

        List<mstEmployees> listBu = new ArrayList<>();
        mstEmployees bu = new mstEmployees();
        bu.setEmplCode("10360");
        bu.setEmplBranch("27500");
        bu.setEmplPospopId("27500");
        bu.setEmplName("MHD. BASRI");
        bu.setEmplJob("J15");
        bu.setEmplStatus("PM");
        bu.setEmplSecujob("G00253");
        bu.setJobDescription("CREDIT APPLICATION PROCESSOR UF KP");
        listBu.add(bu);

        //output ext api
        JSONObject out = new JSONObject();
        out.put("emplCode","10360");
        out.put("emplBranch","27500");
        out.put("emplPospopId","27500");
        out.put("emplName","MHD. BASRI");
        out.put("emplJob","J15");
        out.put("emplStatus","PM");
        out.put("emplSecujob","G00253");
        out.put("jobDescription","CREDIT APPLICATION PROCESSOR UF KP");

        //out Service
        when(mstEmployeesRepository.findAll()).thenReturn(listBu);

        //Request and Get Result
        List<mstEmployees> resultBl = null;
        resultBl = findAllMstEmployeeService.findAllMstEmplooyeesData();

        //Verify Result
        assertNotNull(resultBl);

    }
}
