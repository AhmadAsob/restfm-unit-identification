package id.co.astra.fifgroup.project.restfm_unit_identification.gateway;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl.motifLogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class getTokenGateway {

    @Autowired
    public motifLogServiceImpl motifLog;

    private RestTemplate restTemplate = new RestTemplate();

    private ObjectMapper mapper = new ObjectMapper();

    private String generateToken;

    @Value("${url.APITokenRepo}")
    private String urlRepo;

    @Value("${repo.clientId}")
    private String clientIdRepo;

    @Value("${repo.clientSecret}")
    private String clientSecretRepo;

    @Value("${repo.grantType}")
    private String grantTypeRepo;

    @Value("${repo.username}")
    private String usernameRepo;

    @Value("${repo.password}")
    private String passwordRepo;

    @Value("${code.FiduciaRepo}")
    private String categoryFiduciaRepo;

    @Value("${ws.createby}")
    private String createby;

    @Scheduled(fixedDelay = 1500000) //milisecond
    public String getToken() throws JsonProcessingException {
        String access_token = "";
        try{
            HttpHeaders keycloakHeaders = new HttpHeaders();
            keycloakHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            keycloakHeaders.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("grant_type",grantTypeRepo);
            map.add("client_id",clientIdRepo);
            map.add("client_secret",clientSecretRepo);
            map.add("password",passwordRepo);
            map.add("username",usernameRepo);
            HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<>(map, keycloakHeaders);

            String tokenget = restTemplate.exchange(urlRepo, HttpMethod.POST, entity , String.class).getBody();

            JsonNode rootNode = mapper.readTree(tokenget);
            access_token = rootNode.get("access_token").asText();
            generateToken = "Bearer " + access_token;
        }catch (Exception e){
            motifLog.insertLogMotif("","","Get Token API Repo", "Failed", "Error : " + e.getMessage(),"");
        }
        return generateToken;
    }
}
