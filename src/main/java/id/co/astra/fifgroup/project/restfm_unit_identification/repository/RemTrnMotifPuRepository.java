package id.co.astra.fifgroup.project.restfm_unit_identification.repository;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.RemTrnMotifPu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RemTrnMotifPuRepository extends JpaRepository<RemTrnMotifPu, String> {

    @Query(value = "SELECT * FROM REM_TRN_MOTIF_PU WHERE PC_ID = :pcId AND CONTRACT_NO = :contractNo", nativeQuery = true)
    List<RemTrnMotifPu> findData(@Param("pcId") String pcId, @Param("contractNo") String contractNo);


    @Query(value = "select * from REM_TRN_MOTIF_PU where CONTRACT_NO = :contractNo AND BAPKP_NO = :bapkpNo ", nativeQuery = true)
    List<RemTrnMotifPu> getByContractNoAndBapkpNo (@Param("contractNo") String contractNo, @Param("bapkpNo") String bapkpNo);

    //find by pc id, contract no, bapkp no, and status
    @Query(value = "select * from REM_TRN_MOTIF_PU where PC_ID = :pcId AND CONTRACT_NO = :contractNo AND BAPKP_NO = :bapkpNo AND STATUS = :status ", nativeQuery = true)
    RemTrnMotifPu getByPcIdAndContractNoAndBapkpNoAndStatus (@Param("pcId") String pcId, @Param("contractNo") String contractNo, @Param("bapkpNo") String bapkpNo, @Param("status") String status);

//    @Query(value = "select * from REM_TRN_MOTIF_PU where CONTRACT_NO = :contractNo", nativeQuery = true)
//    RemTrnMotifPu getByIdContractNo(@Param("contractNo") String contractNo);


    @Transactional
    @Query(value = "update REM_TRN_MOTIF_PU u set u.STATUS = 'RTC' where u.CONTRACT_NO = :idcontractNo", nativeQuery = true)
    @Modifying
    void updateByIdContractNo(@Param("idcontractNo") String idcontractNo);

    RemTrnMotifPu getByIdContractNo(String idcontractNo);
}