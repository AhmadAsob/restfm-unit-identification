package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "RemTrnBucketPaid")
@Getter
@Setter
@Table(name = "REM_TRN_BUCKET_PAID", schema = "ACCTMGMT")
public class RemTrnBucketPaid {

    private RemTrnBucketPaidId id;

    private String paid;

    private String pickup;

    private LocalDateTime createdDate;

    private String createdBy;

    private LocalDateTime updateDate;

    private String updateBy;

    @EmbeddedId
    public RemTrnBucketPaidId getId(){return id;}

    public void setId(RemTrnBucketPaidId id){this.id = id;}

    @Column(name = "PAID", length = 100)
    public String getPaid(){return paid;}

    public void setPaid(String paid){this.paid = paid;}

    @Column(name = "PICKUP", length = 100)
    public String getPickup(){return pickup;}

    public void setPickup(String pickup){this.pickup = pickup;}

    @Column(name = "CREATED_DATE")
    public LocalDateTime getCreatedDate(){return createdDate;}

    public void setCreatedDate(LocalDateTime createdDate){this.createdDate = createdDate;}

    @Column(name = "CREATED_BY", length = 1000)
    public String getCreatedBy(){return createdBy;}

    public void setCreatedBy(String createdBy){this.createdBy = createdBy;}

    @Column(name = "UPDATE_DATE")
    public LocalDateTime getUpdateDate(){return updateDate;}

    public void setUpdateDate(LocalDateTime updateDate){this.updateDate = updateDate;}

    @Column(name = "UPDATE_BY", length = 1000)
    public String getUpdateBy(){return updateBy;}

    public void setUpdateBy(String updateBy){this.updateBy = updateBy;}
}
