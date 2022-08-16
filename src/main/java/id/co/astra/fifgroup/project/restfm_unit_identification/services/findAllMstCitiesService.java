package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstCities;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstCitiesService")
public interface findAllMstCitiesService {
    public List<mstCities> findAllMstCitiesData();

    public ResponseEntity findAllMstCities();
}
