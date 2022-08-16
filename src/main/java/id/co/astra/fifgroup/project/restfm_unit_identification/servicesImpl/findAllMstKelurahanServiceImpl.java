package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstKelurahan;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstKelurahanRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstKelurahanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstKelurahanServiceImpl")
public class findAllMstKelurahanServiceImpl implements findAllMstKelurahanService {

    @Autowired
    private MstKelurahanRepository mstKelurahanRepository;

    private HttpStatus StatusResponse;

    @Override
    public List<mstKelurahan> findAllMstKelurahanData(){
        return mstKelurahanRepository.findAll();
    }

    public ResponseEntity findAllMstKelurahan(){
        responseFiduciaObj responseObj = new responseFiduciaObj();

        responseObj.setRespHttpCode("200");
        responseObj.setRespHttpMessage("Succesfully");
        responseObj.setData(mstKelurahanRepository.findAll());
        StatusResponse = HttpStatus.OK;
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
