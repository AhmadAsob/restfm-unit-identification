package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstEmployees;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.ws.RespectBinding;
import java.util.List;

@Service("findAllMstEmployeeService")
public interface findAllMstEmployeeService {
    public List<mstEmployees> findAllMstEmplooyeesData();

    public ResponseEntity findAllMstEmployees();
}
