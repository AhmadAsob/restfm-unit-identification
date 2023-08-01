package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("findAllMstTransTypeService")
public interface findAllMstTransTypeService {
    public ResponseEntity findAllMstTransType();
}
