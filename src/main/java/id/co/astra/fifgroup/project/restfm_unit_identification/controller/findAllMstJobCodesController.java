package id.co.astra.fifgroup.project.restfm_unit_identification.controller;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.mstJobCodesDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstJobCodes;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstJobCodesService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("restfmui/v1")
public class findAllMstJobCodesController {

    @Autowired
    findAllMstJobCodesService findAllMstJobCodesServices;

    @GetMapping("find-all-job-codes")
    public ResponseEntity findAll(
//            @RequestBody mstJobCodesDto paramDto
    ) {
        return findAllMstJobCodesServices.findAllMstJobCodes(
//                paramDto.getCreatedTimestamp(), paramDto.getLastUpdateTimestamp()
        );
    }
}
