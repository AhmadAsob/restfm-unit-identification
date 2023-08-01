package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.motif_TrnRepo;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMotifTrnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("findAllMotifTrnServiceImpl")
public class findAllMotifTrnServiceImpl implements findAllMotifTrnService {

    @Autowired
    private motif_TrnRepo motif_trnRepo;

    private HttpStatus StatusResponse;

    @Override
    public ResponseEntity findAllTrnMotif() {
        responseFiduciaObj responseObj = new responseFiduciaObj();
        try {
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            responseObj.setData(motif_trnRepo.findAll());
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