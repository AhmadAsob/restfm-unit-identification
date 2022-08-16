package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstEmployees;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.MstEmployeesRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstEmployeeServiceImpl")
public class findAllMstEmployeeServiceImpl implements findAllMstEmployeeService {

    @Autowired
    private MstEmployeesRepository mstEmployeesRepository;

    private HttpStatus StatusResponse;

    @Override
    public List<mstEmployees> findAllMstEmplooyeesData(){
        return mstEmployeesRepository.findAll();
    }

    public ResponseEntity findAllMstEmployees(){
        responseFiduciaObj responseObj = new responseFiduciaObj();

        responseObj.setRespHttpCode("200");
        responseObj.setRespHttpMessage("Succesfully");
        responseObj.setData(mstEmployeesRepository.findAll());
        StatusResponse = HttpStatus.OK;
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
