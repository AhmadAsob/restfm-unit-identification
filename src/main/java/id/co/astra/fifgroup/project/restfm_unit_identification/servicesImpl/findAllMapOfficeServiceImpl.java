package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.CmMstCtrMapOfficeParamDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.CmMstCtrMapOfficeRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMapOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service("findAllMapOfficeServiceImpl")
public class findAllMapOfficeServiceImpl implements findAllMapOfficeService {

    @Autowired
    private CmMstCtrMapOfficeRepository cmMstCtrMapOfficeRepository;

    private HttpStatus StatusResponse;

    @Override
    public ResponseEntity findAllMapOffice(
//            String createDate, String modifyDate
    ){
        responseFiduciaObj responseObj = new responseFiduciaObj();
//        if  (createDate == "" && modifyDate == "") {
            try {
                responseObj.setRespHttpCode("200");
                responseObj.setRespHttpMessage("Succesfully");
                responseObj.setData(cmMstCtrMapOfficeRepository.findAll());
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
//                responseObj.setData(cmMstCtrMapOfficeRepository.findByCreateDateAndModifyDateIsNull(createDate));
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
//                responseObj.setData(cmMstCtrMapOfficeRepository.getByCreateDateIsNullAndModifyDate(modifyDate));
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
//                responseObj.setData(cmMstCtrMapOfficeRepository.getByCreateDateAndModifyDate(createDate, modifyDate));
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
