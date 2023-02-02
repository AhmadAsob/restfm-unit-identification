package id.co.astra.fifgroup.project.restfm_unit_identification.dto;

import lombok.Data;

import java.util.Date;

@Data
public class skpcInputProcedure {
    private String skpcNo;
    private String skpcDate;
    private String skpcExpireDate;
    private String pc;
    private String contractNo;
    private String type;
}
