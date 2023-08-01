package id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemTrnBucketPaid;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemTrnBucketPaidId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RemTrnBucketPaidRepository extends JpaRepository<RemTrnBucketPaid, RemTrnBucketPaidId> {

    @Query(value = "SELECT * FROM ACCTMGMT.REM_TRN_BUCKET_PAID WHERE PERIODE = TO_CHAR (SYSDATE, 'YYYYMM')", nativeQuery = true)
    List<RemTrnBucketPaid> findData();

    @Query(value = "SELECT * FROM ACCTMGMT.REM_TRN_BUCKET_PAID WHERE CONTRACT_NO = :contractNo AND PERIODE = TO_CHAR (SYSDATE, 'YYYYMM')", nativeQuery = true)
    List<RemTrnBucketPaid> findDataByContractNo(@Param("contractNo") String contractNo);
}