package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstBank;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstBankService")
public interface findAllMstBankService {
    public List<mstBank> findAllMstBankData();

    public ResponseEntity findAllMstBank();


}
