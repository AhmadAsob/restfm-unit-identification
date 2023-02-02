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
    public ResponseEntity findAllMstCompany(
//            String createDate, String updateDate
    ){
        responseFiduciaObj responseObj = new responseFiduciaObj();
//        if  (createDate == "" && updateDate == "") {
        try {
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            responseObj.setData(mstCompanyRepository.findAll());
            StatusResponse = HttpStatus.OK;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }
//        } else if (updateDate == null) {
//            try {
//                responseObj.setRespHttpCode("200");
//                responseObj.setRespHttpMessage("Succesfully");
//                responseObj.setData(mstCompanyRepository.findByCreateDateAndUpdateDateIsNull(createDate));
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
//                responseObj.setData(mstCompanyRepository.findByCreateDateIsNullAndUpdateDate(updateDate));
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
//                responseObj.setData(mstCompanyRepository.findByCreateDateAndUpdateDate(createDate, updateDate));
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
