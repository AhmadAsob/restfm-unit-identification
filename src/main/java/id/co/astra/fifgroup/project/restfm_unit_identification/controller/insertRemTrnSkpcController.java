package id.co.astra.fifgroup.project.restfm_unit_identification.controller;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.RemTrnSkpcDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.postCloseSkpcInput;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.insertRemTrnSkpcService;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.postCloseSkpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("restfmui/v1")
public class insertRemTrnSkpcController {

    @Autowired
    insertRemTrnSkpcService insertRemTrnSkpcService;

    @Autowired
    postCloseSkpcService postCloseSkpcService;

    @PostMapping("insert-skpc")
    public ResponseEntity insertNewTrnSKPC (@RequestBody RemTrnSkpcDto remTrnSkpcDto){
        return insertRemTrnSkpcService.insertRemTrnSkpc(remTrnSkpcDto);
    }

    @PutMapping("update-skpc")
    public ResponseEntity updateSKPC (@RequestBody postCloseSkpcInput postCloseSkpcInput){
        return postCloseSkpcService.postCloseSkpc(postCloseSkpcInput);
    }
}
