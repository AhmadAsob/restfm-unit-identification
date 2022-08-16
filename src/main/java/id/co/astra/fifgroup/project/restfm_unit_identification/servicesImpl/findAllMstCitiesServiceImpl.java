package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstCities;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstCitiesRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstCitiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstCitiesServiceImpl")
public class findAllMstCitiesServiceImpl implements findAllMstCitiesService {

    @Autowired
    private MstCitiesRepository mstCitiesRepository;

    private HttpStatus StatusResponse;

    @Override
    public List<mstCities> findAllMstCitiesData(){
        return mstCitiesRepository.findAll();
    }

    public ResponseEntity findAllMstCities(){
        responseFiduciaObj responseObj = new responseFiduciaObj();

        responseObj.setRespHttpCode("200");
        responseObj.setRespHttpMessage("Succesfully");
        responseObj.setData(mstCitiesRepository.findAll());
        StatusResponse = HttpStatus.OK;
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
