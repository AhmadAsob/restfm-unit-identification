package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstMouHdrs;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstMouHdrsService")
public interface findAllMstMouHdrsService {
    public List<mstMouHdrs> findAllMstMouHdrsData();

    public ResponseEntity findAllMstMouHdrs();
}
