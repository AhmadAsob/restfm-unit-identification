package id.co.astra.fifgroup.project.restfm_unit_identification.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

@Service("getFiduciaServices")
public interface getFiduciaServices {

    public ResponseEntity getfiducia(String contractNo, String requestBy);
}