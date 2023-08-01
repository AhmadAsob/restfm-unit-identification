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
@Table(name = "MST_OFFICE_V", schema = "ACCTMGMT")
@NoArgsConstructor
@AllArgsConstructor
public class mstOffice {

    @Id
    @Column(name = "OFFICE_CODE", nullable = false)
    private String officeCode;

    @Column(name = "NAME_FULL")
    private String officeName;

    @Column(name = "OFFICE_TYPE")
    private String officeType;

    @Column(name = "REGIONAL_ID", nullable = false)
    private String regionalId;

    @Column(name = "ADDRESS1")
    private String address1;

    @Column(name = "ADDRESS2")
    private String address2;

    @Column(name = "CITY")
    private String city;

    @Column(name = "PHONE1")
    private String phoneNo;

    @Column(name = "LATITUDE")
    private String latitude;

    @Column(name = "LONGITUDE")
    private String longitude;

}
