package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.MstTransTypeRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstTransTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("findAllMstTransTypeServiceImpl")
public class findAllMstTransTypeServiceImpl implements findAllMstTransTypeService {

    @Autowired
    private MstTransTypeRepository mstTransTypeRepository;

    private HttpStatus StatusResponse;

    @Override
    public ResponseEntity findAllMstTransType(){
        responseFiduciaObj responseObj = new responseFiduciaObj();
        try {
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            responseObj.setData(mstTransTypeRepository.findAll());
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
