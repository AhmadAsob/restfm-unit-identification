package id.co.astra.fifgroup.project.restfm_unit_identification.services;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.postCloseSkpcInput;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("postCloseSkpcService")
public interface postCloseSkpcService {
    public ResponseEntity postCloseSkpc(postCloseSkpcInput postCloseDto);
}
