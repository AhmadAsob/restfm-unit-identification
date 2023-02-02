package id.co.astra.fifgroup.project.restfm_unit_identification.controller;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.skpcInputProcedure;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.skpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.spring.web.readers.operation.ResponseMessagesReader;

@RestController
@RequestMapping("restfmui/v1")
public class skpcController {

    @Autowired
    skpcService skpcService;

    @GetMapping("skpcService")
    public ResponseEntity serviceSkpc (@RequestBody skpcInputProcedure skpcInputProcedure){
        return skpcService.skpcService(skpcInputProcedure);
    }
}
