package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FmUiEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity(name = "taskRemFeeFif")
@Table(name = "TASK_REM_FEE_FIF", schema = "FMUI")
public class taskRemFeeFif {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "TASK_ID")
    private Integer taskId;

    @Column(name = "CONTRACT_NO")
    private String contractNo;

    @Column(name = "TIPE_PENUGASAN")
    private String tipePenugasan;

    @Column(name = "OFFICE_CODE")
    private String officeCode;

    @Column(name = "STATUS_TASK")
    private String statusTask;

    @Column(name = "HASIL_PENUGASAN")
    private String hasilPenugasan;

    @Column(name = "TANGGAL_VERIFIKASI")
    private Date tanggalVerfikasi;

    @Column(name = "MITRA_CODE")
    private String mitraCode;

    @Column(name = "PERIODE")
    private String periode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getTipePenugasan() {
        return tipePenugasan;
    }

    public void setTipePenugasan(String tipePenugasan) {
        this.tipePenugasan = tipePenugasan;
    }

    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    public String getStatusTask() {
        return statusTask;
    }

    public void setStatusTask(String statusTask) {
        this.statusTask = statusTask;
    }

    public String getHasilPenugasan() {
        return hasilPenugasan;
    }

    public void setHasilPenugasan(String hasilPenugasan) {
        this.hasilPenugasan = hasilPenugasan;
    }

    public Date getTanggalVerfikasi() {
        return tanggalVerfikasi;
    }

    public void setTanggalVerfikasi(Date tanggalVerfikasi) {
        this.tanggalVerfikasi = tanggalVerfikasi;
    }

    public String getMitraCode() {
        return mitraCode;
    }

    public void setMitraCode(String mitraCode) {
        this.mitraCode = mitraCode;
    }

    public String getPeriode() {
        return periode;
    }

    public void setPeriode(String periode) {
        this.periode = periode;
    }
}
