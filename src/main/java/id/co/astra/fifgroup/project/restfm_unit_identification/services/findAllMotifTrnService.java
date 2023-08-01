package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("findAllMotifTrnService")
public interface findAllMotifTrnService {
    public ResponseEntity findAllTrnMotif();

}
