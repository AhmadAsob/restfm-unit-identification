package id.co.astra.fifgroup.project.restfm_unit_identification.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class RemTrnSkpcDto implements Serializable {
    private final String idSkpcNo;
    private final Long idSeqNo;
    private final String skpcDate;
    private final String skpcExpiredDate;
    private final String pc;
    private final String contractNo ;
    private final String statusSkpc;
    private final String officeCode;
    private final String palNo;
}
