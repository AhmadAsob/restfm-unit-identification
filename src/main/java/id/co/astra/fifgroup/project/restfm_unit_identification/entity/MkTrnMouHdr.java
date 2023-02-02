package id.co.astra.fifgroup.project.restfm_unit_identification.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "MkTrnMouHdr")
@Table(name = "MK_TRN_MOU_HDRS", schema = "ACCTMGMT")
public class MkTrnMouHdr {
    private String id;

    private LocalDate mouDate;

    private String description;

    private LocalDate startDate;

    private LocalDate endDate;

    private String mouMember;

    private String status;

    private String createdBy;

    private LocalDate createdDate;

    private String modifiedBy;

    private LocalDate modifiedDate;

    private String mouType;

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

    @Column(name = "DESCRIPTION", nullable = false, length = 300)
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

    @Column(name = "MOU_MEMBER", length = 3)
    public String getMouMember() {
        return mouMember;
    }

    public void setMouMember(String mouMember) {
        this.mouMember = mouMember;
    }

    @Column(name = "STATUS", length = 2)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "CREATED_BY", length = 15)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "CREATED_DATE")
    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    @Column(name = "MODIFIED_BY", length = 15)
    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    @Column(name = "MODIFIED_DATE")
    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Column(name = "MOU_TYPE", nullable = false, length = 5)
    public String getMouType() {
        return mouType;
    }

    public void setMouType(String mouType) {
        this.mouType = mouType;
    }

}