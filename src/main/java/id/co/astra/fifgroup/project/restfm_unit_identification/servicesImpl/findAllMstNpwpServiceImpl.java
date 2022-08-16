package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstNpwpKpp;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstNpwpKppRepo;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstNpwpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstNpwpServiceImpl")
public class findAllMstNpwpServiceImpl implements findAllMstNpwpService {

    @Autowired
    private MstNpwpKppRepo mstNpwpKppRepo;

    private HttpStatus StatusResponse;

    @Override
    public List<mstNpwpKpp> findAllMstNpwpData(){
        return mstNpwpKppRepo.findAll();
    }

    public ResponseEntity findAllMstNpwp(){
        responseFiduciaObj responseObj = new responseFiduciaObj();

        responseObj.setRespHttpCode("200");
        responseObj.setRespHttpMessage("Succesfully");
        responseObj.setData(mstNpwpKppRepo.findAll());
        StatusResponse = HttpStatus.OK;
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
