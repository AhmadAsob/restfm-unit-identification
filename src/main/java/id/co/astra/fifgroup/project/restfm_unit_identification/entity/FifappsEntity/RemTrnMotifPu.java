package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "RemTrnMotifPu")
@Table(name = "REM_TRN_MOTIF_PU", schema = "ACCTMGMT")
public class RemTrnMotifPu {
    private RemTrnMotifPuId id;

    private String palNo;

    private String officeCode;

    private String emplCode;

    private String emplName;

    private String type;

    private Long nominalPembayaran;

    private String alasan;

    private String createdBy;

    private String updatedBy;

    private LocalDate updatedTimestamp;

    private String bapkpNo;

    private String status;

    @EmbeddedId
    public RemTrnMotifPuId getId() {
        return id;
    }

    public void setId(RemTrnMotifPuId id) {
        this.id = id;
    }

    @Column(name = "PAL_NO", length = 50)
    public String getPalNo() {
        return palNo;
    }

    public void setPalNo(String palNo) {
        this.palNo = palNo;
    }

    @Column(name = "OFFICE_CODE", length = 20)
    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    @Column(name = "EMPL_CODE", length = 20)
    public String getEmplCode() {
        return emplCode;
    }

    public void setEmplCode(String emplCode) {
        this.emplCode = emplCode;
    }

    @Column(name = "EMPL_NAME", length = 100)
    public String getEmplName() {
        return emplName;
    }

    public void setEmplName(String emplName) {
        this.emplName = emplName;
    }

    @Column(name = "TYPE", length = 10)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "NOMINAL_PEMBAYARAN")
    public Long getNominalPembayaran() {
        return nominalPembayaran;
    }

    public void setNominalPembayaran(Long nominalPembayaran) {
        this.nominalPembayaran = nominalPembayaran;
    }

    @Column(name = "ALASAN", length = 2000)
    public String getAlasan() {
        return alasan;
    }

    public void setAlasan(String alasan) {
        this.alasan = alasan;
    }

    @Column(name = "CREATED_BY", length = 20)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "UPDATED_BY", length = 20)
    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    @Column(name = "UPDATED_TIMESTAMP")
    public LocalDate getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    @Column(name = "BAPKP_NO",  length = 50)
    public String getBapkpNo() {
        return bapkpNo;
    }

    public void setBapkpNo(String bapkpNo) {
        this.bapkpNo = bapkpNo;
    }

    @Column(name = "STATUS", length = 5)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setUpdatedTimestamp(LocalDate updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }

}