package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FmUiEntity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "uiMstParam")
@Table(name = "UI_MST_PARAM", schema = "FMUI")
public class uiMstParam {

    @Id
    @Column(name = "ID")
    private Integer id;

    @Column(name = "HASIL_PENUGASAN")
    private String hasilPenugasan;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @Column(name = "CREATED_DATE")
    private Date createdDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHasilPenugasan() {
        return hasilPenugasan;
    }

    public void setHasilPenugasan(String hasilPenugasan) {
        this.hasilPenugasan = hasilPenugasan;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
