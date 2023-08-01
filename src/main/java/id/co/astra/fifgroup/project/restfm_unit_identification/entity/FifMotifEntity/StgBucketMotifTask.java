package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifMotifEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "STG_BUCKET_MOTIF_TASK", schema = "FIFMOTIF")
@NoArgsConstructor
@AllArgsConstructor
public class StgBucketMotifTask {

    @EmbeddedId
    public StgBucketMotifTaskId id;

    @Column(name = "STG_TIPE_PENUGASAN")
    private String stgTipePenugasan;

    @Column(name = "STG_PIC_ID")
    private String stgPicId;

    @Column(name = "STG_TANGGAL_TASK")
    private Date stgTanggalTask;

    @Column(name = "STG_APPL_ID")
    private String stgApplId;

    @Column(name = "STG_ALAMAT_TAGIH")
    private String stgAlamatTagih;

    @Column(name = "STG_NAMA_CUSTOMER")
    private String stgNamaCustomer;

    @Column(name = "STG_TELP1")
    private String stgTelp1;

    @Column(name = "STG_TELP2")
    private String stgTelp2;

    @Column(name = "STG_TELP3")
    private String stgTelp3;

    @Column(name = "STG_AW")
    private BigDecimal stgAw;

    @Column(name = "STG_AK")
    private BigDecimal stgAk;

    @Column(name = "STG_TOP")
    private BigDecimal stgTop;

    @Column(name = "STG_OUTSTD_PKK")
    private BigDecimal stgOutstdPkk;

    @Column(name = "STG_OVERDUE")
    private BigDecimal stgOverdue;

    @Column(name = "STG_ANGSURAN")
    private BigDecimal stgAngsuran;

    @Column(name = "STG_OBJ_CODE")
    private String stgObjCode;

    @Column(name = "STG_COY_ID")
    private String stgCoyId;

    @Column(name = "STG_D_TETAP")
    private BigDecimal stgDTetap;

    @Column(name = "STG_D_BRJLN")
    private BigDecimal stgDBrjln;

    @Column(name = "STG_B_TAGIH")
    private BigDecimal stgBTagih;

    @Column(name = "STG_AMBC")
    private BigDecimal stgAmbc;

    @Column(name = "STG_T_TNGGKN")
    private BigDecimal stgTTnggkn;

    @Column(name = "STG_OBJ_TYPE")
    private String stgObjType;

    @Column(name = "STG_BO_POL")
    private String stgBoPol;

    @Column(name = "STG_ENGINE_NO")
    private String stgEngineNo;

    @Column(name = "STG_FRAME_NO")
    private String stgFrameNo;

    @Column(name = "STG_OBJECT_CODE_DESCRIPTION")
    private String stgObjectCodeDescription;

    @Column(name = "STG_WARNA")
    private String stgWarna;

    @Column(name = "STG_INST_NO")
    private Integer stgInstNo;

    @Column(name = "STG_INST_AMT_PAID")
    private BigDecimal stgInstAmtPaid;

    @Column(name = "STG_PENALTY_AMT_PAID")
    private BigDecimal stgPenaltyAmtPaid;

    @Column(name = "STG_COLL_FEE_PAID")
    private BigDecimal stgCollFeePaid;

    @Column(name = "STG_PAID_DATE")
    private Date stgPaidDate;

    @Column(name = "STG_DUE_DATE")
    private Date stgDueDate;

    @Column(name = "STG_OVD_DAYS")
    private Integer stgOvdDays;

    @Column(name = "STG_KODE_CABANG_FIF")
    private String stgKodeCabangFif;

    @Column(name = "STG_SEND_FLAG")
    private String stgSendFlag;

    @Column(name = "STG_BUSSINESS_UNIT")
    private String stgBussinessUnit;

    @Column(name = "STG_PLATFORM")
    private String stgPlatform;

    @Column(name = "STG_CYCLE_AWAL")
    private String stgCycleAwal;

    @Column(name = "STG_LATITUDE")
    private Double stgLatitude;

    @Column(name = "STG_LONGITUDE")
    private Double stgLongitude;

    @Column(name = "STG_CREATED_BY", nullable = false)
    private String stgCreatedBy;

    @Column(name = "STG_CREATED_DATE")
    private Date stgCreatedDate;

    @Column(name = "STG_LASTUPDATE_BY")
    private String stgLastUpdateBy;

    @Column(name = "STG_LASTUPDATE_TIMESTAMP")
    private Date stgLastUpdateTimestamp;

    @Column(name = "ID_UPLOAD")
    private String idUpload;

    @Column(name = "STG_ID_ACTIVE")
    private String stgIdActive;

    @Column(name = "STG_WORK_STATUS")
    private String stgWorkStatus;

    @Column(name = "ALAMAT_DOMISILI")
    private String alamatDomisili;

    @Column(name = "NAMA_STNK")
    private String namaStnk;


}
