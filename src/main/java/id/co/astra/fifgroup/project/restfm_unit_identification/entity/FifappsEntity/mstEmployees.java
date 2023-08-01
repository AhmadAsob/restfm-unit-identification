package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

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
@Table(name = "MST_EMPLOYEES_V", schema = "ACCTMGMT")
@NoArgsConstructor
@AllArgsConstructor
public class mstEmployees {

    @Id
    @Column(name = "EMPL_CODE",nullable = false)
    private String emplCode;

    @Column(name = "EMPL_BRANCH", nullable = false)
    private String emplBranch;

    @Column(name = "EMPL_POSPOP_ID")
    private String emplPospopId;

    @Column(name = "EMPL_NAME", nullable = false)
    private String emplName;

    @Column(name = "EMPL_JOB")
    private String emplJob;

    @Column(name = "EMPL_STATUS")
    private String emplStatus;

    @Column(name = "EMPL_SECUJOB")
    private String emplSecujob;

    @Column(name = "JOB_DESCRIPTION")
    private String jobDescription;
}
