package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstMouHdrs;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstMouHdrsRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstMouHdrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstMouHdrsServiceImpl")
public class findAllMstMouHdrsServiceImpl implements findAllMstMouHdrsService {

    @Autowired
    private MstMouHdrsRepository mstMouHdrsRepository;

    private HttpStatus StatusResponse;

    @Override
    public List<mstMouHdrs> findAllMstMouHdrsData(){
        return mstMouHdrsRepository.findAll();
    }

    public ResponseEntity findAllMstMouHdrs(){
        responseFiduciaObj responseObj = new responseFiduciaObj();

        responseObj.setRespHttpCode("200");
        responseObj.setRespHttpMessage("Succesfully");
        responseObj.setData(mstMouHdrsRepository.findAll());
        StatusResponse = HttpStatus.OK;
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
