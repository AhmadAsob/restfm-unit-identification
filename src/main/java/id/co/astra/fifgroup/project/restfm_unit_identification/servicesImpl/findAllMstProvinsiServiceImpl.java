package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstProvinsi;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstProvinsiRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstProvinsiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstProvinsiServiceImpl")
public class findAllMstProvinsiServiceImpl implements findAllMstProvinsiService {

    @Autowired
    private MstProvinsiRepository mstProvinsiRepository;

    private HttpStatus StatusResponse;

    @Override
    public ResponseEntity findAllMstProvinsi(){
        responseFiduciaObj responseObj = new responseFiduciaObj();
        try {
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            responseObj.setData(mstProvinsiRepository.findAll());
            StatusResponse = HttpStatus.OK;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
