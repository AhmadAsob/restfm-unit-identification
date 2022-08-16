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
@Table(name = "MST_BAPKP_V")
@NoArgsConstructor
@AllArgsConstructor

public class mstBapkp {

    @Id
    @Column(name = "OFFICE_CODE", nullable = false)
    private String officeCode;

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
}
