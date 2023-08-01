package id.co.astra.fifgroup.project.restfm_unit_identification.controller;



import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstCompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping ("restfmui/v1")
public class findAllMstCompanyController {

    @Autowired
    findAllMstCompanyService findAllMstCompanyService;

    @GetMapping("find-all-company")
    public ResponseEntity findAll(
//            @RequestBody mstCompanyDto paramDto
    ) throws IOException {
        return  findAllMstCompanyService.findAllMstCompany(
//                paramDto.getCreateDate(), paramDto.getUpdateDate()
        );
    }
}
