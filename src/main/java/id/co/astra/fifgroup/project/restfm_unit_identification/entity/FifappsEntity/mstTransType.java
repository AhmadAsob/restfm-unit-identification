package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

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
@Table(name = "AR_MST_TRANS_TYPE_V", schema = "ACCTMGMT")
@NoArgsConstructor
@AllArgsConstructor
public class mstTransType {

    @Id
    @Column(name = "TRANS_TYPE", nullable = false)
    private String transType;

    @Column(name = "TRANS_DESC")
    private String transDesc;

    @Column(name = "CREATED_BY", nullable = false)
    private String createdBy;

    @Column(name = "CREATED_TIMESTAMP", nullable = false)
    private LocalDate createdTimestamp;

    @Column(name = "GL_CATEGORY_NAME", nullable = false)
    private String glCreatedName;

    @Column(name = "ACCOUNT_TYPE_1")
    private String accountType1;

    @Column(name = "ACCOUNT_TYPE_2")
    private String accountType2;

    @Column(name = "ACCOUNT_TYPE_3")
    private String accountType3;

    @Column(name = "ACCOUNT_TYPE_4")
    private String accountType4;

    @Column(name = "ACCOUNT_TYPE_5")
    private String accountType5;

    @Column(name = "MODULE_ID")
    private Integer moduleId;

    @Column(name = "RV_TYPE")
    private String rvType;

    @Column(name = "VIA_INTERFACE")
    private String viaInterface;
}
