package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "FsMstMou")
@Table(name = "FS_MST_MOU" , schema = "FIFAPPS")
public class FsMstMou {
    private String id;

    private FsMstSupplier suplCode;

    private LocalDate mouDate;

    private LocalDate mouValidFrom;

    private LocalDate mouValidTo;

    private String mouStatus;

    private String createdBy;

    private LocalDate createdTimestamp;

    private String lastupdateBy;

    private LocalDate lastupdateTimestamp;

    private String mouDcType;

    private Short mouToleransi;

    private String allBranchFlag;

    private Set<FsMstMouBranch> fsMstMouBranches = new LinkedHashSet<>();

    @Id
    @Column(name = "MOU_NO", nullable = false, length = 30)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUPL_CODE", nullable = false)
    public FsMstSupplier getSuplCode() {
        return suplCode;
    }

    public void setSuplCode(FsMstSupplier suplCode) {
        this.suplCode = suplCode;
    }

    @Column(name = "MOU_DATE", nullable = false)
    public LocalDate getMouDate() {
        return mouDate;
    }

    public void setMouDate(LocalDate mouDate) {
        this.mouDate = mouDate;
    }

    @Column(name = "MOU_VALID_FROM", nullable = false)
    public LocalDate getMouValidFrom() {
        return mouValidFrom;
    }

    public void setMouValidFrom(LocalDate mouValidFrom) {
        this.mouValidFrom = mouValidFrom;
    }

    @Column(name = "MOU_VALID_TO", nullable = false)
    public LocalDate getMouValidTo() {
        return mouValidTo;
    }

    public void setMouValidTo(LocalDate mouValidTo) {
        this.mouValidTo = mouValidTo;
    }

    @Column(name = "MOU_STATUS", nullable = false, length = 2)
    public String getMouStatus() {
        return mouStatus;
    }

    public void setMouStatus(String mouStatus) {
        this.mouStatus = mouStatus;
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

    @Column(name = "MOU_DC_TYPE", length = 1)
    public String getMouDcType() {
        return mouDcType;
    }

    public void setMouDcType(String mouDcType) {
        this.mouDcType = mouDcType;
    }

    @Column(name = "MOU_TOLERANSI")
    public Short getMouToleransi() {
        return mouToleransi;
    }

    public void setMouToleransi(Short mouToleransi) {
        this.mouToleransi = mouToleransi;
    }

    @Column(name = "ALL_BRANCH_FLAG", length = 1)
    public String getAllBranchFlag() {
        return allBranchFlag;
    }

    public void setAllBranchFlag(String allBranchFlag) {
        this.allBranchFlag = allBranchFlag;
    }

    @OneToMany(mappedBy = "mouNo")
    public Set<FsMstMouBranch> getFsMstMouBranches() {
        return fsMstMouBranches;
    }

    public void setFsMstMouBranches(Set<FsMstMouBranch> fsMstMouBranches) {
        this.fsMstMouBranches = fsMstMouBranches;
    }

}