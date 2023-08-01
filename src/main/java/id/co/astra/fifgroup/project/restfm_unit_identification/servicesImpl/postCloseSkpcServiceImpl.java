package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.postCloseSkpcInput;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemTrnSkpc;
import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.RemLogMotifErrGateway;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.RemTrnSKPCRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.postCloseSkpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("postCloseSkpcServiceImpl")
public class postCloseSkpcServiceImpl implements postCloseSkpcService {

    @Autowired
    private RemTrnSKPCRepository remTrnSKPCRepository;

    @Autowired
    private RemLogMotifErrGateway remLogMotifErrGateway;

    private HttpStatus StatusResponse;

    public ResponseEntity postCloseSkpc (postCloseSkpcInput postCloseDto) {

        responseObj responseObj = new responseObj();
        RemTrnSkpc remTrnSkpc = remTrnSKPCRepository.findStatusSkpcByParam(postCloseDto.getPc(), postCloseDto.getContractNo(), postCloseDto.getSkpcNo(), postCloseDto.getSkpcDate());
        try {
            remTrnSkpc.setStatusSkpc(postCloseDto.getStatusSkpc());
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            StatusResponse = HttpStatus.OK;
            remTrnSKPCRepository.save(remTrnSkpc);
        } catch (Exception e){
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("skpcNo, contractNo, skpcDate or the wrong pc you entered, please check again");
            remLogMotifErrGateway.insertLogRemLogMotifErr(postCloseDto, convertObjectToJson(responseObj, true), "POST_CLOSE_SKPC", "Can't change status skpc");
            StatusResponse = HttpStatus.OK;
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
