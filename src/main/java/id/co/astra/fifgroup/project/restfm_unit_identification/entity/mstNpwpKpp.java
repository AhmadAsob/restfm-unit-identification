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
@Table(name = "MST_NPWP_KPP_V", schema = "ACCTMGMT")
@NoArgsConstructor
@AllArgsConstructor
public class mstNpwpKpp {

    @Id
    @Column(name = "NPWP_KPP_ID", nullable = false)
    private String npwpKppId;

    @Column(name = "NPWP_KPP_AREA")
    private String npwpKppArea;

    @Column (name = "NPWP_KPP_NAME")
    private String npwpKppName;

    @Column(name ="NPWP_KPP_WORKING_AREA")
    private String npwpKppWorkingArea;
}
