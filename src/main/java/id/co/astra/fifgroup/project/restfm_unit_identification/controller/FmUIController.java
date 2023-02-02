package id.co.astra.fifgroup.project.restfm_unit_identification.controller;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.*;
import     id.co.astra.fifgroup.project.restfm_unit_identification.services.updateMouRegistrationService;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

@RestController
@RequestMapping("restfmui/v1")
@Api(description = "Operations API RestFM-UI", tags = "Rest FM UI")
public class FmUIController {

    @Autowired
    sendEmailServices sendEmail;

    @Autowired
    uploadFileServices uploadFile;

    @Autowired
    getFiduciaServices getFiducia;

    @Autowired
    insertMouRegistrationService insertMouRegistrationService;

    @Autowired
    updateMouRegistrationService updateMouRegistrationService;

    @Autowired
    updateService updateService;

    //Send Email
    @ApiOperation(value = "Send Email")
    @RequestMapping(value = "/send-email", method = RequestMethod.POST, consumes = ("multipart/form-data"), produces = "application/json")
    public ResponseEntity sendingEmail(sendEmaildto sendData) {
        return sendEmail.sendEmail(sendData);
    }

    //Upload File Registrasi
    @ApiOperation(value = "Registrasi PC - PCAID")
    @RequestMapping(value = "/registrasi", method = RequestMethod.POST, consumes = ("multipart/form-data"), produces = "application/json")
    public ResponseEntity registrasi_pcid(uploadFileRegistrasidto uploadDataRegistrasi) throws IOException {
        return uploadFile.uploadFileRegistrasi(uploadDataRegistrasi);
    }

    //Upload SKPC
    @ApiOperation(value = "Transaksi SKPC")
    @RequestMapping(value = "/transaksi", method = RequestMethod.POST, consumes = ("multipart/form-data"), produces = "application/json")
    public ResponseEntity transaksi(uploadFileSKPCdto uploadFileSKPC) throws IOException {
        return uploadFile.uploadFileSKPC(uploadFileSKPC);
    }

    //Get Id Fiducia
    @ApiOperation(value = "Get ID File Fiducia")
    @RequestMapping(value = "/fiducia", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity fiducia(String contractNo, String requestBy) {
        return getFiducia.getfiducia(contractNo, requestBy);
    }

    //Insert Mou Registration
    @PostMapping("insert-mou")
    public ResponseEntity insertMou (@RequestBody MouDto mouDto) {
        return insertMouRegistrationService.insertMouRegistration(mouDto);
    }

    @PutMapping("update-mou")
    public ResponseEntity updateMou (@RequestParam String mouId, @RequestBody MouDto mouDto) {
        return updateMouRegistrationService.updateMouRegistration(mouId, mouDto);
    }

    @PutMapping("update-registration")
    public ResponseEntity update (@RequestParam String suplCode, @RequestBody InsertDto insertDto) {
        return updateService.update(suplCode, insertDto);
    }

}
