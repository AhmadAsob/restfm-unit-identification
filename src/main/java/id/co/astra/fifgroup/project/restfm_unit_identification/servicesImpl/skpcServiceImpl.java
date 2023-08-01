package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.skpcInputProcedure;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemTrnSkpc;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemTrnSkpcId;
import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.RemLogMotifErrGateway;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.ArTrnSumContractRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.FsMstSupplierRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.RemTrnSKPCRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.skpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service("skpcServiceImpl")
public class skpcServiceImpl implements skpcService {

    @Autowired
    private RemTrnSKPCRepository remTrnSKPCRepository;

    @Autowired
    private ArTrnSumContractRepository arTrnSumContractRepository;

    @Autowired
    private FsMstSupplierRepository fsMstSupplierRepository;

    @Autowired
    private RemLogMotifErrGateway remLogMotifErrGateway;

    private HttpStatus StatusResponse;

    public ResponseEntity skpcService(skpcInputProcedure skpcInputProcedure){

        responseObj responseObj = new responseObj();

        List<RemTrnSkpc> dataSkpc = remTrnSKPCRepository.skpcService(skpcInputProcedure.getContractNo(), skpcInputProcedure.getPc(), skpcInputProcedure.getSkpcNo());

        if(skpcInputProcedure.getType().equals("0")){

            String coyId = arTrnSumContractRepository.coyId(skpcInputProcedure.getContractNo());

            if(coyId.equals(null)){
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Coy Id Not Found");
                remLogMotifErrGateway.insertLogRemLogMotifErr(skpcInputProcedure, convertObjectToJson(responseObj, true), "PROCEDURE_SKPC", "unable to process skpc procedure");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
                String palNo = arTrnSumContractRepository.currPalNo(skpcInputProcedure.getContractNo());

                String suplBranchId = fsMstSupplierRepository.suplBranchId(skpcInputProcedure.getPc());

                if(suplBranchId.equals(null)){
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage("Branch PC Not Found");
                    remLogMotifErrGateway.insertLogRemLogMotifErr(skpcInputProcedure, convertObjectToJson(responseObj, true), "PROCEDURE_SKPC", "unable to process skpc procedure");
                    StatusResponse = HttpStatus.BAD_REQUEST;
                } else {
                    if(dataSkpc.size() == 0){

                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

                        RemTrnSkpcId remTrnSkpcId = new RemTrnSkpcId();
                        remTrnSkpcId.setSkpcNo(skpcInputProcedure.getSkpcNo());
                        remTrnSkpcId.setSeqNo(1L);

                        RemTrnSkpc remTrnSkpc = new RemTrnSkpc();

                        remTrnSkpc.setId(remTrnSkpcId);
                        remTrnSkpc.setSkpcDate(LocalDate.now());
                        remTrnSkpc.setSkpcExpiredDate(LocalDate.parse(skpcInputProcedure.getSkpcExpireDate(), formatter));
                        remTrnSkpc.setPc(skpcInputProcedure.getPc());
                        remTrnSkpc.setContractNo(skpcInputProcedure.getContractNo());
                        remTrnSkpc.setStatusSkpc("AC");
                        remTrnSkpc.setCreatedBy("MOTIF");
                        remTrnSkpc.setCreatedTimestamp(LocalDate.now());
                        remTrnSkpc.setLastupdateBy(null);
                        remTrnSkpc.setLastupdateTimestamp(null);
                        remTrnSkpc.setOfficeCode(suplBranchId);
                        remTrnSkpc.setCoyId(coyId);
                        remTrnSkpc.setFreezeDate(null);
                        remTrnSkpc.setPrintCtr(null);
                        remTrnSkpc.setPalNo(palNo);

                        responseObj.setRespHttpCode("200");
                        responseObj.setRespHttpMessage("Succes Insert SKPC");
                        StatusResponse = HttpStatus.OK;
                        remTrnSKPCRepository.save(remTrnSkpc);

                    } else {

                        responseObj.setRespHttpMessage("Sudah ada SKPC active atas No SKP : " + skpcInputProcedure.getSkpcNo());
                        responseObj.setRespHttpCode("400");
                        remLogMotifErrGateway.insertLogRemLogMotifErr(skpcInputProcedure, convertObjectToJson(responseObj, true), "PROCEDURE_SKPC", "unable to process skpc procedure");
                        StatusResponse = HttpStatus.OK;

                    }
                }
            }

        } else if (skpcInputProcedure.getType().equals("1")) {

            System.out.println(dataSkpc);

            if (dataSkpc.size() == 0) {

                responseObj.setRespHttpMessage("Tidak ada SKPC active atas No SKP : " + skpcInputProcedure.getSkpcNo());
                responseObj.setRespHttpCode("400");
                remLogMotifErrGateway.insertLogRemLogMotifErr(skpcInputProcedure, convertObjectToJson(responseObj, true), "PROCEDURE_SKPC", "unable to process skpc procedure");
                StatusResponse = HttpStatus.OK;

            } else {

                remTrnSKPCRepository.skpcServiceUpdate(skpcInputProcedure.getContractNo(), skpcInputProcedure.getPc(), skpcInputProcedure.getSkpcNo());
                responseObj.setRespHttpCode("200");
                responseObj.setRespHttpMessage("Succes Update SKPC");
                StatusResponse = HttpStatus.OK;

            }
        } else {

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
