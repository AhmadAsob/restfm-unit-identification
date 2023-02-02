package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.uploadFileRegistrasidto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.uploadFileSKPCdto;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.uploadFileServices;
import net.schmizz.sshj.SSHClient;
import net.schmizz.sshj.sftp.SFTPClient;
import net.schmizz.sshj.transport.verification.PromiscuousVerifier;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

@Service("uploadFileServicesImpl")
public class uploadFileServicesImpl implements uploadFileServices {

    @Value("${path.directory}")
    private String parentPathDirectory;

    @Value("${ws.createby}")
    private String createby;

    private HttpStatus StatusResponse;

    @Autowired
    public motifLogServiceImpl motifLog;

    @Autowired
    public motifTrnServiceImpl motifTrn;

    @PersistenceContext
    private EntityManager entitiyManager;

//    @Value("${config.ip}")
//    private String ipServer;
//
//    @Value("${config.username}")
//    private String usernameServer;
//
//    @Value("${config.password}")
//    private String passwordServer;

    //Upload Data Registrasi
    @Override
    public ResponseEntity uploadFileRegistrasi(uploadFileRegistrasidto uploadDataRegistrasi) throws IOException {
        responseObj responseObj = new responseObj();
        String status;

        if (!uploadDataRegistrasi.getType().isEmpty()) {
            if (uploadDataRegistrasi.getType().equals("PCID") || uploadDataRegistrasi.getType().equals("ANGGOTA")) {
                if (uploadDataRegistrasi.getmitraType().isEmpty()) {
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage("Mitra ID can't be null!");
                    StatusResponse = HttpStatus.BAD_REQUEST;
                } else if (uploadDataRegistrasi.getPcId().isEmpty()) {
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage("PC ID can't be null!");
                    StatusResponse = HttpStatus.BAD_REQUEST;
                } else if(uploadDataRegistrasi.getRequestBy().isEmpty()){
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage("Request By can't be null!");
                    StatusResponse = HttpStatus.BAD_REQUEST;
                } else {
                    if (uploadDataRegistrasi.getType().equals("PCID")) {
                        //Upload File PC ID
                        status = setupDataRegistrasi(uploadDataRegistrasi);
                        if (status.equals("Success")) {
                            responseObj.setRespHttpCode("200");
                            responseObj.setRespHttpMessage("Upload Data Sucessfully!");
                            StatusResponse = HttpStatus.OK;
                        } else if (status.equals("Failed")) {
                            responseObj.setRespHttpCode("424");
                            responseObj.setRespHttpMessage("Upload Data Failed!");
                            StatusResponse = HttpStatus.FAILED_DEPENDENCY;
                        } else {
                            responseObj.setRespHttpCode("400");
                            responseObj.setRespHttpMessage(status);
                            StatusResponse = HttpStatus.BAD_REQUEST;
                        }
                    } else {
                        if (uploadDataRegistrasi.getPcaId().isEmpty()) {
                            responseObj.setRespHttpCode("400");
                            responseObj.setRespHttpMessage("PCA ID can't be null!");
                            StatusResponse = HttpStatus.BAD_REQUEST;
                        } else {
                            //upload File PCA ID
                            status = setupDataRegistrasi(uploadDataRegistrasi);
                            if (status.equals("Success")) {
                                responseObj.setRespHttpCode("200");
                                responseObj.setRespHttpMessage("Upload Data Sucessfully!");
                                StatusResponse = HttpStatus.OK;
                            } else if (status.equals("Failed")) {
                                responseObj.setRespHttpCode("424");
                                responseObj.setRespHttpMessage("Upload Data Failed!");
                                StatusResponse = HttpStatus.FAILED_DEPENDENCY;
                            } else {
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage(status);
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            }
                        }
                    }
                }
            } else {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Type must be Uppercase and contain 'PCID' Or 'ANGGOTA'!");
                StatusResponse = HttpStatus.BAD_REQUEST;
            }
        } else {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Type can't be null!");
            StatusResponse = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }

    //Upload Data SKPC
    @Override
    public ResponseEntity uploadFileSKPC(uploadFileSKPCdto uploadDataSKPC) throws IOException {
        String status;
        responseObj responseObj = new responseObj();

        if (uploadDataSKPC.getOfficeCode().isEmpty()) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Office Code can't be null!");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else if (uploadDataSKPC.getPcId().isEmpty()) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("PC ID can't be null!");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else if (uploadDataSKPC.getCustomerNo().isEmpty()) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Customer No can't be null!");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else if (uploadDataSKPC.getContractNo().isEmpty()) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Contract No can't be null!");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else if(uploadDataSKPC.getRequestBy().isEmpty()){
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage("Request By can't be null!");
            StatusResponse = HttpStatus.BAD_REQUEST;
        } else {
            //upload File SKPC
            status = setupDataSKPC(uploadDataSKPC);
            if (status.equals("Success")) {
                responseObj.setRespHttpCode("200");
                responseObj.setRespHttpMessage("Upload Data Sucessfully!");
                StatusResponse = HttpStatus.OK;
            } else if (status.equals("Failed")) {
                responseObj.setRespHttpCode("424");
                responseObj.setRespHttpMessage("Upload Data Failed!");
                StatusResponse = HttpStatus.FAILED_DEPENDENCY;
            } else {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage(status);
                StatusResponse = HttpStatus.BAD_REQUEST;
            }
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }

