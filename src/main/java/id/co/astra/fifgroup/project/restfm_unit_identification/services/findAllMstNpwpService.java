package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstNpwpKpp;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstNpwpService")
public interface findAllMstNpwpService {
    public List<mstNpwpKpp> findAllMstNpwpData();

    public ResponseEntity findAllMstNpwp();
}
