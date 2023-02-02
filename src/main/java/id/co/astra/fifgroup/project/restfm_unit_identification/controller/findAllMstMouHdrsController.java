package id.co.astra.fifgroup.project.restfm_unit_identification.controller;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.mstMouHdrsDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstMouHdrs;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstMouHdrsService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restfmui/v1")
public class findAllMstMouHdrsController {

    @Autowired
    findAllMstMouHdrsService findAllMstMouHdrsService;

    @GetMapping("find-all-mou-hdrs/{page}")
    public ResponseEntity findAll(
//            @RequestBody mstMouHdrsDto paramDto,
                                  @PathVariable int page){
        return findAllMstMouHdrsService.findAllMstMouHdrs(
//                paramDto.getCreatedTimestamp(), paramDto.getLastUpdateTimestamp(),
                page);
    }

}
