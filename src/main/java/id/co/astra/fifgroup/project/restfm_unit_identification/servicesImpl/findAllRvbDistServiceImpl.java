package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.stgRvbDistMotifVRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllRvbDistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("findAllRvbDistServiceImpl")
public class findAllRvbDistServiceImpl implements findAllRvbDistService {

    @Autowired
    private stgRvbDistMotifVRepository stgRvbDistMotifVRepository;

    private HttpStatus StatusResponse;

    private int pageLimit = 10;

    @Override
    public ResponseEntity findAllRvbDist(Integer page){
        responseFiduciaObj responseObj = new responseFiduciaObj();
        try {
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            responseObj.setData(stgRvbDistMotifVRepository.findAll(PageRequest.of(page, pageLimit)));
            StatusResponse = HttpStatus.OK;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
