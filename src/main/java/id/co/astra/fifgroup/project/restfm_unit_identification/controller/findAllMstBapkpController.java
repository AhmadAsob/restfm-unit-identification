package id.co.astra.fifgroup.project.restfm_unit_identification.controller;


import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstBapkpService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("restfmui/v1")
public class findAllMstBapkpController {

    @Autowired
    findAllMstBapkpService findAllMstBapkpService;

    @GetMapping("find-all-bapkp")
    public ResponseEntity findAll(Authentication authentication, @RequestParam String bastbjOnHand, @RequestParam String bastbjStatus){
        return findAllMstBapkpService.findAllMstBapkpByFilter(bastbjOnHand, bastbjStatus);
    }

    @GetMapping("find-all-bapkp/{page}")
    public ResponseEntity findAll(Authentication authentication, @PathVariable int  page){
        return findAllMstBapkpService.findAllMstBapkp(page);
    }
}
