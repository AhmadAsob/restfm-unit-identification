package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.FsMstRegionalRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstRegionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("findAllMstRegionalServiceImpl")
public class findAllMstRegionalServiceImpl implements findAllMstRegionalService {

    @Autowired
    private FsMstRegionalRepository fsMstRegionalRepository;

    private HttpStatus StatusResponse;

    @Override
    public ResponseEntity findAllMstRegional(
//            String createDate, String modifyDate
    ) {
        responseFiduciaObj responseObj = new responseFiduciaObj();
//        if (createDate == "" && modifyDate == "") {
            try {
                responseObj.setRespHttpCode("200");
                responseObj.setRespHttpMessage("Succesfully");
                responseObj.setData(fsMstRegionalRepository.findAll());
                StatusResponse = HttpStatus.OK;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage(e.getMessage());
                StatusResponse = HttpStatus.BAD_REQUEST;
            }
//        } else if (modifyDate == null) {
//            try {
//                responseObj.setRespHttpCode("200");
//                responseObj.setRespHttpMessage("Succesfully");
//                responseObj.setData(fsMstRegionalRepository.findByCreateDateAndModifyDateIsNull(createDate));
//                StatusResponse = HttpStatus.OK;
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                responseObj.setRespHttpCode("400");
//                responseObj.setRespHttpMessage(e.getMessage());
//                StatusResponse = HttpStatus.BAD_REQUEST;
//            }
//        } else if (createDate == null) {
//            try {
//                responseObj.setRespHttpCode("200");
//                responseObj.setRespHttpMessage("Succesfully");
//                responseObj.setData(fsMstRegionalRepository.findByCreateTimestampIsNullAndUpdateTimestamp(modifyDate));
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
//                responseObj.setData(fsMstRegionalRepository.findByCreateTimestampAndUpdateTimestamp(createDate, modifyDate));
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
