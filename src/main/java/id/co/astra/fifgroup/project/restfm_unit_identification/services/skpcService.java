package id.co.astra.fifgroup.project.restfm_unit_identification.services;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.skpcInputProcedure;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("skpcService")
public interface skpcService {
    public ResponseEntity skpcService(skpcInputProcedure skpcInputProcedure) ;
}
