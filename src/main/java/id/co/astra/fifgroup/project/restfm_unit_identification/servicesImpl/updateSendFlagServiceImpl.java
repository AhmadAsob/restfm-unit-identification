package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.updateSendFlagDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifMotifEntity.StgBucketMotifTask;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifMotifRepo.StgBucketMotifTaskRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.updateSendFlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service("updateSendFlagServiceImpl")
public class updateSendFlagServiceImpl implements updateSendFlagService {

    @Autowired
    private StgBucketMotifTaskRepository stgBucketMotifTaskRepository;

    private HttpStatus StatusResponse;

    public ResponseEntity updateSendFlag(updateSendFlagDto dto){

        StgBucketMotifTask stgBucketMotifTask = stgBucketMotifTaskRepository.updateSendFlag(dto.getNoLkp(), dto.getSeqn(), dto.getNoKontrak());
        responseObj responseObj = new responseObj();

        try {

            if (dto.getNoLkp().equals(null) || dto.getNoLkp().equals("")){
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("No Lkp not found");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else if (dto.getSeqn().equals(null) || dto.getSeqn().equals("")){
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Seqn not found");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else if (dto.getNoKontrak().equals(null) || dto.getNoKontrak().equals("")){
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("No Kontrak not found");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
                stgBucketMotifTask.setStgSendFlag("Y");
                stgBucketMotifTask.setStgLastUpdateTimestamp(new Date());

                responseObj.setRespHttpCode("200");
                responseObj.setRespHttpMessage("Succesfully");
                StatusResponse = HttpStatus.OK;
                stgBucketMotifTaskRepository.save(stgBucketMotifTask);
            }
        } catch (Exception e){
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity(responseObj, StatusResponse);
    }
}
