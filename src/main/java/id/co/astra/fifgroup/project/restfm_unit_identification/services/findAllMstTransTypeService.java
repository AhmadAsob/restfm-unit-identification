package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstTransType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.geom.RectangularShape;
import java.util.List;

@Service("findAllMstTransTypeService")
public interface findAllMstTransTypeService {
    public List<mstTransType> findAllMstTransTypeData();

    public ResponseEntity findAllMstTransType();
}
