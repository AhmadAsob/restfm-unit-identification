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
@Table(name = "MST_BANK_V", schema = "ACCTMGMT")
@NoArgsConstructor
@AllArgsConstructor

public class mstBank {

    @Id
    @Column(name = "BANK_ID", nullable = false)
    private String bankId;

    @Column(name = "BANK_NAME", nullable = false)
    private String bankName;

}
