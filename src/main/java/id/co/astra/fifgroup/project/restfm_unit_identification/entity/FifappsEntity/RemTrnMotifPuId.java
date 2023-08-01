package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class RemTrnMotifPuId implements Serializable {
    private static final long serialVersionUID = 945043416541639174L;
    private String pcId;

    private String contractNo;

    private LocalDateTime createdTimestamp;



    @Column(name = "PC_ID", nullable = false, length = 20)
    public String getPcId() {
        return pcId;
    }

    public void setPcId(String pcId) {
        this.pcId = pcId;
    }

    @Column(name = "CONTRACT_NO", nullable = false, length = 20)
    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    @Column(name = "CREATED_TIMESTAMP")
    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RemTrnMotifPuId entity = (RemTrnMotifPuId) o;
        return Objects.equals(this.createdTimestamp, entity.createdTimestamp) &&
                Objects.equals(this.contractNo, entity.contractNo) &&
                Objects.equals(this.pcId, entity.pcId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdTimestamp, contractNo, pcId);
    }

}