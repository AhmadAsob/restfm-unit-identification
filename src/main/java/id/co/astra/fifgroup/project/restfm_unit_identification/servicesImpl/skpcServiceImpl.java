package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.skpcInputProcedure;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.RemTrnSkpc;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.RemTrnSkpcId;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.ArTrnSumContractRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FsMstSupplierRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.RemTrnSKPCRepository;
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

    private HttpStatus StatusResponse;

    public ResponseEntity skpcService(skpcInputProcedure skpcInputProcedure){

        responseObj responseObj = new responseObj();

        List<RemTrnSkpc> dataSkpc = remTrnSKPCRepository.skpcService(skpcInputProcedure.getContractNo(), skpcInputProcedure.getPc(), skpcInputProcedure.getSkpcNo());

        if(skpcInputProcedure.getType().equals("0")){

            String coyId = arTrnSumContractRepository.coyId(skpcInputProcedure.getContractNo());

            if(coyId.equals(null)){
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Coy Id Not Found");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
                String palNo = arTrnSumContractRepository.currPalNo(skpcInputProcedure.getContractNo());

                String suplBranchId = fsMstSupplierRepository.suplBranchId(skpcInputProcedure.getPc());

                if(suplBranchId.equals(null)){
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage("Branch PC Not Found");
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
                        StatusResponse = HttpStatus.OK;

                    }
                }
            }

        } else if (skpcInputProcedure.getType().equals("1")) {

            System.out.println(dataSkpc);

            if (dataSkpc.size() == 0) {

                responseObj.setRespHttpMessage("Tidak ada SKPC active atas No SKP : " + skpcInputProcedure.getSkpcNo());
                responseObj.setRespHttpCode("400");
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
}
