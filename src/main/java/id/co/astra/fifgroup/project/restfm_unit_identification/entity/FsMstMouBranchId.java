package id.co.astra.fifgroup.project.restfm_unit_identification.entity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class FsMstMouBranchId implements Serializable {
    private static final long serialVersionUID = -5034546471116673209L;
    private String mouNo;

    private String officeCode;

    @Column(name = "MOU_NO", nullable = false, length = 30)
    public String getMouNo() {
        return mouNo;
    }

    public void setMouNo(String mouNo) {
        this.mouNo = mouNo;
    }

    @Column(name = "OFFICE_CODE", nullable = false, length = 5)
    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        FsMstMouBranchId entity = (FsMstMouBranchId) o;
        return Objects.equals(this.mouNo, entity.mouNo) &&
                Objects.equals(this.officeCode, entity.officeCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mouNo, officeCode);
    }

}