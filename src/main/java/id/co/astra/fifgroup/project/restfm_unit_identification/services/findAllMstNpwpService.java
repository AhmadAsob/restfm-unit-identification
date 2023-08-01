package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("findAllMstNpwpService")
public interface findAllMstNpwpService {
    public ResponseEntity findAllMstNpwp();
}
