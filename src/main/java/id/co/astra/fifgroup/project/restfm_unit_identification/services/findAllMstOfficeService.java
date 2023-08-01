package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("findAllMstOfficeService")
public interface findAllMstOfficeService {
    public ResponseEntity findAllMstOffice(Integer page);
}
