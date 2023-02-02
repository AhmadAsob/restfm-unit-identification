package id.co.astra.fifgroup.project.restfm_unit_identification.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "MkTrnMouDtl")
@Table(name = "MK_TRN_MOU_DTLS", schema = "FIFAPPS")
public class MkTrnMouDtl {
    private MkTrnMouDtlId id;

    private MkTrnMouHdr mouNo;

    private String value;

    private String createdBy;

    private LocalDate createdDate;

    private String modifiedBy;

    private LocalDate modifiedDate;

    private FsMstSupplier suplCode;

    @EmbeddedId
    public MkTrnMouDtlId getId() {
        return id;
    }

    public void setId(MkTrnMouDtlId id) {
        this.id = id;
    }

    @MapsId("mouNo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MOU_NO", nullable = false)
    public MkTrnMouHdr getMouNo() {
        return mouNo;
    }

    public void setMouNo(MkTrnMouHdr mouNo) {
        this.mouNo = mouNo;
    }

    @Column(name = "VALUE", length = 100)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SUPL_CODE")
    public FsMstSupplier getSuplCode() {
        return suplCode;
    }

    public void setSuplCode(FsMstSupplier suplCode) {
        this.suplCode = suplCode;
    }

}