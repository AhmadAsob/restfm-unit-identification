package id.co.astra.fifgroup.project.restfm_unit_identification.services;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.updateSendFlagDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("updateSendFlagService")
public interface updateSendFlagService {
    public ResponseEntity updateSendFlag(updateSendFlagDto dto);
}
