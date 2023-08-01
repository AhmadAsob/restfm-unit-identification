package id.co.astra.fifgroup.project.restfm_unit_identification.controller;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.*;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllRemTrnSkpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restfmui/v1")
public class findAllRemTrnSkpcController {

    @Autowired
    findAllRemTrnSkpcService findAllremTrnSkpcService;

    @GetMapping("find-all-skpc/{page}")
    public ResponseEntity findAll(
//            @RequestBody RemTrnSkpcParamDto paramDto,
            @PathVariable int page){
        return findAllremTrnSkpcService.findAllRemTrnSkpc(
//                paramDto.getCreatedTimestamp(), paramDto.getLastUpdateTimestamp(),
                page);
    }

    @GetMapping("skpc-procedure")
    public List<responseSkpcProcedure> skpcProcedure(@RequestParam String skpcNo, @RequestParam String skpcDate, @RequestParam String skpcExpireDate, @RequestParam String pc, @RequestParam String contractNo, @RequestParam String type){
        return findAllremTrnSkpcService.skpcProcedure(skpcNo, skpcDate, skpcExpireDate, pc, contractNo, type);
    }
}
