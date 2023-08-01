package id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.ArTrnMotifResultAr;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.ArTrnMotifResultArId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArTrnMotifResultArRepository extends JpaRepository<ArTrnMotifResultAr, ArTrnMotifResultArId> {

    @Query(value = "select RECEIVE_INSTALLMENT + RECEIVE_PENALTY + RECEIVE_COLL_FEE from acctmgmt.ar_trn_motif_result_ar where contract_no = :contractNo", nativeQuery = true)
    Integer totalAmount (@Param("contractNo") String contractNo);
}