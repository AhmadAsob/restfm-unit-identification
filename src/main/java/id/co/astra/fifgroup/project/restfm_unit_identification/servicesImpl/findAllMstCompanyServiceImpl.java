package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstCompany;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstCompanyRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstCompanyServiceImpl")
public class findAllMstCompanyServiceImpl implements findAllMstCompanyService {

    @Autowired
    private MstCompanyRepository mstCompanyRepository;

    private HttpStatus StatusResponse;

    @Override
    public List<mstCompany> findAllMstCompanyData(){
        return mstCompanyRepository.findAll();
    }

    public ResponseEntity findAllMstCompany(){
        responseFiduciaObj responseObj = new responseFiduciaObj();

        responseObj.setRespHttpCode("200");
        responseObj.setRespHttpMessage("Succesfully");
        responseObj.setData(mstCompanyRepository.findAll());
        StatusResponse = HttpStatus.OK;
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
