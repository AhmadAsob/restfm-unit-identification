package id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemTrnSkpc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RemTrnSKPCRepository extends JpaRepository<RemTrnSkpc, String> {
    RemTrnSkpc getByPcAndContractNoAndIdSkpcNo(String pc, String contractNo, String idskpcNo);

    @Query (value = "SELECT * FROM ACCTMGMT.REM_TRN_SKPC WHERE PC = :pc AND CONTRACT_NO = :contractNo AND SKPC_NO = :skpcNo AND to_char(SKPC_DATE,'DD-MM-YYYY') =     :skpcDate", nativeQuery = true)
    RemTrnSkpc findStatusSkpcByParam(@Param("pc") String pc, @Param("contractNo") String contractNo, @Param("skpcNo") String skpcNo, @Param("skpcDate") String skpcDate);

    @Query(value = "SELECT * FROM ACCTMGMT.REM_TRN_SKPC WHERE CONTRACT_NO = :contractNo and PC = :pc and STATUS_SKPC = 'AC' and SKPC_NO = :skpcNo", nativeQuery = true)
    List<RemTrnSkpc> skpcService(@Param("contractNo") String contractNo, @Param("pc") String pc, @Param("skpcNo") String skpcNo);

    @Transactional
    @Modifying
    @Query(value = "UPDATE ACCTMGMT.REM_TRN_SKPC SET STATUS_SKPC = 'CL', SKPC_EXPIRED_DATE = SYSDATE, LASTUPDATE_BY = 'MOTIF', LASTUPDATE_TIMESTAMP = SYSDATE WHERE CONTRACT_NO = :contractNo and PC = :pc and STATUS_SKPC = 'AC' and SKPC_NO = :skpcNo", nativeQuery = true)
    void skpcServiceUpdate (@Param("contractNo") String contractNo, @Param("pc") String pc, @Param("skpcNo") String skpcNo);

    @Query(value = "SELECT * FROM ACCTMGMT.REM_TRN_SKPC WHERE SKPC_NO = :skpcNo", nativeQuery = true)
    RemTrnSkpc findBySkpcNo(@Param("skpcNo") String skpcNo);


//    @Query(value = "select * from REM_TRN_SKPC where TRUNC(CREATED_TIMESTAMP) = TO_DATE (:tanggalCreate,'DD/MM/YYYY') AND TRUNC(LASTUPDATE_TIMESTAMP) = TO_DATE (:tanggalModify,'DD/MM/YYYY')", nativeQuery = true)
//    List<RemTrnSkpc> createTimestampAndaLastUpdateTimestamp(@Param("tanggalCreate") String  createdTimestamp, @Param("tanggalModify") String lastUpdateTimestamp);
//
//    @Query(value = "select * from REM_TRN_SKPC where TRUNC(CREATED_TIMESTAMP) = TO_DATE (:tanggalCreate,'DD/MM/YYYY') AND LASTUPDATE_TIMESTAMP is null", nativeQuery = true)
//    List<RemTrnSkpc> createTimestampAndLastUpdateTimestampIsNull(@Param("tanggalCreate") String  createdTimestamp);
//
//    @Query(value = "select * from REM_TRN_SKPC where CREATED_TIMESTAMP is null AND TRUNC(LASTUPDATE_TIMESTAMP) = TO_DATE (:tanggalModify,'DD/MM/YYYY')", nativeQuery = true)
//    List<RemTrnSkpc> createTimestampIsNullAndLastUpdateTimestamp(@Param("tanggalModify") String lastUpdateTimestamp);
}
