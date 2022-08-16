package id.co.astra.fifgroup.project.restfm_unit_identification.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMotifTrnService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.verify;

@WebMvcTest(findAllMotifTrnController.class)
@ActiveProfiles("test")
public class findAllMotifTrnControllerTest {


    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private findAllMotifTrnService findAllMotifTrnService;

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void dataFound() throws Exception {

        ResultActions resultActions;
        resultActions = mockMvc.perform(MockMvcRequestBuilders.get("/motifTrn/find-all").contentType(MediaType.APPLICATION_JSON));

        verify(findAllMotifTrnService).findAllTrnMotif();

        resultActions.andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }
}
