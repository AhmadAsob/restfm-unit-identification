package id.co.astra.fifgroup.project.restfm_unit_identification.controller;


import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstOfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("restfmui/v1")
public class findAllMstOfficeController {

    @Autowired
    findAllMstOfficeService findAllMstOfficeService;

    @GetMapping("find-all-office/{page}")
    public ResponseEntity findAll(@PathVariable int page) {
        return findAllMstOfficeService.findAllMstOffice(page);
    }
}