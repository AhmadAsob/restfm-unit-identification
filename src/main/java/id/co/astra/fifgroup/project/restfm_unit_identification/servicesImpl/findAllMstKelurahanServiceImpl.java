package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstKelurahan;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstKelurahanRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstKelurahanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstKelurahanServiceImpl")
public class findAllMstKelurahanServiceImpl implements findAllMstKelurahanService {

    @Autowired
    private MstKelurahanRepository mstKelurahanRepository;

    private HttpStatus StatusResponse;

    @Value("${pageLimit.kelurahan}")
    private int pageLimit;

    @Override
    public ResponseEntity findAllMstKelurahan(Integer page){
        responseFiduciaObj responseObj = new responseFiduciaObj();
        try{
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            responseObj.setData(mstKelurahanRepository.findAll(PageRequest.of(page, pageLimit)));
            StatusResponse = HttpStatus.OK;
        } catch (Exception e){
            System.out.println(e.getMessage());
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
