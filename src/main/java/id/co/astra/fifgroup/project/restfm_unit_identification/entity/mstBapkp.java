package id.co.astra.fifgroup.project.restfm_unit_identification.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "MST_BAPKP_V", schema = "ACCTMGMT")
@NoArgsConstructor
@AllArgsConstructor

public class mstBapkp {


    @Column(name = "OFFICE_CODE", nullable = false)
    private String officeCode;

    @Id
    @Column(name = "BASTBJ_NO", nullable = false)
    private String bastbjNo;

    @Column(name = "BASTBJ_ON_HAND", nullable = false)
    private String bastbjOnHand;

    @Column(name = "BASTBJ_DATE", nullable = false)
    private String bastbjDate;

    @Column(name = "BASTBJ_STATUS", nullable = false)
    private String bastbjStatus;

    @Column(name = "DISTRIBUTION_BY")
    private String distributionBy;

    @Column(name = "STATUS")
    private String status;
}
