package id.co.astra.fifgroup.project.restfm_unit_identification.controller;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.lawyerDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.postTaskLawyerService;
import org.bouncycastle.cert.ocsp.RespID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restfmui/v1")
public class lawyerController {

    @Autowired
    postTaskLawyerService postTaskLawyerService;

    @PostMapping("post_task_lawyer")
    public ResponseEntity postTaskLawyer(@RequestBody lawyerDto lawyerDto){
        return postTaskLawyerService.postTaskLawyer(lawyerDto);
    }
}
