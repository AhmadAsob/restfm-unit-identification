package id.co.astra.fifgroup.project.restfm_unit_identification.services;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.uploadFileRegistrasidto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.uploadFileSKPCdto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.IOException;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

@Service("uploadFileServices")
public interface uploadFileServices {
    //upload File Registrasi
    public ResponseEntity uploadFileRegistrasi(uploadFileRegistrasidto uploadDataRegistrasi) throws IOException;

    //Upload File SKPC
    public ResponseEntity uploadFileSKPC(uploadFileSKPCdto uploadDataSKPC) throws IOException;


}
