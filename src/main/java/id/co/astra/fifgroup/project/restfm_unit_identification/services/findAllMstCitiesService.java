package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("findAllMstCitiesService")
public interface findAllMstCitiesService {
    public ResponseEntity findAllMstCities();
}
