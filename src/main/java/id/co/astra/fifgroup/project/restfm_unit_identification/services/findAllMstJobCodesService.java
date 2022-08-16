package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstJobCodes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstJobCodesService")
public interface findAllMstJobCodesService {
    public List<mstJobCodes> findAllMstJobCodesData();

    public ResponseEntity findAllMstJobCodes();
}
