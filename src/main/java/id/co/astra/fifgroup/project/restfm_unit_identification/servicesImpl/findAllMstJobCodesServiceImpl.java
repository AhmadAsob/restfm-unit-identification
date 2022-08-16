package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;



import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstJobCodes;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstJobCodesRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstJobCodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstJobCodesServiceImpl")
public class findAllMstJobCodesServiceImpl implements findAllMstJobCodesService {

    @Autowired
    private MstJobCodesRepository mstJobCodesRepository;

    private HttpStatus StatusResponse;

    @Override
    public List<mstJobCodes> findAllMstJobCodesData(){
        return mstJobCodesRepository.findAll();
    }

    public ResponseEntity findAllMstJobCodes(){
        responseFiduciaObj responseObj = new responseFiduciaObj();

        responseObj.setRespHttpCode("200");
        responseObj.setRespHttpMessage("Succesfully");
        responseObj.setData(mstJobCodesRepository.findAll());
        StatusResponse = HttpStatus.OK;
        return new ResponseEntity(responseObj, StatusResponse);
    }
}

