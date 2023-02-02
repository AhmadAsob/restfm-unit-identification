package id.co.astra.fifgroup.project.restfm_unit_identification.controller;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.InsertDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.insertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("restfmui/v1")
public class insertPcRegistrationController {

    @Autowired
    insertService insertService;

    @PostMapping("insert-registration")
    public ResponseEntity insertRegistration (@RequestBody InsertDto insertDto){
        return insertService.insertService(insertDto);
    }
}
