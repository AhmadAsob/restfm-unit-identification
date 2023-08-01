package id.co.astra.fifgroup.project.restfm_unit_identification.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Getter
@Setter
public class RemTrnMotifPuDto implements Serializable {
    private final String pcId;
    private final String contractNo;
    private final String palNo;
    private final String bapkpNo;
    private final String officeCode;
    private final String emplCode;
    private final String emplName;
    private final String type;
    private final Long nominalPembayaran;
    private final String alasan;
    private final String status;
    private final String createdBy;
    private final LocalDate createdTimestamp;
    private final String updatedBy;
    private final LocalDate updatedTimestamp;

//    public static List<RemTrnMotifPuDto> toList(List<RemTrnMotifPu> remTrnMotifPus) {
//        List<RemTrnMotifPuDto> result = new ArrayList<>();
//
//        for (RemTrnMotifPu remTrnMotifPu : remTrnMotifPus){
//            result.add(new RemTrnMotifPuDto(
//                    remTrnMotifPu.getPcId(),
//                    remTrnMotifPu.getContractNo(),
//                    remTrnMotifPu.getPalNo(),
//                    remTrnMotifPu.getBapkpNo(),
//                    remTrnMotifPu.getOfficeCode(),
//                    remTrnMotifPu.getEmplCode(),
//                    remTrnMotifPu.getEmplName(),
//                    remTrnMotifPu.getType(),
//                    remTrnMotifPu.getNominalPembayaran(),
//                    remTrnMotifPu.getAlasan(),
//                    remTrnMotifPu.getStatus(),
//                    remTrnMotifPu.getCreatedBy(),
//                    remTrnMotifPu.getCreatedTimestamp(),
//                    remTrnMotifPu.getUpdatedBy(),
//                    remTrnMotifPu.getUpdatedTimestamp()
//            ));
//        }
//        return result;
//    }
}
