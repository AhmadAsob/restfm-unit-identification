package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstTransType;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstTransTypeRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstTransTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstTransTypeServiceImpl")
public class findAllMstTransTypeServiceImpl implements findAllMstTransTypeService {

    @Autowired
    private MstTransTypeRepository mstTransTypeRepository;

    private HttpStatus StatusResponse;

    @Override
    public List<mstTransType> findAllMstTransTypeData(){
        return mstTransTypeRepository.findAll();
    }

    public ResponseEntity findAllMstTransType(){
        responseFiduciaObj responseObj = new responseFiduciaObj();

        responseObj.setRespHttpCode("200");
        responseObj.setRespHttpMessage("Succesfully");
        responseObj.setData(mstTransTypeRepository.findAll());
        StatusResponse = HttpStatus.OK;
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
