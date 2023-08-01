package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "FsMstRegional")
@Table(name = "FS_MST_REGIONALS", schema = "FIFAPPS")
public class FsMstRegional {
    private String id;

    private String nameShort;

    private String nameFull;

    private String createdBy;

    private LocalDate createdTimestamp;

    private String lastupdateBy;

    private LocalDate lastupdateTimestamp;

    @Id
    @Column(name = "REGIONAL_ID", nullable = false, length = 5)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "NAME_SHORT", nullable = false, length = 50)
    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    @Column(name = "NAME_FULL", length = 100)
    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
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