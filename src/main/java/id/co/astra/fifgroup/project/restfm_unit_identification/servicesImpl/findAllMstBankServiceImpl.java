package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;



import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifMotifRepo.StgBucketMotifTaskRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.MstBankRepo;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service("findAllMstBankServiceImpl")
public class findAllMstBankServiceImpl implements findAllMstBankService {

    @Autowired
    private MstBankRepo mstBankRepo;

    private HttpStatus StatusResponse;

    @Override
    public ResponseEntity findAllMstBank(){
        responseFiduciaObj responseObj = new responseFiduciaObj();
        try{
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            responseObj.setData(mstBankRepo.findAll());
            StatusResponse = HttpStatus.OK;
        } catch (Exception e){
            System.out.println(e.getMessage());
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity(responseObj, StatusResponse);
    }
}
