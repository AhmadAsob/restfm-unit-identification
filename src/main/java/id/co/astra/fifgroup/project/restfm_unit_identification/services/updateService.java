package id.co.astra.fifgroup.project.restfm_unit_identification.services;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.InsertDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("updateService")
public interface updateService {
    public ResponseEntity update(String suplCode, InsertDto insertDto);
}
