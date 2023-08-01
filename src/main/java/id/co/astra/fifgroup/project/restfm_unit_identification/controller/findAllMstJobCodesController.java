package id.co.astra.fifgroup.project.restfm_unit_identification.controller;


import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstJobCodesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
