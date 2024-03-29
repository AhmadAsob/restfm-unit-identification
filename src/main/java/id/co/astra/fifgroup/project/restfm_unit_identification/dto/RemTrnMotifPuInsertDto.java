package id.co.astra.fifgroup.project.restfm_unit_identification.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@Data
public class RemTrnMotifPuInsertDto implements Serializable {
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
    private final String result;
    private final String crcId;
    private final String lkpNo;
    private final String rvbNo;
    private final String receiveInstallment;
    private final String receivePenalty;
    private final int receiveCollfee;
    private final String bussUnit;
    private final String coyId;
    private final String platform;

//    public RemTrnMotifPu convert(){
//        DateTimeFormatter formatTanggal = DateTimeFormatter.ofPattern("dd MMMM yyyy", new Locale("id","ID"));
//
//        return new RemTrnMotifPu(
//                pcId,
//                contractNo,
//                palNo,
//                bapkpNo,
//                officeCode,
//                emplCode,
//                emplName,
//                nominalPembayaran,
//                alasan,
//                createdBy,
//                createdTimestamp
//        );
//    }
}
