package id.co.astra.fifgroup.project.restfm_unit_identification.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class AutoInsertPuDto {

    public Integer taskId;
    public String contractNo;
    public String tipePenugasan;
    public String officeCode;
    public String statusTask;
    public String hasilPenugasan;
    public Date tanggalVerifikasi;
    public String mitraCode;
    public String groupName;
}
