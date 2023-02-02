package id.co.astra.fifgroup.project.restfm_unit_identification.services;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.RemTrnSkpcDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("insertRemTrnSkpcService")
public interface insertRemTrnSkpcService {
    public ResponseEntity insertRemTrnSkpc(RemTrnSkpcDto remTrnSkpcDto);
}
