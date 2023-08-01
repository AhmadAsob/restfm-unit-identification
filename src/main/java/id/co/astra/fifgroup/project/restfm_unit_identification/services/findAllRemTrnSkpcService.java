package id.co.astra.fifgroup.project.restfm_unit_identification.services;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseSkpcProcedure;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllRemTrnSkpcService")
public interface findAllRemTrnSkpcService {
    public ResponseEntity findAllRemTrnSkpc(
//            String createdTimestamp, String lastUpdateTimestamp,
            Integer page);

    public List<responseSkpcProcedure> skpcProcedure(String skpcNo, String skpcDate, String skpcExpireDate, String pc, String contractNo, String type);
}
