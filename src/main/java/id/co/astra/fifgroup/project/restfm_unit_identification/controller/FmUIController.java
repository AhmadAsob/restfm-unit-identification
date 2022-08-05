package id.co.astra.fifgroup.project.restfm_unit_identification.controller;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.sendEmaildto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.uploadFileRegistrasidto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.uploadFileSKPCdto;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.getFiduciaServices;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.sendEmailServices;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.uploadFileServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
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


    //@Value("${path.directory}")
    //String pathDirectory;

//    //Test Upload
//    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = ("multipart/form-data"), produces = "application/json")
//    public ResponseEntity<Object> upload(@RequestParam("File")MultipartFile file, @RequestParam("filename") String filename)  {
//        String result = dataPath(file,filename);
//        return new ResponseEntity<Object>(result, HttpStatus.OK);
//    }

//    private Boolean uploadData(MultipartFile dataFile, String filePath) throws IOException {
//        boolean status = false;
//
//        //create folder
//        String path = pathDirectory+filePath;
//        //Creating a File object
//        File file = new File(path);
//        //Creating the directory
//        if(!file.exists()){
//            if(file.mkdirs()){
//                System.out.println("Directory created successfully");
//            }else{
//                System.out.println("Sorry couldnt create specified directory");
//            }
//        }
//
//        //upload File
//        String fileName = dataFile.getOriginalFilename();
//        Path fileNamePath = Paths.get(path,fileName);
//
//        System.out.println("Path : " + fileNamePath);
//
//        byte[] byteFile = dataFile.getBytes();
//        Files.write(fileNamePath,byteFile);
//
//        //cek file
//        File checkFile = new File(String.valueOf(fileNamePath));
//        System.out.println("Check : " + checkFile);
//
//        if(checkFile.exists()){
//            status = true;
//        }
//        return status;
//    }
//
//    private String dataPath(MultipartFile file, String fileName) {
//        String flag = "";
//
//        String pathfolder = pathDirectory + "TRANSAKSI/" + "10100" + "/" + "PC1" + "/" + "CU2" + "/" + "K2" + "/" + "01" + "/" + "1/";
//
//        String path = pathfolder;
//        File filed = new File(path);
//        if (!filed.exists()) {
//            if (filed.mkdirs()) {
//                System.out.println("Directory is created!");
//            } else {
//                System.out.println("Failed to create directory!");
//            }
//        }
//
//        File dataFile = new File(path + file.getOriginalFilename());
//        System.out.println("file name : "+dataFile);
//            String pathFile = Paths.get(String.valueOf(dataFile)).toAbsolutePath().toString();
//        System.out.println("path file :" + pathFile);
//            try{
//                String datapathFile = "";
//                dataFile.createNewFile();
//                FileOutputStream fos = new FileOutputStream(dataFile);
//                fos.write(file.getBytes());
//                fos.close();
//
//                //RenameFile
//                File parentPath = new File(pathFile);
//                System.out.println("parent path : " + parentPath);
//                if(parentPath.exists()){
//                    System.out.println("file berhasil dibuat");
//
//                    String getPathParent = String.valueOf(parentPath.getParentFile());
//                    System.out.println("get path : " + getPathParent);
//
//                    File newname = new File(getPathParent + "/" + fileName);
//                    boolean flags = parentPath.renameTo(newname);
//                    if (flags) {
//                        datapathFile = Paths.get(String.valueOf(newname)).toAbsolutePath().toString();
//                        System.out.println("Path : " + datapathFile);
//                        flag = datapathFile;
//                    }
//                    else{
//                        parentPath.delete();
//                        System.out.println("Gagal Rename File!");
//                    }
//
//                }else{
//                    System.out.println("file gagal dibuat");
//                }
//
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//            return flag;
//    }

}
