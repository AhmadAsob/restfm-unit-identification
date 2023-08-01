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
@Table(name = "MST_PROVINSi_V", schema = "ACCTMGMT")
@NoArgsConstructor
@AllArgsConstructor
public class mstProvinsi {

    @Id
    @Column(name = "PROV_CODE",nullable = false)
    private String provCode;

    @Column(name = "PROVINSI", nullable = false)
    private String provinsi;
}
