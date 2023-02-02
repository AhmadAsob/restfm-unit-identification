package id.co.astra.fifgroup.project.restfm_unit_identification.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RemTrnSkpcId implements Serializable {
    private static final long serialVersionUID = -3391406785625313655L;
    private String skpcNo;

    private Long seqNo;

    @Column(name = "SKPC_NO", nullable = false, length = 20)
    public String getSkpcNo() {
        return skpcNo;
    }

    public void setSkpcNo(String skpcNo) {
        this.skpcNo = skpcNo;
    }

    @Column(name = "SEQ_NO", nullable = false)
    public Long getSeqNo() {
        return seqNo;
    }

    public void setSeqNo(Long seqNo) {
        this.seqNo = seqNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RemTrnSkpcId entity = (RemTrnSkpcId) o;
        return Objects.equals(this.seqNo, entity.seqNo) &&
                Objects.equals(this.skpcNo, entity.skpcNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seqNo, skpcNo);
    }

}