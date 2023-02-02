package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.postCloseSkpcInput;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.RemTrnSkpc;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.RemTrnSKPCRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.postCloseSkpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("postCloseSkpcServiceImpl")
public class postCloseSkpcServiceImpl implements postCloseSkpcService {

    @Autowired
    private RemTrnSKPCRepository remTrnSKPCRepository;

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
            StatusResponse = HttpStatus.OK;
        }

        return new ResponseEntity(responseObj, StatusResponse);
    }
}
