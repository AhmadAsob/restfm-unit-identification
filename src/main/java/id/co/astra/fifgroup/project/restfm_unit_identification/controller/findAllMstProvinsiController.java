package id.co.astra.fifgroup.project.restfm_unit_identification.controller;


import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstProvinsiService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restfmui/v1")
public class findAllMstProvinsiController {

    @Autowired
    findAllMstProvinsiService findAllMstProvinsiService;

    @GetMapping("find-all-provinsi")
    public ResponseEntity findAll(Authentication authentication){
        return findAllMstProvinsiService.findAllMstProvinsi();
    }
}
