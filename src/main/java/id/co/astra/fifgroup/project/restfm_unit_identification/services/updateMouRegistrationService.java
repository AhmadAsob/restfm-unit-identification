package id.co.astra.fifgroup.project.restfm_unit_identification.services;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.MouDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("updateMouRegistrationService")
public interface updateMouRegistrationService {
    public ResponseEntity updateMouRegistration(String mouId, MouDto mouDto);
}
