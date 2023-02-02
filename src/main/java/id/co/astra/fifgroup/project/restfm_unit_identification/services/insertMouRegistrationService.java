package id.co.astra.fifgroup.project.restfm_unit_identification.services;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.MouDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;

@Service("insertMouRegistrationService")
public interface insertMouRegistrationService {
    public ResponseEntity insertMouRegistration(MouDto mouDto);
}
