package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FsMstSupplierAcctTempId implements Serializable {
    private static final long serialVersionUID = 2087909420545524339L;
    private String suplCode;

    private String suplAccountNo;

    @Column(name = "SUPL_CODE", nullable = false, length = 12)
    public String getSuplCode() {
        return suplCode;
    }

    public void setSuplCode(String suplCode) {
        this.suplCode = suplCode;
    }

    @Column(name = "SUPL_ACCOUNT_NO", nullable = false, length = 30)
    public String getSuplAccountNo() {
        return suplAccountNo;
    }

    public void setSuplAccountNo(String suplAccountNo) {
        this.suplAccountNo = suplAccountNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FsMstSupplierAcctTempId entity = (FsMstSupplierAcctTempId) o;
        return Objects.equals(this.suplAccountNo, entity.suplAccountNo) &&
                Objects.equals(this.suplCode, entity.suplCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suplAccountNo, suplCode);
    }

}