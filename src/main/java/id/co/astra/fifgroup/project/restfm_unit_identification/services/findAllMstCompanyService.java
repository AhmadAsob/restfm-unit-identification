package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstCompany;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstCompany")
public interface findAllMstCompanyService {
    public List<mstCompany> findAllMstCompanyData();

    public ResponseEntity findAllMstCompany();
}
