package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.remTrnMotifBuckets;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;
import java.util.List;

@Service("findAllMotifTrnService")
public interface findAllMotifTrnService {
    public ResponseEntity findAllTrnMotif();

}
