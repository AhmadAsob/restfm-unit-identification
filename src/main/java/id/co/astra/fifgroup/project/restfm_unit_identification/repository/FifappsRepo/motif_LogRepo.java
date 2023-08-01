package id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.remWsMotifLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

@Repository
@Transactional
public interface motif_LogRepo extends JpaRepository<remWsMotifLog, String> {

    @Query(value = "SELECT APPL_NO " +
            "FROM ACCTMGMT.AR_TRN_SUM_CONTRACTS" +
            "WHERE CONTRACT_NO = :contractNo", nativeQuery = true)
    String queryStr(@Param("contractNo") String contractNo);
}
