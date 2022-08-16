package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstKecamatan;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstKecamatanService")
public interface findAllMstKecamatanService {
    public List<mstKecamatan> findAllMstKecamatanData();

    public ResponseEntity findAllMstKecamatan();
}
