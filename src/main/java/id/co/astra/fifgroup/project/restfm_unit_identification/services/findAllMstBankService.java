package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("findAllMstBankService")
public interface findAllMstBankService {
    public ResponseEntity findAllMstBank();


}
