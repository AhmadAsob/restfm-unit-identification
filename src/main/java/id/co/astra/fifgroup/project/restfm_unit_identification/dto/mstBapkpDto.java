package id.co.astra.fifgroup.project.restfm_unit_identification.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class mstBapkpDto implements Serializable {
    private final String officeCode;
    private final String bastbjNo;
    private final String bastbjOnHand;
    private final String bastbjDate;
    private final String bastbjStatus;
    private final String distributionBy;
}
