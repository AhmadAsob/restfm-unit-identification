package id.co.astra.fifgroup.project.restfm_unit_identification.services;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.sendEmaildto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

@Service("sendEmailServices")
public interface sendEmailServices {
    public ResponseEntity sendEmail(sendEmaildto sendEmaildto);
}
