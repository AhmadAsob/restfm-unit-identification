package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "CmMstCtrMapOffice")
@Table(name = "CM_MST_CTR_MAP_OFFICE", schema = "FIFOCM")
public class CmMstCtrMapOffice {
    private CmMstCtrMapOfficeId id;

    private String createBy;

    private LocalDate createDate;

    private String modifyBy;

    private LocalDate modifyDate;

    private String status;

    @EmbeddedId
    public CmMstCtrMapOfficeId getId() {
        return id;
    }

    public void setId(CmMstCtrMapOfficeId id) {
        this.id = id;
    }

    @Column(name = "CREATE_BY", length = 15)
    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    @Column(name = "CREATE_DATE")
    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    @Column(name = "MODIFY_BY", length = 15)
    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    @Column(name = "MODIFY_DATE")
    public LocalDate getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(LocalDate modifyDate) {
        this.modifyDate = modifyDate;
    }

    @Column(name = "STATUS", length = 1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}