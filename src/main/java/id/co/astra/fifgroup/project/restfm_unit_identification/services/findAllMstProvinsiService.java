package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstProvinsi;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstProvinsiService")
public interface findAllMstProvinsiService {
    public ResponseEntity findAllMstProvinsi();

}
