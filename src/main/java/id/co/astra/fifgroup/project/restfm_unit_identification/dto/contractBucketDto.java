package id.co.astra.fifgroup.project.restfm_unit_identification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor

public class contractBucketDto {

    private String contractNo;
    private Date paidDate;
    private String contractStatus;

}
