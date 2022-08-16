package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstOffice;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstOfficeRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstOfficeServiceImpl")
public class findAllMstOfficeServiceImpl implements findAllMstOfficeService {

    @Autowired
    private MstOfficeRepository mstOfficeRepository;

    private HttpStatus StatusResponse;

    @Override
    public List<mstOffice> findAllMstOfficeData(){
        return mstOfficeRepository.findAll();
    }

    public ResponseEntity findAllMstOffice(){
        responseFiduciaObj responseObj = new responseFiduciaObj();

        responseObj.setRespHttpCode("200");
        responseObj.setRespHttpMessage("Succesfully");
        responseObj.setData(mstOfficeRepository.findAll());
        StatusResponse = HttpStatus.OK;
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
