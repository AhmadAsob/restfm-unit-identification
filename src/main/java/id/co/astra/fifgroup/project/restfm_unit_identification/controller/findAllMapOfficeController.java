package id.co.astra.fifgroup.project.restfm_unit_identification.controller;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.CmMstCtrMapOfficeParamDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMapOfficeService;
import io.swagger.annotations.ApiOperation;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("restfmui/v1")
public class findAllMapOfficeController {

    @Autowired
    findAllMapOfficeService findAllMapOfficeService;

    @GetMapping("find-all-map-office")
    public ResponseEntity findAll(
//            @RequestBody CmMstCtrMapOfficeParamDto paramDto
    ) throws IOException {
        return findAllMapOfficeService.findAllMapOffice(
//                paramDto.getCreateDate(), paramDto.getModifyDate()
        );
    }
}
