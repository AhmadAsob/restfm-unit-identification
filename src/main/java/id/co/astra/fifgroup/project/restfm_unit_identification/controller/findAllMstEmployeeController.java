package id.co.astra.fifgroup.project.restfm_unit_identification.controller;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstEmployees;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstEmployeeService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("restfmui/v1")
public class findAllMstEmployeeController {

    @Autowired
    findAllMstEmployeeService findAllMstEmployeeService;


    @GetMapping("find-all-employee/{page}")
    public ResponseEntity findAll(Authentication authentication, @PathVariable int page){
        return findAllMstEmployeeService.findAllMstEmployees(page);
    }
}
