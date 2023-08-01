package id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.mstBapkp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MstBapkpRepo extends JpaRepository<mstBapkp, String> {

    @Query(value = "SELECT * FROM ACCTMGMT.MST_BAPKP_V WHERE BASTBJ_ON_HAND = :bastbjOnHand AND BASTBJ_STATUS = :bastbjStatus", nativeQuery = true)
    List<mstBapkp> findBapkpByBastbjOnHandAndBastbjStatus (@Param("bastbjOnHand") String bastbjNo, @Param("bastbjStatus") String bastbjStatus);

}