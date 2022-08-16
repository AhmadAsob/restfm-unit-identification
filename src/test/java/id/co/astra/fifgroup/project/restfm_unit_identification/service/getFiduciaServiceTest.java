package id.co.astra.fifgroup.project.restfm_unit_identification.service;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.remWsMotifLog;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class getFiduciaServiceTest {

    @Autowired
    private getFiduciaServiceTest getFiduciaServiceTest;

    @MockBean
    private remWsMotifLog remWsMotifLog;

    @Test
    public void getFiducia_Found() throws Exception{
        //input
        JSONObject jsonIn = new JSONObject();
        jsonIn.put("idFiducia", "e7226e46-6035-4e21-8253-30e372872462");
        jsonIn.put("mime","application/pdf");
    }
}
