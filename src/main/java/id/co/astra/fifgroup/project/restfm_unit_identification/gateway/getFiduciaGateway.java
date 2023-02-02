package id.co.astra.fifgroup.project.restfm_unit_identification.gateway;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class    getFiduciaGateway {

    private RestTemplate restTemplate = new RestTemplate();

    @Value("${url.APIRepoList}")
    private String path;

    @Value("${reqId.repo}")
    private String reqId;

    @Value("${source.repo}")
    private String source;


    public String getId(String applNo, String requestBy, String generateToken){
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        httpHeaders.add(HttpHeaders.AUTHORIZATION, generateToken);

        HttpEntity<?> httpEntity = new HttpEntity<Object>(httpHeaders);

        return restTemplate.exchange(path, HttpMethod.POST,httpEntity,String.class, reqId,source,requestBy,applNo).getBody();
    }
}
