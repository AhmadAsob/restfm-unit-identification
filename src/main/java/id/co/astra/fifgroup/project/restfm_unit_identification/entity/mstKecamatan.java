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
@Table(name = "MST_KECAMATAN_V", schema = "ACCTMGMT")
@NoArgsConstructor
@AllArgsConstructor
public class mstKecamatan {

    @Id
    @Column(name = "KEC_CODE", nullable = false)
    private String kecCode;

    @Column(name = "KECAMATAN", nullable = false)
    private String kecamatan;

    @Column(name = "CITY_CODE", nullable = false)
    private String cityCode;
}
