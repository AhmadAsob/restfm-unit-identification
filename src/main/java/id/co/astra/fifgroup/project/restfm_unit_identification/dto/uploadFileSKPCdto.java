package id.co.astra.fifgroup.project.restfm_unit_identification.dto;

import org.springframework.web.multipart.MultipartFile;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

public class uploadFileSKPCdto {
    String officeCode;
    String pcId;
    String customerNo;
    String skpcNo;
    String contractNo;
    String[] fileName;
    MultipartFile[] file;
    String requestBy;

    public uploadFileSKPCdto() {
    }

    public uploadFileSKPCdto(String officeCode, String pcId, String customerNo, String skpcNo, String contractNo, String[] fileName, MultipartFile[] file, String requestBy) {
        this.officeCode = officeCode;
        this.pcId = pcId;
        this.customerNo = customerNo;
        this.skpcNo = skpcNo;
        this.contractNo = contractNo;
        this.fileName = fileName;
        this.file = file;
        this.requestBy = requestBy;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getPcId() {
        return pcId;
    }

    public void setPcId(String pcId) {
        this.pcId = pcId;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public String getSkpcNo() {
        return skpcNo;
    }

    public void setSkpcNo(String skpcNo) {
        this.skpcNo = skpcNo;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
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
