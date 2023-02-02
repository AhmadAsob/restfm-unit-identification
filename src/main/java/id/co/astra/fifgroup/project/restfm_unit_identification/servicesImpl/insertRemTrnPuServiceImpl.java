package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.RemTrnMotifPuInsertDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.RemTrnSkpcParamDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.RemTrnMotifPu;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.RemTrnMotifPuId;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.ArTrnSumContractRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.RemTrnMotifPuRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.insertRemTrnPuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service("insertRemTrnPuServiceImpl")
    public class insertRemTrnPuServiceImpl implements insertRemTrnPuService {

    @Autowired
    private RemTrnMotifPuRepository remTrnMotifPuRepository;

    @Autowired
    private ArTrnSumContractRepository arTrnSumContractRepository;

    private HttpStatus StatusResponse;

    public ResponseEntity insertRemTrnPu(RemTrnMotifPuInsertDto remTrnMotifPuInsertDto) {
        responseObj responseObj = new responseObj();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");


//        RemTrnMotifPu remTrnMotifPu = remTrnMotifPuInsertDto.convert();
        RemTrnMotifPuId remTrnMotifPuId = new RemTrnMotifPuId();
        remTrnMotifPuId.setPcId(remTrnMotifPuInsertDto.getPcId());
        if (remTrnMotifPuId.getPcId() == null || remTrnMotifPuId.getPcId().equals("")) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Pc Id can't null");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
            remTrnMotifPuId.setCreatedTimestamp(LocalDateTime.now());
        remTrnMotifPuId.setContractNo(remTrnMotifPuInsertDto.getContractNo());

        RemTrnMotifPu remTrnMotifPu = new RemTrnMotifPu();
        remTrnMotifPu.setId(remTrnMotifPuId);
        if (remTrnMotifPuRepository.getByPcIdAndContractNoAndBapkpNoAndStatus(remTrnMotifPuId.getPcId(), remTrnMotifPuId.getContractNo(), remTrnMotifPuInsertDto.getBapkpNo(), remTrnMotifPu.getStatus()) != null) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Data Already Exist");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
            remTrnMotifPu.setPalNo(remTrnMotifPuInsertDto.getPalNo());
            if (remTrnMotifPu.getPalNo() == null || remTrnMotifPu.getPalNo().equals("")){
                remTrnMotifPu.setPalNo(arTrnSumContractRepository.currPalNo(remTrnMotifPuInsertDto.getContractNo()));
            }
        remTrnMotifPu.setOfficeCode(remTrnMotifPuInsertDto.getOfficeCode());
        if (remTrnMotifPu.getOfficeCode() == null || remTrnMotifPu.getOfficeCode().equals("")) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Office Code can't null");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
        remTrnMotifPu.setEmplCode(remTrnMotifPuInsertDto.getEmplCode());
        if (remTrnMotifPuInsertDto.getType() == "PICKUP" && remTrnMotifPu.getEmplCode().equals("")) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Empl Code can't null");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
            if (remTrnMotifPuInsertDto.getType() == "PICKUP" && remTrnMotifPu.getEmplCode() == null) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Empl Code can't null");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
                if (remTrnMotifPuInsertDto.getType() != "PICKUP"){
                    remTrnMotifPu.setEmplCode(null);
                }
        remTrnMotifPu.setEmplName(remTrnMotifPuInsertDto.getEmplName());
        if (remTrnMotifPu.getEmplName() == null || remTrnMotifPu.getEmplName().equals("")) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Empl Name can't null");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
        remTrnMotifPu.setType(remTrnMotifPuInsertDto.getType());
        if (remTrnMotifPu.getType() == null || remTrnMotifPu.getType().equals("")) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Type can't null");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
            remTrnMotifPu.setNominalPembayaran(remTrnMotifPuInsertDto.getNominalPembayaran());
            if (remTrnMotifPu.getNominalPembayaran().equals("") && remTrnMotifPuInsertDto.getType().equals("BAYAR")) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Nominal Pembayaran can't null");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
                if (remTrnMotifPuInsertDto.getType().equals("BAYAR")){

                    remTrnMotifPu.setNominalPembayaran(remTrnMotifPuInsertDto.getNominalPembayaran());
                } else {
                    remTrnMotifPu.setNominalPembayaran(null);
                }

        remTrnMotifPu.setAlasan(remTrnMotifPuInsertDto.getAlasan());
        if (remTrnMotifPu.getAlasan() == null || remTrnMotifPu.getAlasan().equals("")) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Alasan can't null");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
        remTrnMotifPu.setCreatedBy(null);
                if (remTrnMotifPuInsertDto.getType().equals("PICKUP")){
                    if (remTrnMotifPuInsertDto.getBapkpNo().equals("")){
                        responseObj.setRespHttpCode("400");
                        responseObj.setRespHttpMessage("Bapkp No can't null");
                        StatusResponse = HttpStatus.BAD_REQUEST;
                    } else {
                        remTrnMotifPu.setBapkpNo(remTrnMotifPuInsertDto.getBapkpNo());
                        remTrnMotifPu.setStatus(remTrnMotifPuInsertDto.getStatus());
                        if (remTrnMotifPu.getStatus() == null || remTrnMotifPu.getStatus().equals("")) {
                            responseObj.setRespHttpCode("400");
                            responseObj.setRespHttpMessage("Status can't null");
                            StatusResponse = HttpStatus.BAD_REQUEST;
                        }

                        remTrnMotifPu.setUpdatedBy(null);
                        remTrnMotifPu.setUpdatedTimestamp(null);

                        remTrnMotifPuRepository.save(remTrnMotifPu);

                        responseObj.setRespHttpCode("200");
                        responseObj.setRespHttpMessage("Succesfully");
                        StatusResponse = HttpStatus.OK;
                    }

                } else {
                        remTrnMotifPu.setBapkpNo(null);

                remTrnMotifPu.setStatus(remTrnMotifPuInsertDto.getStatus());
                if (remTrnMotifPu.getStatus() == null || remTrnMotifPu.getStatus().equals("")) {
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage("Status can't null");
                    StatusResponse = HttpStatus.BAD_REQUEST;
                }

        remTrnMotifPu.setUpdatedBy(null);
        remTrnMotifPu.setUpdatedTimestamp(null);

        remTrnMotifPuRepository.save(remTrnMotifPu);

        responseObj.setRespHttpCode("200");
        responseObj.setRespHttpMessage("Succesfully");
        StatusResponse = HttpStatus.OK;
        }}}}}}}}}}

        return new ResponseEntity(responseObj, StatusResponse);
    }

    @Override
    public ResponseEntity getByContractNoAndBapkpNo(RemTrnSkpcParamDto remTrnSkpcParamDto) {
        responseFiduciaObj responseObj = new responseFiduciaObj();
        try {
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            responseObj.setData(remTrnMotifPuRepository.getByContractNoAndBapkpNo(remTrnSkpcParamDto.getContractNo(), remTrnSkpcParamDto.getBapkpNo()));
            StatusResponse = HttpStatus.OK;
        } catch (Exception e) {

            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }

    @Override
    public ResponseEntity changeStatus(String idcontractNo) {
        responseObj responseObj = new responseObj();
        RemTrnMotifPu remTrnMotifPu = remTrnMotifPuRepository.getByIdContractNo(idcontractNo);

        if (remTrnMotifPu.getStatus().equals("CL")) {
            remTrnMotifPuRepository.updateByIdContractNo(idcontractNo);
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            StatusResponse = HttpStatus.OK;


        } else {
            try {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Status is not " + "CL");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } catch (Exception e){
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("the wrong contractNo you entered, please check again");
                StatusResponse = HttpStatus.BAD_REQUEST;
            }
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }

    @Override
    public ResponseEntity getByContractNo(RemTrnMotifPuInsertDto remTrnMotifPuInsertDto) {
        responseFiduciaObj responseObj = new responseFiduciaObj();
        try {
            List<RemTrnMotifPu> data =  remTrnMotifPuRepository.findData(remTrnMotifPuInsertDto.getPcId(), remTrnMotifPuInsertDto.getContractNo());
            if (data != null) {
                responseObj.setRespHttpCode("200");
                responseObj.setRespHttpMessage("Succesfully");
                responseObj.setData(data);
                StatusResponse = HttpStatus.OK;

            } else {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Data not found");
                StatusResponse = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e) {

            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }

}
