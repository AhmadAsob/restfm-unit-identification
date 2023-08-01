package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class RemTrnBucketPaidId implements Serializable {
    private static final long serialVersionUID = -3194768901429806184L;
    private String periode;

    private String contractNo;

    @Column(name = "PERIODE", nullable = false, length = 1000)
    public String getPeriode(){return periode;}

    public void setPeriode(String periode) {this.periode = periode;}

    @Column(name = "CONTRACT_NO", nullable = false, length = 1000)
    public String getContractNo(){return contractNo;}

    public void setContractNo(String contractNo) {this.contractNo = contractNo;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        RemTrnBucketPaidId entity = (RemTrnBucketPaidId) o;
        return Objects.equals(this.periode, entity.periode) &&
                Objects.equals(this.contractNo, entity.contractNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(periode, contractNo);
    }

}
