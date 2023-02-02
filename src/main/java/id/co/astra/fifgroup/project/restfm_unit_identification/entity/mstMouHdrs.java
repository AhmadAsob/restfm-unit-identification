package id.co.astra.fifgroup.project.restfm_unit_identification.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "MST_MOU_HDRS_V", schema = "ACCTMGMT")
@NoArgsConstructor
@AllArgsConstructor
public class mstMouHdrs {

    @Id
    @Column(name = "MOU_NO", nullable = false)
    private String mouNo;

    @Column(name = "MOU_DATE", nullable = false)
    private LocalDate mouDate;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "START_DATE", nullable = false)
    private LocalDate startDate;

    @Column(name = "END_DATE", nullable = false)
    private LocalDate endDate;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_TIMESTAMP")
    private LocalDate createdTimestamp;

    @Column(name = "LASTUPDATE_BY")
    private String lastUpdateBy;

    @Column(name = "LASTUPDATE_TIMESTAMP")
    private LocalDate lastUpdateTimestamp;

    @Column(name = "MOU_TYPE", nullable = false)
    private String mouType;

    @Column(name = "SUPL_CODE")
    private String suplCode;

    @Column(name = "OFFICE_CODE", nullable = false)
    private String officeCode;

    @Column(name = "SUPL_REVISE_PRICE", nullable = false)
    private String suplRevisePrice;

    @Column(name = "ADMIN_FEE")
    private Integer adminFee;

    @Column(name = "REASON")
    private String reason;

    @Column(name = "COY_ID")
    private String coyId;

    @Column(name = "OFFSET_FLAG")
    private String offsetFlag;

    @Column(name = "BIGBUYER_FLAG")
    private String bigbuyerFlag;

    @Column(name = "REFINANCING_FLAG")
    private String refinancingFlag;

    @Column(name = "REMARKS_CT")
    private String remarksCt;
}
