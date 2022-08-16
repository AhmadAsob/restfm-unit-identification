package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstKecamatan;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstKecamatanRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstKecamatanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstKecamatanServiceImpl")
public class findAllMstKecamatanServiceImpl implements findAllMstKecamatanService {

    @Autowired
    private MstKecamatanRepository mstKecamatanRepository;

    private HttpStatus StatusResponse;

    @Override
    public List<mstKecamatan> findAllMstKecamatanData(){
        return mstKecamatanRepository.findAll();
    }

    public ResponseEntity findAllMstKecamatan(){
        responseFiduciaObj responseObj = new responseFiduciaObj();

        responseObj.setRespHttpCode("200");
        responseObj.setRespHttpMessage("Succesfully");
        responseObj.setData(mstKecamatanRepository.findAll());
        StatusResponse = HttpStatus.OK;
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
