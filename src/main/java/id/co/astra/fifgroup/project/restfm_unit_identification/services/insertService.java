package id.co.astra.fifgroup.project.restfm_unit_identification.services;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.InsertDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("insertService")
public interface insertService {
    public ResponseEntity insertService(InsertDto insertDto);
}
