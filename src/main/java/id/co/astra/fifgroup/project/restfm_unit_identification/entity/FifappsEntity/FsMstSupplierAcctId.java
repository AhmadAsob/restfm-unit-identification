package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FsMstSupplierAcctId implements Serializable {
    private static final long serialVersionUID = -2470722855343718875L;
    private String suplCode;

    private Short suplAccountSeqn;

    @Column(name = "SUPL_CODE", nullable = false, length = 12)
    public String getSuplCode() {
        return suplCode;
    }

    public void setSuplCode(String suplCode) {
        this.suplCode = suplCode;
    }

    @Column(name = "SUPL_ACCOUNT_SEQN", nullable = false)
    public Short getSuplAccountSeqn() {
        return suplAccountSeqn;
    }

    public void setSuplAccountSeqn(Short suplAccountSeqn) {
        this.suplAccountSeqn = suplAccountSeqn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FsMstSupplierAcctId entity = (FsMstSupplierAcctId) o;
        return Objects.equals(this.suplAccountSeqn, entity.suplAccountSeqn) &&
                Objects.equals(this.suplCode, entity.suplCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suplAccountSeqn, suplCode);
    }

}