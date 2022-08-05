package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.remTrnWsMotif;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.motif_TrnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

@Service("motifTrnServiceImpl")
public class motifTrnServiceImpl {

    @Autowired
    private motif_TrnRepo motif_trnRepo;

    public void insertTrnMotif(String contractNo, String requestNo, String skpcNo, String requestType, String sendStat, String messageStat,String pathFolder, String createBy, String requestBy){
        remTrnWsMotif trnWsMotif = new remTrnWsMotif();
        UUID uuid = UUID.randomUUID();

        trnWsMotif.setUuid(uuid.toString());
        trnWsMotif.setContractNo(contractNo);
        trnWsMotif.setSkpcNo(skpcNo);
        trnWsMotif.setRequestNo(requestNo);
        trnWsMotif.setRequestType(requestType);
        trnWsMotif.setSendStat(sendStat);
        trnWsMotif.setMessageStat(messageStat);
        trnWsMotif.setPathFolder(pathFolder);
        trnWsMotif.setCreateDate(new Date());
        trnWsMotif.setCreateBy(createBy);
        trnWsMotif.setRequestBy(requestBy);

        motif_trnRepo.save(trnWsMotif);
    }
}
