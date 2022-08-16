package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstZip;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.Response;
import java.util.List;

@Service("findAllMstZipService")
public interface findAllMstZipService {
    public List<mstZip> findAllMstZipData();

    public ResponseEntity findAllMstZip();
}
