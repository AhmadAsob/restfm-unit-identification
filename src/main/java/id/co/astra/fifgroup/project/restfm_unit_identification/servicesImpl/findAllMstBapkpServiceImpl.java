package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstBapkp;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstBapkpRepo;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstBapkpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstBapkpServiceImpl")
public class findAllMstBapkpServiceImpl implements findAllMstBapkpService {

    @Autowired
    private MstBapkpRepo mstBapkpRepo;

    private HttpStatus StatusResponse;

    @Override
    public List<mstBapkp> findAllMstBapkpData(){
        return mstBapkpRepo.findAll();
    }

    public ResponseEntity findAllMstBapkp(){
        responseFiduciaObj responseObj = new responseFiduciaObj();

        responseObj.setRespHttpCode("200");
        responseObj.setRespHttpMessage("Succesfully");
        responseObj.setData(mstBapkpRepo.findAll());
        StatusResponse = HttpStatus.OK;
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
