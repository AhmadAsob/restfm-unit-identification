package id.co.astra.fifgroup.project.restfm_unit_identification.controller;


import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstKelurahanService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restfmui/v1")
public class findAllMstKelurahanController {

    @Autowired
    findAllMstKelurahanService findAllMstKelurahanService;

    @GetMapping("find-all-kelurahan/{page}")
    public ResponseEntity findAll(Authentication authentication, @PathVariable int page){
        return findAllMstKelurahanService.findAllMstKelurahan(page);
    }
}
