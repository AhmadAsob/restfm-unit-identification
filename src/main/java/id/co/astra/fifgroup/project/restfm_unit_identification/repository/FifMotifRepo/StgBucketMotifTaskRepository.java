package id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifMotifRepo;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifMotifEntity.StgBucketMotifTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StgBucketMotifTaskRepository extends JpaRepository<StgBucketMotifTask, String> {

    @Query(value = "select * from STG_BUCKET_MOTIF_TASK where stg_no_lkp = :noLkp and stg_seqn = :seqn and stg_no_kontrak = :noKontrak", nativeQuery = true)
    StgBucketMotifTask updateSendFlag(@Param("noLkp") String noLkp, @Param("seqn") String seqn, @Param("noKontrak") String noKontrak);
}