package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.RemTrnSkpcDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemTrnSkpc;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemTrnSkpcId;
import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.RemLogMotifErrGateway;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.ArTrnSumContractRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.RemTrnSKPCRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.insertRemTrnSkpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service("insertRemTrnSkpcServiceImpl")
public class insertRemTrnSkpcServiceImpl implements insertRemTrnSkpcService {

    @Autowired
    private RemTrnSKPCRepository remTrnSKPCRepository;

    @Autowired
    private ArTrnSumContractRepository arTrnSumContractRepository;

    @Autowired
    private RemLogMotifErrGateway remLogMotifErrGateway;

    private HttpStatus StatusResponse;

    public ResponseEntity insertRemTrnSkpc(RemTrnSkpcDto remTrnSkpcDto) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        responseObj responseObj = new responseObj();

        RemTrnSkpcId remTrnSkpcId = new RemTrnSkpcId();
        remTrnSkpcId.setSkpcNo(remTrnSkpcDto.getIdSkpcNo());
        remTrnSkpcId.setSeqNo(1L);

        RemTrnSkpc remTrnSkpc = new RemTrnSkpc();

            remTrnSkpc.setId(remTrnSkpcId);
            remTrnSkpc.setSkpcDate(LocalDate.parse(remTrnSkpcDto.getSkpcDate(), formatter));
            remTrnSkpc.setSkpcExpiredDate(LocalDate.parse(remTrnSkpcDto.getSkpcExpiredDate(), formatter));
            remTrnSkpc.setPc(remTrnSkpcDto.getPc());
            remTrnSkpc.setContractNo(remTrnSkpcDto.getContractNo());
            remTrnSkpc.setStatusSkpc(remTrnSkpcDto.getStatusSkpc());
            remTrnSkpc.setCreatedBy("MOTIF");
            remTrnSkpc.setCreatedTimestamp(LocalDate.now());
            remTrnSkpc.setLastupdateBy(null);
            remTrnSkpc.setLastupdateTimestamp(null);
            remTrnSkpc.setOfficeCode(remTrnSkpcDto.getOfficeCode());
            remTrnSkpc.setCoyId(arTrnSumContractRepository.coyId(remTrnSkpcDto.getContractNo()));
            if (remTrnSkpc.getCoyId() == null || remTrnSkpc.getStatusSkpc().isEmpty()) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Contract No Not Found");
                remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnSkpcDto, convertObjectToJson(responseObj, true), "POST_INSERT_SKPC", "Can't insert to table REM_TRN_SKPC");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
                remTrnSkpc.setFreezeDate(null);
                remTrnSkpc.setPrintCtr(null);
                remTrnSkpc.setPalNo(remTrnSkpcDto.getPalNo());

                if (remTrnSkpc.getStatusSkpc().equals("NA") || remTrnSkpc.getStatusSkpc().equals("AC") || remTrnSkpc.getStatusSkpc().equals("CL")) {
                    responseObj.setRespHttpCode("200");
                    responseObj.setRespHttpMessage("Succesfully");
                    StatusResponse = HttpStatus.OK;
                    remTrnSKPCRepository.save(remTrnSkpc);
                } else {
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage("Cannot input other than NA, AC, and CL");
                    remLogMotifErrGateway.insertLogRemLogMotifErr(remTrnSkpcDto, convertObjectToJson(responseObj, true), "POST_INSERT_SKPC", "Can't insert to table REM_TRN_SKPC");
                    StatusResponse = HttpStatus.OK;
                }
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
