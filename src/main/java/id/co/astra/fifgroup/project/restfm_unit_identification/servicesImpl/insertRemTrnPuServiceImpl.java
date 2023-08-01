package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.*;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.ArTrnMotifResultAr;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.ArTrnMotifResultArId;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemTrnMotifPu;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemTrnMotifPuId;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FmUiEntity.taskRemFeeFif;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FmUiEntity.uiTrnRemFee;
import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.RemLogMotifErrGateway;
import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.getSumBayarGateway;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.ArTrnMotifResultArRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.ArTrnSumContractRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.RemTrnMotifPuRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FmUiRepo.TaskRemFeeFifRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FmUiRepo.UiMstParamRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FmUiRepo.UiTrnRemFeeRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.insertRemTrnPuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service("insertRemTrnPuServiceImpl")
    public class insertRemTrnPuServiceImpl implements insertRemTrnPuService {

    @Autowired
    private RemTrnMotifPuRepository remTrnMotifPuRepository;

    @Autowired
    private ArTrnSumContractRepository arTrnSumContractRepository;

    @Autowired
    private ArTrnMotifResultArRepository arTrnMotifResultArRepository;

    @Autowired
    private RemLogMotifErrGateway remLogMotifErrGateway;

    @Autowired
    private UiMstParamRepository uiMstParamRepository;

    @Autowired
    private getSumBayarGateway getSumBayarGateway;

    @Autowired
    private UiTrnRemFeeRepository uiTrnRemFeeRepository;

    @Autowired
    private TaskRemFeeFifRepository taskRemFeeFifRepository;

    private HttpStatus StatusResponse;

    public ResponseEntity insertRemTrnPu(RemTrnMotifPuInsertDto remTrnMotifPuInsertDto) {
        responseObj responseObj = new responseObj();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        if (remTrnMotifPuInsertDto.getResult().equals("P") && remTrnMotifPuInsertDto.getType().equals("BAYAR")){


//        RemTrnMotifPu remTrnMotifPu = remTrnMotifPuInsertDto.convert();
        RemTrnMotifPuId remTrnMotifPuId = new RemTrnMotifPuId();
        remTrnMotifPuId.setPcId(remTrnMotifPuInsertDto.getPcId());
        if (remTrnMotifPuId.getPcId() == null || remTrnMotifPuId.getPcId().equals("")) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Pc Id can't null");
            remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
            remTrnMotifPuId.setCreatedTimestamp(LocalDateTime.now());
        remTrnMotifPuId.setContractNo(remTrnMotifPuInsertDto.getContractNo());

        RemTrnMotifPu remTrnMotifPu = new RemTrnMotifPu();
        remTrnMotifPu.setId(remTrnMotifPuId);
        if (remTrnMotifPuRepository.getByPcIdAndContractNoAndBapkpNoAndStatus(remTrnMotifPuId.getPcId(), remTrnMotifPuId.getContractNo(), remTrnMotifPuInsertDto.getBapkpNo(), remTrnMotifPu.getStatus()) != null) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Data Already Exist");
            remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
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
            remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
        remTrnMotifPu.setEmplCode(remTrnMotifPuInsertDto.getEmplCode());
        if (remTrnMotifPuInsertDto.getType() == "PICKUP" && remTrnMotifPu.getEmplCode().equals("")) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Empl Code can't null");
            remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
            if (remTrnMotifPuInsertDto.getType() == "PICKUP" && remTrnMotifPu.getEmplCode() == null) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Empl Code can't null");
                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
                if (remTrnMotifPuInsertDto.getType() != "PICKUP"){
                    remTrnMotifPu.setEmplCode(null);
                }
        remTrnMotifPu.setEmplName(remTrnMotifPuInsertDto.getEmplName());
        if (remTrnMotifPuInsertDto.getType() == "PICKUP" && remTrnMotifPu.getEmplCode() == null) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Empl Name can't null");
            remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
        remTrnMotifPu.setType(remTrnMotifPuInsertDto.getType());
        if (remTrnMotifPu.getType() == null || remTrnMotifPu.getType().equals("")) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Type can't null");
            remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
            remTrnMotifPu.setNominalPembayaran(remTrnMotifPuInsertDto.getNominalPembayaran());
            if (remTrnMotifPu.getNominalPembayaran().equals("") && remTrnMotifPuInsertDto.getType().equals("BAYAR")) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Nominal Pembayaran can't null");
                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
                if (remTrnMotifPuInsertDto.getType().equals("BAYAR")){

                    remTrnMotifPu.setNominalPembayaran(Long.valueOf(remTrnMotifPuInsertDto.getReceiveInstallment()) + Long.valueOf(remTrnMotifPuInsertDto.getReceivePenalty()) + Long.valueOf(remTrnMotifPuInsertDto.getReceiveCollfee()));
                } else {
                    remTrnMotifPu.setNominalPembayaran(null);
                }

        remTrnMotifPu.setAlasan(remTrnMotifPuInsertDto.getAlasan());
        if (remTrnMotifPu.getAlasan() == null || remTrnMotifPu.getAlasan().equals("")) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Alasan can't null");
            remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
        remTrnMotifPu.setCreatedBy(null);
                if (remTrnMotifPuInsertDto.getType().equals("PICKUP")){
                    if (remTrnMotifPuInsertDto.getBapkpNo().equals("")){
                        responseObj.setRespHttpCode("400");
                        responseObj.setRespHttpMessage("Bapkp No can't null");
                        remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                        StatusResponse = HttpStatus.BAD_REQUEST;
                    } else {
                        remTrnMotifPu.setBapkpNo(remTrnMotifPuInsertDto.getBapkpNo());
                        remTrnMotifPu.setStatus(remTrnMotifPuInsertDto.getStatus());
                        if (remTrnMotifPu.getStatus() == null || remTrnMotifPu.getStatus().equals("")) {
                            responseObj.setRespHttpCode("400");
                            responseObj.setRespHttpMessage("Status can't null");
                            remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
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
                        remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                        StatusResponse = HttpStatus.BAD_REQUEST;
                    }

                    remTrnMotifPu.setUpdatedBy(null);
                    remTrnMotifPu.setUpdatedTimestamp(null);
                }

            ArTrnMotifResultArId arTrnMotifResultArId = new ArTrnMotifResultArId();
            arTrnMotifResultArId.setRvbNo(remTrnMotifPuInsertDto.getRvbNo());
            if (arTrnMotifResultArId.getRvbNo() == null || arTrnMotifResultArId.getRvbNo().equals("")) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("RVB_NO can't null");
                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
            arTrnMotifResultArId.setContractNo(remTrnMotifPuInsertDto.getContractNo());
            if (arTrnMotifResultArId.getContractNo() == null || arTrnMotifResultArId.getContractNo().equals("")) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("CONTRACT_NO can't null");
                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else{

            ArTrnMotifResultAr arTrnMotifResultAr = new ArTrnMotifResultAr();
            arTrnMotifResultAr.setId(arTrnMotifResultArId);
            arTrnMotifResultAr.setCollId(remTrnMotifPuInsertDto.getCrcId());
            if (arTrnMotifResultAr.getCollId() == null || arTrnMotifResultAr.getCollId().equals("")) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("CRC_ID can't null");
                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
            arTrnMotifResultAr.setLkpNo(remTrnMotifPuInsertDto.getLkpNo());
            if (arTrnMotifResultAr.getLkpNo() == null || arTrnMotifResultAr.getLkpNo().equals("")) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("LKP_NO can't null");
                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
            arTrnMotifResultAr.setPcId(remTrnMotifPuInsertDto.getPcId());
            if (arTrnMotifResultAr.getPcId() == null || arTrnMotifResultAr.getPcId().equals("")) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("PC_ID can't null");
                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
            arTrnMotifResultAr.setReceivedAmt(Integer.parseInt(remTrnMotifPuInsertDto.getReceiveInstallment()) + Integer.parseInt(remTrnMotifPuInsertDto.getReceivePenalty()) + remTrnMotifPuInsertDto.getReceiveCollfee());
            if (remTrnMotifPuInsertDto.getReceiveInstallment() == null || remTrnMotifPuInsertDto.getReceiveInstallment().equals("")) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("RECEIVED_INSTALLMENT can't null");
                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
                arTrnMotifResultAr.setReceiveInstallment(Integer.parseInt(remTrnMotifPuInsertDto.getReceiveInstallment()));
            if (remTrnMotifPuInsertDto.getReceivePenalty() == null || remTrnMotifPuInsertDto.getReceivePenalty().equals("")) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("RECEIVED_PENALTY can't null");
                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
                arTrnMotifResultAr.setReceivePenalty(Integer.parseInt(remTrnMotifPuInsertDto.getReceivePenalty()));
                arTrnMotifResultAr.setReceiveCollFee(remTrnMotifPuInsertDto.getReceiveCollfee());
            arTrnMotifResultAr.setTransDate(LocalDateTime.now());
            arTrnMotifResultAr.setCoyId(remTrnMotifPuInsertDto.getCoyId());
            if (remTrnMotifPuInsertDto.getCoyId() == null || remTrnMotifPuInsertDto.getCoyId().equals("")) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("COY_ID can't null");
                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
            if (remTrnMotifPuInsertDto.getBussUnit() == null || remTrnMotifPuInsertDto.getBussUnit().equals("")) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("BUSS_UNIT can't null");
                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
                arTrnMotifResultAr.setBussUnit(remTrnMotifPuInsertDto.getBussUnit());
            if (remTrnMotifPuInsertDto.getPlatform() == null || remTrnMotifPuInsertDto.getPlatform().equals("")) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Platform can't null");
                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
            arTrnMotifResultAr.setPlatform(remTrnMotifPuInsertDto.getPlatform());
            arTrnMotifResultAr.setFlagUpdate("N");
            arTrnMotifResultAr.setCreatedBy(remTrnMotifPuInsertDto.getPcId());
            arTrnMotifResultAr.setCreatedDate(LocalDateTime.now());


            arTrnMotifResultArRepository.save(arTrnMotifResultAr);
            remTrnMotifPuRepository.save(remTrnMotifPu);

                responseObj.setRespHttpCode("200");
                responseObj.setRespHttpMessage("Succesfully");
                StatusResponse = HttpStatus.OK;


        }


        }}}}}}}}}}}}}}}}}}} else {

            RemTrnMotifPuId remTrnMotifPuId = new RemTrnMotifPuId();
            remTrnMotifPuId.setPcId(remTrnMotifPuInsertDto.getPcId());
            if (remTrnMotifPuId.getPcId() == null || remTrnMotifPuId.getPcId().equals("")) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Pc Id can't null");
                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
                remTrnMotifPuId.setCreatedTimestamp(LocalDateTime.now());
                remTrnMotifPuId.setContractNo(remTrnMotifPuInsertDto.getContractNo());

                RemTrnMotifPu remTrnMotifPu = new RemTrnMotifPu();
                remTrnMotifPu.setId(remTrnMotifPuId);
                if (remTrnMotifPuRepository.getByPcIdAndContractNoAndBapkpNoAndStatus(remTrnMotifPuId.getPcId(), remTrnMotifPuId.getContractNo(), remTrnMotifPuInsertDto.getBapkpNo(), remTrnMotifPu.getStatus()) != null) {
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage("Data Already Exist");
                    remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
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
                        remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                        StatusResponse = HttpStatus.BAD_REQUEST;
                    } else {
                        remTrnMotifPu.setEmplCode(remTrnMotifPuInsertDto.getEmplCode());
                        if (remTrnMotifPuInsertDto.getType() == "PICKUP" && remTrnMotifPu.getEmplCode().equals("")) {
                            responseObj.setRespHttpCode("400");
                            responseObj.setRespHttpMessage("Empl Code can't null");
                            remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                            StatusResponse = HttpStatus.BAD_REQUEST;
                        } else {
                            if (remTrnMotifPuInsertDto.getType() == "PICKUP" && remTrnMotifPu.getEmplCode() == null) {
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Empl Code can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                                if (remTrnMotifPuInsertDto.getType() != "PICKUP"){
                                    remTrnMotifPu.setEmplCode(null);
                                }
                                remTrnMotifPu.setEmplName(remTrnMotifPuInsertDto.getEmplName());
                                if (remTrnMotifPuInsertDto.getType() == "PICKUP" && remTrnMotifPu.getEmplName().equals("")) {
                                    responseObj.setRespHttpCode("400");
                                    responseObj.setRespHttpMessage("Empl Name can't null");
                                    remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                                    StatusResponse = HttpStatus.BAD_REQUEST;
                                } else {
                                    if (remTrnMotifPuInsertDto.getType() == "PICKUP" && remTrnMotifPu.getEmplName() == null) {
                                        responseObj.setRespHttpCode("400");
                                        responseObj.setRespHttpMessage("Empl Name can't null");
                                        remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                                        StatusResponse = HttpStatus.BAD_REQUEST;
                                    } else {
                                        if (remTrnMotifPuInsertDto.getType() != "PICKUP"){
                                            remTrnMotifPu.setEmplName(null);
                                        }
                                    remTrnMotifPu.setType(remTrnMotifPuInsertDto.getType());
                                    if (remTrnMotifPu.getType() == null || remTrnMotifPu.getType().equals("")) {
                                        responseObj.setRespHttpCode("400");
                                        responseObj.setRespHttpMessage("Type can't null");
                                        remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                                        StatusResponse = HttpStatus.BAD_REQUEST;
                                    } else {
                                        remTrnMotifPu.setNominalPembayaran(remTrnMotifPuInsertDto.getNominalPembayaran());
                                        if (remTrnMotifPu.getNominalPembayaran().equals("") && remTrnMotifPuInsertDto.getType().equals("BAYAR")) {
                                            responseObj.setRespHttpCode("400");
                                            responseObj.setRespHttpMessage("Nominal Pembayaran can't null");
                                            remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
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
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                                remTrnMotifPu.setCreatedBy(null);
                                                if (remTrnMotifPuInsertDto.getType().equals("PICKUP")){
                                                    if (remTrnMotifPuInsertDto.getBapkpNo().equals("") ){
                                                        responseObj.setRespHttpCode("400");
                                                        responseObj.setRespHttpMessage("Bapkp No can't null");
                                                        remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                                                        StatusResponse = HttpStatus.BAD_REQUEST;
                                                    } else {
                                                        remTrnMotifPu.setBapkpNo(remTrnMotifPuInsertDto.getBapkpNo());
                                                        remTrnMotifPu.setStatus(remTrnMotifPuInsertDto.getStatus());
                                                        if (remTrnMotifPu.getStatus() == null || remTrnMotifPu.getStatus().equals("")) {
                                                            responseObj.setRespHttpCode("400");
                                                            responseObj.setRespHttpMessage("Status can't null");
                                                            remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                                                            StatusResponse = HttpStatus.BAD_REQUEST;
                                                        }

                                                        remTrnMotifPu.setUpdatedBy(null);
                                                        remTrnMotifPu.setUpdatedTimestamp(null);

                                                        remTrnMotifPuRepository.save(remTrnMotifPu);

                                                    }

                                                } else {
                                                    remTrnMotifPu.setBapkpNo(null);

                                                    remTrnMotifPu.setStatus(remTrnMotifPuInsertDto.getStatus());
                                                    if (remTrnMotifPu.getStatus() == null || remTrnMotifPu.getStatus().equals("")) {
                                                        responseObj.setRespHttpCode("400");
                                                        responseObj.setRespHttpMessage("Status can't null");
                                                        remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnMotifPuInsertDto, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't insert to table REM_TRN_MOTIF_PU");
                                                        StatusResponse = HttpStatus.BAD_REQUEST;
                                                    }

                                                    remTrnMotifPu.setUpdatedBy(null);
                                                    remTrnMotifPu.setUpdatedTimestamp(null);
                                                }

                                                responseObj.setRespHttpCode("200");
                                                responseObj.setRespHttpMessage("Succesfully");
                                                StatusResponse = HttpStatus.OK;

                                                                                        remTrnMotifPuRepository.save(remTrnMotifPu);
                                                                                    }}}}}}}}}}

        }

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

    @Override
    public ResponseEntity insertSchedulerPu (){
        responseObj responseObj = new responseObj();
        Calendar calendar = Calendar.getInstance();

        int tanggalHariIni = calendar.get(Calendar.DAY_OF_MONTH);

        try {

            if (tanggalHariIni != 1) {
                List<taskRemFeeFif> autoInsertPuDto = taskRemFeeFifRepository.findLoopData();

                if (autoInsertPuDto.size() == 0 || autoInsertPuDto.isEmpty()) {

                    responseObj.setRespHttpCode("500");
                    responseObj.setRespHttpMessage("Can't find data");
                    remLogMotifErrGateway.insertLogRemLogMotifErr(null, convertObjectToJson(responseObj, true), "POST_SUBMIT_PU_TEMP", "Can't find data");
                    StatusResponse = HttpStatus.BAD_REQUEST;
                } else {

                    for (int i = 0; i < autoInsertPuDto.size(); i++) {
                        taskRemFeeFif taskRemFeeFif = autoInsertPuDto.get(i);
                        String groupName = null;
                        groupName = uiMstParamRepository.findGroupName(autoInsertPuDto.get(i).getHasilPenugasan());
                        if (groupName == "BAYAR" || groupName.equals("BAYAR")) {
                            BigDecimal sumBayar = getSumBayarGateway.getSumBayar(taskRemFeeFif.getContractNo());
                            if (sumBayar == null || sumBayar.equals(null)) {

                                responseObj.setRespHttpCode("200");
                                responseObj.setRespHttpMessage("Succesfully");
                                StatusResponse = HttpStatus.OK;
                            } else {
                                RemTrnMotifPuId remTrnMotifPuId = new RemTrnMotifPuId();
                                remTrnMotifPuId.setContractNo(taskRemFeeFif.getContractNo());
                                remTrnMotifPuId.setPcId(taskRemFeeFif.getMitraCode());
                                remTrnMotifPuId.setCreatedTimestamp(LocalDateTime.now());

                                RemTrnMotifPu remTrnMotifPu = new RemTrnMotifPu();
                                remTrnMotifPu.setId(remTrnMotifPuId);
                                remTrnMotifPu.setPalNo(null);
                                remTrnMotifPu.setOfficeCode(taskRemFeeFif.getOfficeCode());
                                remTrnMotifPu.setEmplCode(null);
                                remTrnMotifPu.setEmplName(null);
                                remTrnMotifPu.setType("BAYAR");
                                remTrnMotifPu.setNominalPembayaran(sumBayar.longValue());
                                remTrnMotifPu.setAlasan(null);
                                remTrnMotifPu.setCreatedBy("AUTO INSERT PU");
                                remTrnMotifPu.setUpdatedBy(null);
                                remTrnMotifPu.setUpdatedTimestamp(null);
                                remTrnMotifPu.setBapkpNo(null);
                                remTrnMotifPu.setStatus("RTC");

                                remTrnMotifPuRepository.save(remTrnMotifPu);

                                uiTrnRemFee uiTrnRemFee = new uiTrnRemFee();
                                UUID uuid = UUID.randomUUID();

                                uiTrnRemFee.setId(uuid.toString());
                                uiTrnRemFee.setTaskId(taskRemFeeFif.getTaskId());
                                uiTrnRemFee.setContractNo(taskRemFeeFif.getContractNo());
                                uiTrnRemFee.setTipePenugasan(taskRemFeeFif.getTipePenugasan());
                                uiTrnRemFee.setOfficeCode(taskRemFeeFif.getOfficeCode());
                                uiTrnRemFee.setStatusTask(taskRemFeeFif.getStatusTask());
                                uiTrnRemFee.setHasilPenugasan(groupName);
                                uiTrnRemFee.setTanggalVerifikasi(new Date());
                                uiTrnRemFee.setMitraCode(taskRemFeeFif.getMitraCode());
                                uiTrnRemFee.setPeriode(taskRemFeeFif.getPeriode());

                                uiTrnRemFeeRepository.save(uiTrnRemFee);

                            }
                        } else {

                            dataPickupDto dataPickup = getSumBayarGateway.getPalNoBapkpNo(taskRemFeeFif.getContractNo());
                            if (dataPickup == null || dataPickup.equals(null)) {
                                responseObj.setRespHttpCode("200");
                                responseObj.setRespHttpMessage("Succesfully");
                                StatusResponse = HttpStatus.OK;
                            } else {

                                RemTrnMotifPuId remTrnMotifPuId = new RemTrnMotifPuId();
                                remTrnMotifPuId.setContractNo(taskRemFeeFif.getContractNo());
                                remTrnMotifPuId.setPcId(taskRemFeeFif.getMitraCode());
                                remTrnMotifPuId.setCreatedTimestamp(LocalDateTime.now());

                                RemTrnMotifPu remTrnMotifPu = new RemTrnMotifPu();
                                remTrnMotifPu.setId(remTrnMotifPuId);
                                remTrnMotifPu.setPalNo(dataPickup.getPalNo());
                                remTrnMotifPu.setOfficeCode(taskRemFeeFif.getOfficeCode());
                                remTrnMotifPu.setEmplCode(null);
                                remTrnMotifPu.setEmplName(null);
                                remTrnMotifPu.setType("PICKUP");
                                remTrnMotifPu.setNominalPembayaran(null);
                                remTrnMotifPu.setAlasan(null);
                                remTrnMotifPu.setCreatedBy("AUTO INSERT PU");
                                remTrnMotifPu.setUpdatedBy(null);
                                remTrnMotifPu.setUpdatedTimestamp(null);
                                remTrnMotifPu.setBapkpNo(dataPickup.getBapkpNo());
                                remTrnMotifPu.setStatus("RTC");

                                remTrnMotifPuRepository.save(remTrnMotifPu);

                                uiTrnRemFee uiTrnRemFee = new uiTrnRemFee();
                                UUID uuid = UUID.randomUUID();

                                uiTrnRemFee.setId(uuid.toString());
                                uiTrnRemFee.setTaskId(taskRemFeeFif.getTaskId());
                                uiTrnRemFee.setContractNo(taskRemFeeFif.getContractNo());
                                uiTrnRemFee.setTipePenugasan(taskRemFeeFif.getTipePenugasan());
                                uiTrnRemFee.setOfficeCode(taskRemFeeFif.getOfficeCode());
                                uiTrnRemFee.setStatusTask(taskRemFeeFif.getStatusTask());
                                uiTrnRemFee.setHasilPenugasan(groupName);
                                uiTrnRemFee.setTanggalVerifikasi(new Date());
                                uiTrnRemFee.setMitraCode(taskRemFeeFif.getMitraCode());
                                uiTrnRemFee.setPeriode(taskRemFeeFif.getPeriode());

                                uiTrnRemFeeRepository.save(uiTrnRemFee);
                            }
                        }
                    }
                }
                } else {

                    List<taskRemFeeFif> taskRemFeeFifThe1st = taskRemFeeFifRepository.findLoopDataThe1st();

                    for (int i = 0; i < taskRemFeeFifThe1st.size(); i++) {
                        taskRemFeeFif taskRemFeeFif = taskRemFeeFifThe1st.get(i);
                        String groupName = null;

                        groupName = uiMstParamRepository.findGroupName(taskRemFeeFifThe1st.get(i).getHasilPenugasan());
                        if (groupName == "BAYAR" || groupName.equals("BAYAR")) {
                            BigDecimal sumBayar = getSumBayarGateway.getSumBayar(taskRemFeeFif.getContractNo());
                            if (sumBayar == null || sumBayar.equals(null)) {

                                responseObj.setRespHttpCode("200");
                                responseObj.setRespHttpMessage("Succesfully");
                                StatusResponse = HttpStatus.OK;
                            } else {
                                RemTrnMotifPuId remTrnMotifPuId = new RemTrnMotifPuId();
                                remTrnMotifPuId.setContractNo(taskRemFeeFif.getContractNo());
                                remTrnMotifPuId.setPcId(taskRemFeeFif.getMitraCode());
                                remTrnMotifPuId.setCreatedTimestamp(LocalDateTime.now());

                                RemTrnMotifPu remTrnMotifPu = new RemTrnMotifPu();
                                remTrnMotifPu.setId(remTrnMotifPuId);
                                remTrnMotifPu.setPalNo(null);
                                remTrnMotifPu.setOfficeCode(taskRemFeeFif.getOfficeCode());
                                remTrnMotifPu.setEmplCode(null);
                                remTrnMotifPu.setEmplName(null);
                                remTrnMotifPu.setType("BAYAR");
                                remTrnMotifPu.setNominalPembayaran(sumBayar.longValue());
                                remTrnMotifPu.setAlasan(null);
                                remTrnMotifPu.setCreatedBy("AUTO INSERT PU");
                                remTrnMotifPu.setUpdatedBy(null);
                                remTrnMotifPu.setUpdatedTimestamp(null);
                                remTrnMotifPu.setBapkpNo(null);
                                remTrnMotifPu.setStatus("RTC");

                                remTrnMotifPuRepository.save(remTrnMotifPu);

                                uiTrnRemFee uiTrnRemFee = new uiTrnRemFee();
                                UUID uuid = UUID.randomUUID();

                                uiTrnRemFee.setId(uuid.toString());
                                uiTrnRemFee.setTaskId(taskRemFeeFif.getTaskId());
                                uiTrnRemFee.setContractNo(taskRemFeeFif.getContractNo());
                                uiTrnRemFee.setTipePenugasan(taskRemFeeFif.getTipePenugasan());
                                uiTrnRemFee.setOfficeCode(taskRemFeeFif.getOfficeCode());
                                uiTrnRemFee.setStatusTask(taskRemFeeFif.getStatusTask());
                                uiTrnRemFee.setHasilPenugasan(groupName);
                                uiTrnRemFee.setTanggalVerifikasi(new Date());
                                uiTrnRemFee.setMitraCode(taskRemFeeFif.getMitraCode());
                                uiTrnRemFee.setPeriode(taskRemFeeFif.getPeriode());

                                uiTrnRemFeeRepository.save(uiTrnRemFee);

                                responseObj.setRespHttpCode("200");
                                responseObj.setRespHttpMessage("Succesfully");
                                StatusResponse = HttpStatus.OK;

                            }
                        } else {

                            dataPickupDto dataPickup = getSumBayarGateway.getPalNoBapkpNo(taskRemFeeFif.getContractNo());
                            if (dataPickup == null || dataPickup.equals(null)) {
                                responseObj.setRespHttpCode("200");
                                responseObj.setRespHttpMessage("Succesfully");
                                StatusResponse = HttpStatus.OK;
                            } else {

                                RemTrnMotifPuId remTrnMotifPuId = new RemTrnMotifPuId();
                                remTrnMotifPuId.setContractNo(taskRemFeeFif.getContractNo());
                                remTrnMotifPuId.setPcId(taskRemFeeFif.getMitraCode());
                                remTrnMotifPuId.setCreatedTimestamp(LocalDateTime.now());

                                RemTrnMotifPu remTrnMotifPu = new RemTrnMotifPu();
                                remTrnMotifPu.setId(remTrnMotifPuId);
                                remTrnMotifPu.setPalNo(dataPickup.getPalNo());
                                remTrnMotifPu.setOfficeCode(taskRemFeeFif.getOfficeCode());
                                remTrnMotifPu.setEmplCode(null);
                                remTrnMotifPu.setEmplName(null);
                                remTrnMotifPu.setType("PICKUP");
                                remTrnMotifPu.setNominalPembayaran(null);
                                remTrnMotifPu.setAlasan(null);
                                remTrnMotifPu.setCreatedBy("AUTO INSERT PU");
                                remTrnMotifPu.setUpdatedBy(null);
                                remTrnMotifPu.setUpdatedTimestamp(null);
                                remTrnMotifPu.setBapkpNo(dataPickup.getBapkpNo());
                                remTrnMotifPu.setStatus("RTC");

                                remTrnMotifPuRepository.save(remTrnMotifPu);

                                uiTrnRemFee uiTrnRemFee = new uiTrnRemFee();
                                UUID uuid = UUID.randomUUID();

                                uiTrnRemFee.setId(uuid.toString());
                                uiTrnRemFee.setTaskId(taskRemFeeFif.getTaskId());
                                uiTrnRemFee.setContractNo(taskRemFeeFif.getContractNo());
                                uiTrnRemFee.setTipePenugasan(taskRemFeeFif.getTipePenugasan());
                                uiTrnRemFee.setOfficeCode(taskRemFeeFif.getOfficeCode());
                                uiTrnRemFee.setStatusTask(taskRemFeeFif.getStatusTask());
                                uiTrnRemFee.setHasilPenugasan(groupName);
                                uiTrnRemFee.setTanggalVerifikasi(new Date());
                                uiTrnRemFee.setMitraCode(taskRemFeeFif.getMitraCode());
                                uiTrnRemFee.setPeriode(taskRemFeeFif.getPeriode());

                                uiTrnRemFeeRepository.save(uiTrnRemFee);

                                responseObj.setRespHttpCode("200");
                                responseObj.setRespHttpMessage("Succesfully");
                                StatusResponse = HttpStatus.OK;
                            }

                        }
                    }
                }
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            StatusResponse = HttpStatus.OK;
        } catch (Exception e){
            responseObj.setRespHttpCode("500");
            responseObj.setRespHttpMessage(e.getMessage());
            remLogMotifErrGateway.insertLogRemLogMotifErr(null, convertObjectToJson(responseObj, true), "AUTO_INSERT_PU", e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity(responseObj, StatusResponse);
    }

    private String convertObjectToJson(Object data, boolean isIncludeNull) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (isIncludeNull) {
            gsonBuilder.serializeNulls();
        }
        Gson gson = gsonBuilder.create();
        return gson.toJson(data);
    }

}
