package id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.ArTrnSumContract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArTrnSumContractRepository extends JpaRepository<ArTrnSumContract, String> {

    @Query(value = "SELECT COY_ID FROM ACCTMGMT.AR_TRN_SUM_CONTRACTS WHERE CONTRACT_NO = :contractNo", nativeQuery = true)
    String coyId (@Param("contractNo") String contractNo);

    @Query(value = "SELECT CURR_PAL_NO FROM ACCTMGMT.AR_TRN_SUM_CONTRACTS WHERE CONTRACT_NO = :contractNo", nativeQuery = true)
    String currPalNo (@Param("contractNo") String contractNo);

}