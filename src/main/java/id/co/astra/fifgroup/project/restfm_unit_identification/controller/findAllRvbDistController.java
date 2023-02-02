package id.co.astra.fifgroup.project.restfm_unit_identification.controller;

import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllRvbDistService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Access;

@RestController
@RequestMapping("restfmui/v1")
public class findAllRvbDistController {

    @Autowired
    findAllRvbDistService findAllRvbDistService;

    @GetMapping("find-all-rvb-dist/{page}")
    public ResponseEntity findAll(Authentication authentication, @PathVariable int page){
        return findAllRvbDistService.findAllRvbDist(page);
    }

}
