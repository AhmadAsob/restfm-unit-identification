package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("findAllMstZipService")
public interface findAllMstZipService {
    public ResponseEntity findAllMstZip(Integer page);
}
