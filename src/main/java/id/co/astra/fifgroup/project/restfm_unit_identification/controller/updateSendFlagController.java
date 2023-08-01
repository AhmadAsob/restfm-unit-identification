package id.co.astra.fifgroup.project.restfm_unit_identification.controller;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.updateSendFlagDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.updateSendFlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restfmui/v1")
public class updateSendFlagController {

    @Autowired
    updateSendFlagService updateSendFlagService;

    @PutMapping("update-sendFlag")
    public ResponseEntity updateSendFlag (@RequestBody updateSendFlagDto dto){
        return updateSendFlagService.updateSendFlag(dto);
    }
}
