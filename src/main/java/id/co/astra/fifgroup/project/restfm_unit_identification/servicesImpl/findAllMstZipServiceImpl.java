package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstZip;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstZipRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstZipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstZipServiceImpl")
public class findAllMstZipServiceImpl implements findAllMstZipService {

    @Autowired
    private MstZipRepository mstZipRepository;

    private HttpStatus StatusResponse;

    @Value("${pageLimit.zip}")
    private int pageLimit;

    @Override
    public ResponseEntity findAllMstZip(Integer page){
        responseFiduciaObj responseObj = new responseFiduciaObj();
        try {
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            responseObj.setData(mstZipRepository.findAll(PageRequest.of(page, pageLimit)));
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
