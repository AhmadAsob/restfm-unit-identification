package id.co.astra.fifgroup.project.restfm_unit_identification.controller;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.RemTrnMotifPuInsertDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.RemTrnSkpcParamDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.insertRemTrnPuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("restfmui/v1")
public class insertRemTrnMotifPuController {

    @Autowired
    insertRemTrnPuService insertRemTrnPuService;

    @PostMapping("insert-pu")
    public ResponseEntity insertNewTrnPu (@RequestBody RemTrnMotifPuInsertDto remTrnMotifPuDto){
        return insertRemTrnPuService.insertRemTrnPu(remTrnMotifPuDto);
    }

    @PostMapping("find-pu-by-param")
    public ResponseEntity findByContractNoAndBapkpNo (@RequestBody RemTrnSkpcParamDto remTrnSkpcParamDto){
        return insertRemTrnPuService.getByContractNoAndBapkpNo(remTrnSkpcParamDto);
    }

    @PutMapping("update-status-pu")
    public ResponseEntity updatePu (@RequestParam String contractNo){
        return insertRemTrnPuService.changeStatus(contractNo);
    }

    @GetMapping("find-pu-by-contract")
    public ResponseEntity findByContractNo (@RequestBody RemTrnMotifPuInsertDto remTrnMotifPuInsertDto){
        return insertRemTrnPuService.getByContractNo(remTrnMotifPuInsertDto);
    }
}
