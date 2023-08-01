package id.co.astra.fifgroup.project.restfm_unit_identification.controller;

import id.co.astra.fifgroup.project.restfm_unit_identification.services.insertRemTrnBucketPaidService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restfmui/v1")
public class bucketPaidController {

    @Autowired
    insertRemTrnBucketPaidService insertRemTrnBucketPaidService;

    @GetMapping("bucket-paid")
    public ResponseEntity insertRemTrnBucketPaidService (){
        return insertRemTrnBucketPaidService.insertRemTrnBucketPaid();
    }

    @GetMapping("find-all-bucket-paid")
    public ResponseEntity findAll(){
        return insertRemTrnBucketPaidService.findAllBucketPaid();
    }

    @GetMapping("find-bucket-paid-by-contract")
    public ResponseEntity findData(@RequestParam String contractNo){
        return insertRemTrnBucketPaidService.findAllBucketPaidByContractNo(contractNo);
    }
}
