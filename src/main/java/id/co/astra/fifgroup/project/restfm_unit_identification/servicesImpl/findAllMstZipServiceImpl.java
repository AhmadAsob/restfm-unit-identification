package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstZip;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstZipRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstZipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstZipServiceImpl")
public class findAllMstZipServiceImpl implements findAllMstZipService {

    @Autowired
    private MstZipRepository mstZipRepository;

    private HttpStatus StatusResponse;

    @Override
    public List<mstZip> findAllMstZipData(){
        return mstZipRepository.findAll();
    }

    public ResponseEntity findAllMstZip(){
        responseFiduciaObj responseObj = new responseFiduciaObj();

        responseObj.setRespHttpCode("200");
        responseObj.setRespHttpMessage("Succesfully");
        responseObj.setData(mstZipRepository.findAll());
        StatusResponse = HttpStatus.OK;
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
