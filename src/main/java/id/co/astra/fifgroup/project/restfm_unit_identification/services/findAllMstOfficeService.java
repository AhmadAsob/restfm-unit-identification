package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstOffice;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service("findAllMstOfficeService")
public interface findAllMstOfficeService {
    public ResponseEntity findAllMstOffice(Integer page);
}
