package id.co.astra.fifgroup.project.restfm_unit_identification.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "STG_RVB_DIST_MOTIF_V", schema = "ACCTMGMT")
@NoArgsConstructor
@AllArgsConstructor

public class stgRvbDistMotifV {

    @Column(name = "OFFICE_CODE")
    private String officeCode;

    @Id
    @Column(name = "RV_NO")
    private String rvNo;

    @Column(name = "USER_CODE")
    private String userCode;

    @Column(name = "USER_NAME")
    private String userName;
}
