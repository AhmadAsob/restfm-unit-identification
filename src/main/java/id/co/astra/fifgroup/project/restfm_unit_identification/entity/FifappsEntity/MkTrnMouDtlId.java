package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class MkTrnMouDtlId implements Serializable {
    private static final long serialVersionUID = 3779701894323008493L;
    private String mouNo;

    private String paramCode;

    @Column(name = "MOU_NO", nullable = false, length = 30)
    public String getMouNo() {
        return mouNo;
    }

    public void setMouNo(String mouNo) {
        this.mouNo = mouNo;
    }

    @Column(name = "PARAM_CODE", nullable = false, length = 5)
    public String getParamCode() {
        return paramCode;
    }

    public void setParamCode(String paramCode) {
        this.paramCode = paramCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        MkTrnMouDtlId entity = (MkTrnMouDtlId) o;
        return Objects.equals(this.mouNo, entity.mouNo) &&
                Objects.equals(this.paramCode, entity.paramCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mouNo, paramCode);
    }

}