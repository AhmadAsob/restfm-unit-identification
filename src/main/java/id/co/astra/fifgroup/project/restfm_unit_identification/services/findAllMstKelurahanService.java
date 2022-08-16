package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstKelurahan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstKelurahanService")
public interface findAllMstKelurahanService {
    public List<mstKelurahan> findAllMstKelurahanData();

    public ResponseEntity findAllMstKelurahan();
}
