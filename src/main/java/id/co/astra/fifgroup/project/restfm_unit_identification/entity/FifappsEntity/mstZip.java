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
@Table(name = "MST_ZIP_V", schema = "ACCTMGMT")
@NoArgsConstructor
@AllArgsConstructor
public class mstZip {


    @Column(name = "ZIP_CODE", nullable = false)
    private String zipCode;

    @Column(name = "ZIP_DESC")
    private String zipDesc;

    @Column(name = "PROV_CODE")
    private String provCode;

    @Column(name = "CITY_CODE")
    private String cityCode;

    @Column(name = "KEC_CODE")
    private String kecCode;

    @Id
    @Column(name = "KEL_CODE")
    private String kelCode;

}
