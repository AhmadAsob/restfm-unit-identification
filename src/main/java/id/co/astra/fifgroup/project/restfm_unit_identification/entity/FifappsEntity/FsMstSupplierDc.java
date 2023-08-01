package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "FsMstSupplierDc")
@Table(name = "FS_MST_SUPPLIER_DC", schema = "FIFAPPS")
public class FsMstSupplierDc {


    private String suplCode;

    private String personalId;

    private String reference;

    private String createdBy;

    private LocalDate createdDate;

    private String modifiedBy;

    private LocalDate modifiedDate;

    @Id
    @Column(name = "SUPL_CODE", nullable = false, length = 30)
    public String getSuplCode() {
        return suplCode;
    }

    public void setSuplCode(String suplCode) {
        this.suplCode = suplCode;
    }

    @Column(name = "PERSONAL_ID", nullable = false, length = 30)
    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    @Column(name = "REFERENCE", length = 2000)
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
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

}