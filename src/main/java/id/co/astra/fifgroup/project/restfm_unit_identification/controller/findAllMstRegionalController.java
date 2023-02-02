package id.co.astra.fifgroup.project.restfm_unit_identification.controller;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.FsMstRegionalDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstRegionalService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restfmui/v1")
public class findAllMstRegionalController {

    @Autowired
    findAllMstRegionalService findAllMstRegionalService;

    @GetMapping("find-all-regional")
    public ResponseEntity findAll(
//            @RequestBody FsMstRegionalDto paramDto
    ) {
        return findAllMstRegionalService.findAllMstRegional(
//                paramDto.getCreatedTimestamp(), paramDto.getLastupdateTimestamp()
        );
    }
}
