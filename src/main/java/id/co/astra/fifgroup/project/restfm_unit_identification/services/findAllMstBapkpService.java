package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstBapkp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstBapkpService")
public interface findAllMstBapkpService {
    public List<mstBapkp> findAllMstBapkpData();

    public ResponseEntity findAllMstBapkp();
}
