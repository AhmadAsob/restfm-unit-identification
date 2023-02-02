package id.co.astra.fifgroup.project.restfm_unit_identification.dto;

import lombok.Data;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Data
public class MouDto implements Serializable {
    private final String mouNo;
    private final String mouDate;
    private final String description;
    private final String startDate;
    private final String endDate;
    private final String status;
    private final String createdBy;
    private final String createdTimestamp;
    private final String mouType;
    private final String suplCode;
    private final String officeCode;
    private final String suplRevisePrice;
    private final String coyId;
}
