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
@Table(name = "MST_OFFICE_V")
@NoArgsConstructor
@AllArgsConstructor
public class mstOffice {

    @Id
    @Column(name = "OFFICE_CODE", nullable = false)
    private String officeCode;

    @Column(name = "OFFICE_NAME")
    private String officeName;

    @Column(name = "REGIONAL_ID", nullable = false)
    private String regionalId;

    @Column(name = "REGIONAL_NAME", nullable = false)
    private String regionalName;

    @Column(name = "ADDRESS1")
    private String address1;

    @Column(name = "ADDRESS2")
    private String address2;

    @Column(name = "PHONE_NO")
    private String phoneNo;

    @Column(name = "LATITUDE")
    private Integer latitude;

    @Column(name = "LONGITUDE")
    private Integer longitude;

}
