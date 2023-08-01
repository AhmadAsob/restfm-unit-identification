package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "FsMstMouBranch")
@Table(name = "FS_MST_MOU_BRANCH" , schema = "ACCTMGMT")
public class FsMstMouBranch {
    private FsMstMouBranchId id;

    private FsMstMou mouNo;

    private String statusFlag;

    private String createdBy;

    private LocalDate createdTimestamp;

    private String lastupdateBy;

    private LocalDate lastupdateTimestamp;

    @EmbeddedId
    public FsMstMouBranchId getId() {
        return id;
    }

    public void setId(FsMstMouBranchId id) {
        this.id = id;
    }

    @MapsId("mouNo")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "MOU_NO", nullable = false)
    public FsMstMou getMouNo() {
        return mouNo;
    }

    public void setMouNo(FsMstMou mouNo) {
        this.mouNo = mouNo;
    }

    @Column(name = "STATUS_FLAG", nullable = false, length = 2)
    public String getStatusFlag() {
        return statusFlag;
    }

    public void setStatusFlag(String statusFlag) {
        this.statusFlag = statusFlag;
    }

    @Column(name = "CREATED_BY", length = 15)
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

}