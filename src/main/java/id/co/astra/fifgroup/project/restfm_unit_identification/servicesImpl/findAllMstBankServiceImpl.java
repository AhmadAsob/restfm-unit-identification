package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;



import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstBank;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstBankRepo;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstBankServiceImpl")
public class findAllMstBankServiceImpl implements findAllMstBankService {

    @Autowired
    private MstBankRepo mstBankRepo;

    private HttpStatus StatusResponse;

    @Override
    public List<mstBank> findAllMstBankData() {
        return mstBankRepo.findAll();
    }

    public ResponseEntity findAllMstBank(){
        responseFiduciaObj responseObj = new responseFiduciaObj();

        responseObj.setRespHttpCode("200");
        responseObj.setRespHttpMessage("Succesfully");
        responseObj.setData(mstBankRepo.findAll());
        StatusResponse = HttpStatus.OK;
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
