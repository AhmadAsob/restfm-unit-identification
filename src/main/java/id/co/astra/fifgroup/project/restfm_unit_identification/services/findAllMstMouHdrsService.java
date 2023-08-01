package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("findAllMstMouHdrsService")
public interface findAllMstMouHdrsService {
    public ResponseEntity findAllMstMouHdrs(
//            String createDate, String modifyDate,
            int page);
}
