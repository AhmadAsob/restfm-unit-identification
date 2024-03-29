package id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.mstMouHdrs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MstMouHdrsRepository extends JpaRepository<mstMouHdrs, String> {

//    @Query(value = "select * from MST_MOU_HDRS_V where TRUNC(CREATED_TIMESTAMP) = TO_DATE (:tanggalCreate,'DD/MM/YYYY') AND TRUNC(LASTUPDATE_TIMESTAMP) = TO_DATE (:tanggalModify,'DD/MM/YYYY')", nativeQuery = true)
//    List<mstMouHdrs> findByCreateTimestampAndaLastUpdateTimestamp(@Param("tanggalCreate") String  createdTimestamp, @Param("tanggalModify") String lastUpdateTimestamp);
//
//    @Query(value = "select * from MST_MOU_HDRS_V where TRUNC(CREATED_TIMESTAMP) = TO_DATE (:tanggalCreate,'DD/MM/YYYY') AND LASTUPDATE_TIMESTAMP is null", nativeQuery = true)
//    List<mstMouHdrs> findByCreateTimestampAndLastUpdateTimestampIsNull(@Param("tanggalCreate") String  createdTimestamp);
//
//    @Query(value = "select * from MST_MOU_HDRS_V where CREATED_TIMESTAMP is null AND TRUNC(LASTUPDATE_TIMESTAMP) = TO_DATE (:tanggalModify,'DD/MM/YYYY')", nativeQuery = true)
//    List<mstMouHdrs> findByCreateTimestampIsNullAndLastUpdateTimestamp(@Param("tanggalModify") String lastUpdateTimestamp);
}