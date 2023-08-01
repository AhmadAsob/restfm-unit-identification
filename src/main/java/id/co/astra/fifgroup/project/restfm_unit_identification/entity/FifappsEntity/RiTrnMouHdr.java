package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "RiTrnMouHdr")
@Table(name = "RI_TRN_MOU_HDRS", schema = "FIFAPPS")
public class RiTrnMouHdr {
    private String id;

    private LocalDate mouDate;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private String status;

    private String createdBy;

    private LocalDate createdTimestamp;

    private String lastupdateBy;

    private LocalDate lastupdateTimestamp;

    private String mouType;

    private String suplCode;

    private String officeCode;

    private String suplRevisePrice;

    private Long adminFee;

    private String reason;

    private String coyId;

    private String offsetFlag;

    private String bigbuyerFlag;

    private String refinancingFlag;

    private String remarksCt;

    @Id
    @Column(name = "MOU_NO", nullable = false, length = 30)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "MOU_DATE", nullable = false)
    public LocalDate getMouDate() {
        return mouDate;
    }

    public void setMouDate(LocalDate mouDate) {
        this.mouDate = mouDate;
    }

    @Column(name = "DESCRIPTION", length = 300)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "START_DATE", nullable = false)
    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Column(name = "END_DATE", nullable = false)
    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Column(name = "STATUS", length = 2)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "CREATED_BY", length = 12)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "CREATED_TIMESTAMP")
    public LocalDate getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDate createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Column(name = "LASTUPDATE_BY", length = 12)
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

    @Column(name = "MOU_TYPE", nullable = false, length = 5)
    public String getMouType() {
        return mouType;
    }

    public void setMouType(String mouType) {
        this.mouType = mouType;
    }

    @Column(name = "SUPL_CODE", length = 20)
    public String getSuplCode() {
        return suplCode;
    }

    public void setSuplCode(String suplCode) {
        this.suplCode = suplCode;
    }

    @Column(name = "OFFICE_CODE", nullable = false, length = 5)
    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    @Column(name = "SUPL_REVISE_PRICE", nullable = false, length = 1)
    public String getSuplRevisePrice() {
        return suplRevisePrice;
    }

    public void setSuplRevisePrice(String suplRevisePrice) {
        this.suplRevisePrice = suplRevisePrice;
    }

    @Column(name = "ADMIN_FEE")
    public Long getAdminFee() {
        return adminFee;
    }

    public void setAdminFee(Long adminFee) {
        this.adminFee = adminFee;
    }

    @Column(name = "REASON", length = 2000)
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Column(name = "COY_ID", length = 2)
    public String getCoyId() {
        return coyId;
    }

    public void setCoyId(String coyId) {
        this.coyId = coyId;
    }

    @Column(name = "OFFSET_FLAG", length = 2)
    public String getOffsetFlag() {
        return offsetFlag;
    }

    public void setOffsetFlag(String offsetFlag) {
        this.offsetFlag = offsetFlag;
    }

    @Column(name = "BIGBUYER_FLAG", length = 2)
    public String getBigbuyerFlag() {
        return bigbuyerFlag;
    }

    public void setBigbuyerFlag(String bigbuyerFlag) {
        this.bigbuyerFlag = bigbuyerFlag;
    }

    @Column(name = "REFINANCING_FLAG", length = 2)
    public String getRefinancingFlag() {
        return refinancingFlag;
    }

    public void setRefinancingFlag(String refinancingFlag) {
        this.refinancingFlag = refinancingFlag;
    }

    @Column(name = "REMARKS_CT", length = 2000)
    public String getRemarksCt() {
        return remarksCt;
    }

    public void setRemarksCt(String remarksCt) {
        this.remarksCt = remarksCt;
    }

}