package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;



import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.MstJobCodesRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstJobCodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("findAllMstJobCodesServiceImpl")
public class findAllMstJobCodesServiceImpl implements findAllMstJobCodesService {

    @Autowired
    private MstJobCodesRepository mstJobCodesRepository;

    private HttpStatus StatusResponse;

    @Override
    public ResponseEntity findAllMstJobCodes(
//            String createTimestamp, String updateTimestamp
    ){
        responseFiduciaObj responseObj = new responseFiduciaObj();
//        if (createTimestamp == "" && updateTimestamp == "") {
            try {
                responseObj.setRespHttpCode("200");
                responseObj.setRespHttpMessage("Succesfully");
                responseObj.setData(mstJobCodesRepository.findAll());
                StatusResponse = HttpStatus.OK;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage(e.getMessage());
                StatusResponse = HttpStatus.BAD_REQUEST;
            }
//        } else if (updateTimestamp == null) {
//            try {
//                responseObj.setRespHttpCode("200");
//                responseObj.setRespHttpMessage("Succesfully");
//                responseObj.setData(mstJobCodesRepository.getByCreatedTimestampAndLastUpdateTimestampIsNull(createTimestamp));
//                StatusResponse = HttpStatus.OK;
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                responseObj.setRespHttpCode("400");
//                responseObj.setRespHttpMessage(e.getMessage());
//                StatusResponse = HttpStatus.BAD_REQUEST;
//            }
//        } else if (createTimestamp == null) {
//            try {
//                responseObj.setRespHttpCode("200");
//                responseObj.setRespHttpMessage("Succesfully");
//                responseObj.setData(mstJobCodesRepository.getByCreatedTimestampIsNullAndLastUpdateTimestamp(updateTimestamp));
//                StatusResponse = HttpStatus.OK;
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                responseObj.setRespHttpCode("400");
//                responseObj.setRespHttpMessage(e.getMessage());
//                StatusResponse = HttpStatus.BAD_REQUEST;
//            }
//        } else {
//            try {
//                responseObj.setRespHttpCode("200");
//                responseObj.setRespHttpMessage("Succesfully");
//                responseObj.setData(mstJobCodesRepository.getByCreatedTimestampAndLastUpdateTimestamp(createTimestamp, updateTimestamp));
//                StatusResponse = HttpStatus.OK;
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                responseObj.setRespHttpCode("400");
//                responseObj.setRespHttpMessage(e.getMessage());
//                StatusResponse = HttpStatus.BAD_REQUEST;
//            }
//        }
        return new ResponseEntity(responseObj, StatusResponse);
    }
}

