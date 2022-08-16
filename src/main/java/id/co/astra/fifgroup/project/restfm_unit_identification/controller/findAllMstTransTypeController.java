package id.co.astra.fifgroup.project.restfm_unit_identification.controller;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstTransType;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstTransTypeService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.readers.operation.ResponseMessagesReader;

import java.util.List;

@RestController
@RequestMapping("mstTransType")
public class findAllMstTransTypeController {

    @Autowired
    findAllMstTransTypeService findAllMstTransTypeService;

    @GetMapping("find-all")
    public ResponseEntity findAll (Authentication authentication){
        return findAllMstTransTypeService.findAllMstTransType();
    }
}
