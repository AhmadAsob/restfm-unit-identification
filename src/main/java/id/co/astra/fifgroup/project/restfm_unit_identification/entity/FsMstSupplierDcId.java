package id.co.astra.fifgroup.project.restfm_unit_identification.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FsMstSupplierDcId implements Serializable {
    private static final long serialVersionUID = -3194768901429806184L;
    private String suplCode;

    private String personalId;

    @Column(name = "SUPL_CODE", nullable = false, length = 30)
    public String getSuplCode() {
        return suplCode;
    }

    public void setSuplCode(String suplCode) {
        this.suplCode = suplCode;
    }

    @Column(name = "PERSONAL_ID", nullable = false, length = 30)
    public String getPersonalId() {
        return personalId;
    }

    public void setPersonalId(String personalId) {
        this.personalId = personalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FsMstSupplierDcId entity = (FsMstSupplierDcId) o;
        return Objects.equals(this.personalId, entity.personalId) &&
                Objects.equals(this.suplCode, entity.suplCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalId, suplCode);
    }

}