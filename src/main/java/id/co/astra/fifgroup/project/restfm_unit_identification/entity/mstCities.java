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
@Table(name = "MST_CITIES_V")
@NoArgsConstructor
@AllArgsConstructor
public class mstCities {

    @Id
    @Column(name = "CITY_CODE", nullable = false)
    private String cityCode;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PROV_CODE", nullable = false)
    private String provCode;
}
