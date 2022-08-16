package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.remTrnMotifBuckets;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.motif_TrnRepo;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMotifTrnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMotifTrnServiceImpl")
public class findAllMotifTrnServiceImpl implements findAllMotifTrnService {

    @Autowired
    private motif_TrnRepo motif_trnRepo;

    private HttpStatus StatusResponse;

    @Override
    public List<remTrnMotifBuckets> findAllTrnMotifData(){
    return motif_trnRepo.findAll();
}

    public ResponseEntity findAllTrnMotif(){
        responseFiduciaObj responseObj = new responseFiduciaObj();

        responseObj.setRespHttpCode("200");
        responseObj.setRespHttpMessage("Succesfully");
        responseObj.setData(motif_trnRepo.findAll());
        StatusResponse = HttpStatus.OK;
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
