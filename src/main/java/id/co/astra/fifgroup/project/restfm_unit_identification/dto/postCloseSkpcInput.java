package id.co.astra.fifgroup.project.restfm_unit_identification.dto;

import lombok.Data;

@Data
public class postCloseSkpcInput {
    private String pc;
    private String contractNo;
    private String skpcNo;
    private String statusSkpc;
    private String skpcDate;
}
