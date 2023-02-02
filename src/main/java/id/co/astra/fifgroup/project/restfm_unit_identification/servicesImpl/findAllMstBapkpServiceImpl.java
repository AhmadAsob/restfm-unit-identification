package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.mstBapkpDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstBapkp;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstBapkpRepo;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstBapkpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.format.ResolverStyle;

@Service("findAllMstBapkpServiceImpl")
public class findAllMstBapkpServiceImpl implements findAllMstBapkpService {

    @Autowired
    private MstBapkpRepo mstBapkpRepo;

    private HttpStatus StatusResponse;

    @Value("${pageLimit.bapkp}")
    private int pageLimit;

    @Override
    public ResponseEntity findAllMstBapkpByFilter(String bastbjOnHand, String bastbjStatus){
        responseFiduciaObj responseObj = new responseFiduciaObj();
        try{
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            responseObj.setData(mstBapkpRepo.findBapkpByBastbjOnHandAndBastbjStatus(bastbjOnHand, bastbjStatus));
            StatusResponse = HttpStatus.OK;
        } catch (Exception e){
            System.out.println(e.getMessage());
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }

    @Override
    public ResponseEntity findAllMstBapkp(Integer page){
        responseFiduciaObj responseObj = new responseFiduciaObj();
        try{
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            responseObj.setData(mstBapkpRepo.findAll(PageRequest.of(page-1, pageLimit)));
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
