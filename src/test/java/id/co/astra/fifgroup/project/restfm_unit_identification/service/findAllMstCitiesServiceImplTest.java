package id.co.astra.fifgroup.project.restfm_unit_identification.service;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstCities;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstCitiesRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstCitiesService;
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
@ActiveProfiles("test")
public class findAllMstCitiesServiceImplTest {

    @Autowired
    findAllMstCitiesService findAllMstCitiesService;

    @MockBean
    MstCitiesRepository mstCitiesRepository;

    @Test
    public void dataFound() throws Exception {

        List<mstCities> listBu = new ArrayList<>();
        mstCities bu =new mstCities();
        bu.setCityCode("09201");
        bu.setCity("Kabupaten Sorong");
        bu.setProvCode("092");
        listBu.add(bu);

        //out Service
        when(mstCitiesRepository.findAll()).thenReturn(listBu);

        //Request and Get Result
        List<mstCities> resultBl = null;
        resultBl = findAllMstCitiesService.findAllMstCitiesData();

        //Verify Result
        assertNotNull(resultBl);

    }
}
