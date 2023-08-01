package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CmMstCtrMapOfficeId implements Serializable {
    private static final long serialVersionUID = -4321374690117837135L;
    private String centralId;

    private String branchId;

    private String coyId;

    @Column(name = "CENTRAL_ID", nullable = false, length = 10)
    public String getCentralId() {
        return centralId;
    }

    public void setCentralId(String centralId) {
        this.centralId = centralId;
    }

    @Column(name = "BRANCH_ID", nullable = false, length = 5)
    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    @Column(name = "COY_ID", nullable = false, length = 5)
    public String getCoyId() {
        return coyId;
    }

    public void setCoyId(String coyId) {
        this.coyId = coyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CmMstCtrMapOfficeId entity = (CmMstCtrMapOfficeId) o;
        return Objects.equals(this.centralId, entity.centralId) &&
                Objects.equals(this.branchId, entity.branchId) &&
                Objects.equals(this.coyId, entity.coyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(centralId, branchId, coyId);
    }

}