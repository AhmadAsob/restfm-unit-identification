package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstOffice;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstOfficeRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstOfficeServiceImpl")
public class findAllMstOfficeServiceImpl implements findAllMstOfficeService {

    @Autowired
    private MstOfficeRepository mstOfficeRepository;

    private HttpStatus StatusResponse;

    @Value("${pageLimit.office}")
    private int pageLimit;

    @Override
    public ResponseEntity findAllMstOffice(Integer page){
        responseFiduciaObj responseObj = new responseFiduciaObj();
//        if  (createDate == "" && modifyDate == "") {
//            try {
//                responseObj.setRespHttpCode("200");
//                responseObj.setRespHttpMessage("Succesfully");
//                responseObj.setData(mstOfficeRepository.findAll(PageRequest.of(page, pageLimit)));
//                StatusResponse = HttpStatus.OK;
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                responseObj.setRespHttpCode("400");
//                responseObj.setRespHttpMessage(e.getMessage());
//                StatusResponse = HttpStatus.BAD_REQUEST;
//            }
//        } else if (modifyDate == null) {
//            try {
//                responseObj.setRespHttpCode("200");
//                responseObj.setRespHttpMessage("Succesfully");
//                responseObj.setData(mstOfficeRepository.findByCreateDateAndModifyDateIsNull(createDate, PageRequest.of(page, pageLimit)));
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
//                responseObj.setData(mstOfficeRepository.findByCreateTimestampIsNullAndUpdateTimestamp(modifyDate, PageRequest.of(page, pageLimit)));
//                StatusResponse = HttpStatus.OK;
//            } catch (Exception e) {
//                System.out.println(e.getMessage());
//                responseObj.setRespHttpCode("400");
//                responseObj.setRespHttpMessage(e.getMessage());
//                StatusResponse = HttpStatus.BAD_REQUEST;
//            }
//        } else {
            try {
                responseObj.setRespHttpCode("200");
                responseObj.setRespHttpMessage("Succesfully");
                responseObj.setData(mstOfficeRepository.findAll(PageRequest.of(page, pageLimit)));
                StatusResponse = HttpStatus.OK;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage(e.getMessage());
                StatusResponse = HttpStatus.BAD_REQUEST;
            }
//        }
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
