package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ArTrnMotifResultArId implements Serializable {
    private static final long serialVersionUID = -4321374690117837135L;
    private String rvbNo ;

    private String contractNo;

    @Column(name = "RVB_NO", nullable = false, length = 30)
    public String getRvbNo(){return rvbNo;}

    public void setRvbNo(String rvbNo){this.rvbNo = rvbNo;}

    @Column(name = "CONTRACT_NO", nullable = false, length = 25)
    public String getContractNo(){return contractNo;}

    public void setContractNo(String contractNo){this.contractNo = contractNo;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ArTrnMotifResultArId entity = (ArTrnMotifResultArId) o;
        return Objects.equals(this.rvbNo, entity.rvbNo) &&
                Objects.equals(this.contractNo, entity.contractNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rvbNo, contractNo);
    }
}
