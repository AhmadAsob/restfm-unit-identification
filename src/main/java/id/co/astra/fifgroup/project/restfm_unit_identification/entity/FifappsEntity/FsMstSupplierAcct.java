package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "FsMstSupplierAcct")
@Table(name = "FS_MST_SUPPLIER_ACCT", schema = "FIFAPPS")
public class FsMstSupplierAcct {
    private FsMstSupplierAcctId id;

    private FsMstSupplier suplCode;

    private String suplBankId;

    private String suplBankName;

    private String suplAccountNo;

    private String suplAccountName;

    private String suplAccountDesc;

    private String suplAccStatus;

    private String suplAccType;

    private String suplAccCurr;

    private String suplCreatedBy;

    private LocalDateTime suplCreatedDate;

    private String suplModifiedBy;

    private LocalDate suplModifiedDate;

    private String suplApprovedBy;

    private LocalDate suplApprovedDate;

    private String suplDefaultBankAcct;

    private String createdBy;

    private LocalDateTime createdTimestamp;

    private String lastupdateBy;

    private LocalDate lastupdateTimestamp;

    private String suplMainBankAcct;

    @EmbeddedId
    public FsMstSupplierAcctId getId() {
        return id;
    }

    public void setId(FsMstSupplierAcctId id) {
        this.id = id;
    }

//    @MapsId("suplCode")
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "SUPL_CODE", nullable = false)
//    public FsMstSupplier getSuplCode() {
//        return suplCode;
//    }
//
//    public void setSuplCode(FsMstSupplier suplCode) {
//        this.suplCode = suplCode;
//    }

    @Column(name = "SUPL_BANK_ID", nullable = false, length = 5)
    public String getSuplBankId() {
        return suplBankId;
    }

    public void setSuplBankId(String suplBankId) {
        this.suplBankId = suplBankId;
    }

    @Column(name = "SUPL_BANK_NAME", nullable = false, length = 60)
    public String getSuplBankName() {
        return suplBankName;
    }

    public void setSuplBankName(String suplBankName) {
        this.suplBankName = suplBankName;
    }

    @Column(name = "SUPL_ACCOUNT_NO", nullable = false, length = 30)
    public String getSuplAccountNo() {
        return suplAccountNo;
    }

    public void setSuplAccountNo(String suplAccountNo) {
        this.suplAccountNo = suplAccountNo;
    }

    @Column(name = "SUPL_ACCOUNT_NAME", nullable = false, length = 60)
    public String getSuplAccountName() {
        return suplAccountName;
    }

    public void setSuplAccountName(String suplAccountName) {
        this.suplAccountName = suplAccountName;
    }

    @Column(name = "SUPL_ACCOUNT_DESC", length = 60)
    public String getSuplAccountDesc() {
        return suplAccountDesc;
    }

    public void setSuplAccountDesc(String suplAccountDesc) {
        this.suplAccountDesc = suplAccountDesc;
    }

    @Column(name = "SUPL_ACC_STATUS", length = 2)
    public String getSuplAccStatus() {
        return suplAccStatus;
    }

    public void setSuplAccStatus(String suplAccStatus) {
        this.suplAccStatus = suplAccStatus;
    }

    @Column(name = "SUPL_ACC_TYPE", length = 5)
    public String getSuplAccType() {
        return suplAccType;
    }

    public void setSuplAccType(String suplAccType) {
        this.suplAccType = suplAccType;
    }

    @Column(name = "SUPL_ACC_CURR", nullable = false, length = 5)
    public String getSuplAccCurr() {
        return suplAccCurr;
    }

    public void setSuplAccCurr(String suplAccCurr) {
        this.suplAccCurr = suplAccCurr;
    }

    @Column(name = "SUPL_CREATED_BY", nullable = false, length = 12)
    public String getSuplCreatedBy() {
        return suplCreatedBy;
    }

    public void setSuplCreatedBy(String suplCreatedBy) {
        this.suplCreatedBy = suplCreatedBy;
    }

    @Column(name = "SUPL_CREATED_DATE", nullable = false)
    public LocalDateTime getSuplCreatedDate() {
        return suplCreatedDate;
    }

    public void setSuplCreatedDate(LocalDateTime suplCreatedDate) {
        this.suplCreatedDate = suplCreatedDate;
    }

    @Column(name = "SUPL_MODIFIED_BY", length = 12)
    public String getSuplModifiedBy() {
        return suplModifiedBy;
    }

    public void setSuplModifiedBy(String suplModifiedBy) {
        this.suplModifiedBy = suplModifiedBy;
    }

    @Column(name = "SUPL_MODIFIED_DATE")
    public LocalDate getSuplModifiedDate() {
        return suplModifiedDate;
    }

    public void setSuplModifiedDate(LocalDate suplModifiedDate) {
        this.suplModifiedDate = suplModifiedDate;
    }

    @Column(name = "SUPL_APPROVED_BY", length = 12)
    public String getSuplApprovedBy() {
        return suplApprovedBy;
    }

    public void setSuplApprovedBy(String suplApprovedBy) {
        this.suplApprovedBy = suplApprovedBy;
    }

    @Column(name = "SUPL_APPROVED_DATE")
    public LocalDate getSuplApprovedDate() {
        return suplApprovedDate;
    }

    public void setSuplApprovedDate(LocalDate suplApprovedDate) {
        this.suplApprovedDate = suplApprovedDate;
    }

    @Column(name = "SUPL_DEFAULT_BANK_ACCT", length = 1)
    public String getSuplDefaultBankAcct() {
        return suplDefaultBankAcct;
    }

    public void setSuplDefaultBankAcct(String suplDefaultBankAcct) {
        this.suplDefaultBankAcct = suplDefaultBankAcct;
    }

    @Column(name = "CREATED_BY", length = 15)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "CREATED_TIMESTAMP")
    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
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

    @Column(name = "SUPL_MAIN_BANK_ACCT", length = 1)
    public String getSuplMainBankAcct() {
        return suplMainBankAcct;
    }

    public void setSuplMainBankAcct(String suplMainBankAcct) {
        this.suplMainBankAcct = suplMainBankAcct;
    }

}