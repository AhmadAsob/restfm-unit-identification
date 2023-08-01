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
@Table(name = "MST_KELURAHAN_V", schema = "ACCTMGMT")
@NoArgsConstructor
@AllArgsConstructor
public class mstKelurahan {

    @Id
    @Column(name = "KEL_CODE", nullable = false)
    private String kelCode;

    @Column(name = "KELURAHAN", nullable = false)
    private String kelurahan;

    @Column(name = "KEC_CODE", nullable = false)
    private String kecCode;
}
