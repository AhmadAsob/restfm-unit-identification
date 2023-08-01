package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "RemTrnSkpc")
    @Table(name = "REM_TRN_SKPC", schema = "ACCTMGMT")
public class RemTrnSkpc {
    private RemTrnSkpcId id;

    private LocalDate skpcDate;

    private LocalDate skpcExpiredDate;

    private String pc;

    private String contractNo;

    private String statusSkpc;

    private String createdBy;

    private LocalDate createdTimestamp;

    private String lastupdateBy;

    private LocalDate lastupdateTimestamp;

    private String officeCode;

    private String coyId;

    private LocalDate freezeDate;

    private Long printCtr;

    private String palNo;

    @EmbeddedId
    public RemTrnSkpcId getId() {
        return id;
    }

    public void setId(RemTrnSkpcId id) {
        this.id = id;
    }

    @Column(name = "SKPC_DATE", nullable = false)
    public LocalDate getSkpcDate() {
        return skpcDate;
    }

    public void setSkpcDate(LocalDate skpcDate) {
        this.skpcDate = skpcDate;
    }

    @Column(name = "SKPC_EXPIRED_DATE", nullable = false)
    public LocalDate getSkpcExpiredDate() {
        return skpcExpiredDate;
    }

    public void setSkpcExpiredDate(LocalDate skpcExpiredDate) {
        this.skpcExpiredDate = skpcExpiredDate;
    }

    @Column(name = "PC", nullable = false, length = 16)
    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    @Column(name = "CONTRACT_NO", nullable = false, length = 20)
    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    @Column(name = "STATUS_SKPC", nullable = false, length = 3)
    public String getStatusSkpc() {
        return statusSkpc;
    }

    public void setStatusSkpc(String statusSkpc) {
        this.statusSkpc = statusSkpc;
    }

    @Column(name = "CREATED_BY", nullable = false, length = 15)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "CREATED_TIMESTAMP", nullable = false)
    public LocalDate getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDate createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Column(name = "LASTUPDATE_BY", length = 15)
    public String getLastupdateBy() {
        return lastupdateBy;
    }

    public void setLastupdateBy(String lastupdateBy) {
        this.lastupdateBy = lastupdateBy;
    }

    @Column(name = "LASTUPDATE_TIMESTAMP")
    public LocalDate getLastupdateTimestamp() {
        return lastupdateTimestamp;
    }

    public void setLastupdateTimestamp(LocalDate lastupdateTimestamp) {
        this.lastupdateTimestamp = lastupdateTimestamp;
    }

    @Column(name = "OFFICE_CODE", length = 5)
    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    @Column(name = "COY_ID", length = 5)
    public String getCoyId() {
        return coyId;
    }

    public void setCoyId(String coyId) {
        this.coyId = coyId;
    }

    @Column(name = "FREEZE_DATE")
    public LocalDate getFreezeDate() {
        return freezeDate;
    }

    public void setFreezeDate(LocalDate freezeDate) {
        this.freezeDate = freezeDate;
    }

    @Column(name = "PRINT_CTR")
    public Long getPrintCtr() {
        return printCtr;
    }

    public void setPrintCtr(Long printCtr) {
        this.printCtr = printCtr;
    }

    @Column(name = "PAL_NO", length = 20)
    public String getPalNo() {
        return palNo;
    }

    public void setPalNo(String palNo) {
        this.palNo = palNo;
    }

}