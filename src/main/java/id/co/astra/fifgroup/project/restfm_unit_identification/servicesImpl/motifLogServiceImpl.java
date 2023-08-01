package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.remWsMotifLog;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.motif_LogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

@Service("motifLogServiceImpl")
public class motifLogServiceImpl {

    @Autowired
    private motif_LogRepo motifLogRepo;

    public void insertLogMotif(String contractNo, String applNo, String requestType, String statusRequest, String messageStat, String requestBy){
        remWsMotifLog logMotif = new remWsMotifLog();
        UUID uuid = UUID.randomUUID();

        logMotif.setUuidMotif(uuid.toString());
        logMotif.setContractNo(contractNo);
        logMotif.setApplNo(applNo);
        logMotif.setRequestType(requestType);
        logMotif.setSendStat(statusRequest);
        logMotif.setMessageStat(messageStat);
        logMotif.setCreateDate(new Date());
        logMotif.setRequestBy(requestBy);

        motifLogRepo.save(logMotif);
    }
}
