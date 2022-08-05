package id.co.astra.fifgroup.project.restfm_unit_identification.dto;

import org.springframework.web.multipart.MultipartFile;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

public class uploadFileRegistrasidto {
    String mitraType;
    String pcId;
    String type;
    String pcaId;
    String[] fileName;
    MultipartFile[] file;
    String requestBy;

    public uploadFileRegistrasidto() {
    }

    public uploadFileRegistrasidto(String mitraType, String pcId, String type, String pcaId, String[] fileName, MultipartFile[] file, String requestBy) {
        this.mitraType = mitraType;
        this.pcId = pcId;
        this.type = type;
        this.pcaId = pcaId;
        this.fileName = fileName;
        this.file = file;
        this.requestBy = requestBy;
    }

    public String getmitraType() {
        return mitraType;
    }

    public void setmitraType(String mitraType) {
        this.mitraType = mitraType;
    }

    public String getPcId() {
        return pcId;
    }

    public void setPcId(String pcId) {
        this.pcId = pcId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPcaId() {
        return pcaId;
    }

    public void setPcaId(String pcaId) {
        this.pcaId = pcaId;
    }

    public String[] getFileName() {
        return fileName;
    }

    public void setFileName(String[] fileName) {
        this.fileName = fileName;
    }

    public MultipartFile[] getFile() {
        return file;
    }

    public void setFile(MultipartFile[] file) {
        this.file = file;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }
}