    //Setup Data Registrasi
    public String setupDataRegistrasi(uploadFileRegistrasidto uploadDataRegistrasi) throws IOException {
        String statusResult = "";

        if (uploadDataRegistrasi.getType().equals("PCID")) {
            //Setup path directory
            String pathDirectory = parentPathDirectory + "/FM_UI/REGISTRASI/" + uploadDataRegistrasi.getmitraType() + "/" + uploadDataRegistrasi.getPcId() + "/";

            statusResult = uploadFile(pathDirectory,"","", uploadDataRegistrasi.getPcId(),uploadDataRegistrasi.getFile(),uploadDataRegistrasi.getFileName(),"PC",uploadDataRegistrasi.getRequestBy());
        } else {
            //Setup path directory
            String pathDirectory = parentPathDirectory + "/FM_UI/REGISTRASI/" + uploadDataRegistrasi.getmitraType() + "/" + uploadDataRegistrasi.getPcId() + "/" + uploadDataRegistrasi.getPcaId() + "/";

            statusResult = uploadFile(pathDirectory,"", "", uploadDataRegistrasi.getPcaId(),uploadDataRegistrasi.getFile(), uploadDataRegistrasi.getFileName(),"PCA ID",uploadDataRegistrasi.getRequestBy());
        }
        return statusResult;
    }

    //Setup Data SKPC
    private String setupDataSKPC(uploadFileSKPCdto uploadFileSKPC) {

        //Get Current Date
        Date date = new Date();
        //Get YearMonth
        DateFormat yearMonth = new SimpleDateFormat("yyyyMM");
        yearMonth.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateYearMonth = yearMonth.format(date);

        //Get Day
        DateFormat day = new SimpleDateFormat("dd");
        yearMonth.setTimeZone(TimeZone.getTimeZone("UTC"));
        String dateDay = day.format(date);

        //Setup path directory
        String pathDirectory = parentPathDirectory + "/FM_UI/TRANSAKSI/" + uploadFileSKPC.getOfficeCode() + "/" + uploadFileSKPC.getPcId() + "/" + uploadFileSKPC.getCustomerNo() + "/" + uploadFileSKPC.getContractNo() + "/" + dateYearMonth + "/" + dateDay + "/";

        String statusResult = uploadFile(pathDirectory, uploadFileSKPC.getContractNo(), uploadFileSKPC.getSkpcNo(), "", uploadFileSKPC.getFile(), uploadFileSKPC.getFileName(),"SKPC",uploadFileSKPC.getRequestBy());

        return statusResult;
    }

    //Create/upload File in server
    private String uploadFile(String pathDirectory,String contractNo, String skpcNo, String requestNo, MultipartFile[] file, String[] fileName, String typeUpload, String requestBy) {
        String status ="";

        //create directory
        File directoryFile = new File(pathDirectory);
        if (!directoryFile.exists()) {
            if (directoryFile.mkdirs()) {
                //Directory is Created
            } else {
                //Failed to create directory!
                motifLog.insertLogMotif(contractNo,"","Upload Data " + typeUpload + " - " + requestNo,"Failed","Create Directory Failed!",requestBy);
            }
        }

        try{
            for (int i = 0; i < file.length; i++) {
                File dataFile = new File(pathDirectory + file[i].getOriginalFilename());
                String pathFile = Paths.get(String.valueOf(dataFile)).toAbsolutePath().toString();

                try {
                    //Write File
                    dataFile.createNewFile();
                    FileOutputStream fos = new FileOutputStream(dataFile);
                    fos.write(file[i].getBytes());
                    fos.close();

                    //RenameFile
                    File parentPath = new File(pathFile);
                    if(parentPath.exists()){
                        String getPathParent = String.valueOf(parentPath.getParentFile());

                        File newPathName = new File(getPathParent + "/" + fileName[i]);
                        boolean flag = parentPath.renameTo(newPathName);
                        if (flag) {
                            status = "Success";
                            motifTrn.insertTrnMotif(contractNo, requestNo, skpcNo,"Upload Data " + typeUpload,"Success", "Upload Data Success!",newPathName.toString(),createby,requestBy);
                        }else {
                            //Delete File
                            status = "File Upload Failed, Duplicate file name!";
                            File tempData = new File(parentPath.toString());
                            tempData.delete();
                            motifLog.insertLogMotif(contractNo,"","Upload Data " + typeUpload,"Failed","File Upload Failed, Duplicate file name!",requestBy);
                        }
                    }else{
                        status = "Failed";
                        motifLog.insertLogMotif(contractNo,"","Upload Data " + typeUpload,"Failed","File Upload Failed!",requestBy);
                    }
                } catch (IOException e) {
                    status = "Error Create File, Please Check Your File and File Name can't be empty!";
                    motifLog.insertLogMotif(contractNo,"","Upload Data " + typeUpload,"Failed","Error Create File, Please Check Your File and File Name can't be empty!",requestBy);
                }
            }
        }catch (Exception e){
            status = "File and File Name can't be empty!";
            motifLog.insertLogMotif(contractNo,"","Upload Data " + typeUpload,"Failed","Error Upload File : " + e.getMessage(),requestBy);
        }

        return status;
    }
}
