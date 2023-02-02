package id.co.astra.fifgroup.project.restfm_unit_identification.repository;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.CmMstCtrMapOffice;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstJobCodes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MstJobCodesRepository extends JpaRepository<mstJobCodes, String> {

//    @Query(value = "select * from MST_JOB_CODES_V where TRUNC(CREATED_TIMESTAMP) = TO_DATE (:tanggalCreate,'DD/MM/YYYY') AND TRUNC(LASTUPDATE_TIMESTAMP) = TO_DATE (:tanggalUpdate,'DD/MM/YYYY')", nativeQuery = true)
//    List<mstJobCodes> getByCreatedTimestampAndLastUpdateTimestamp(@Param("tanggalCreate") String createDate, @Param("tanggalUpdate") String updateDate);
//
//    @Query(value = "select * from MST_JOB_CODES_V where TRUNC(CREATED_TIMESTAMP) = TO_DATE (:tanggalCreate,'DD/MM/YYYY') AND LASTUPDATE_TIMESTAMP is null", nativeQuery = true)
//    List<mstJobCodes> getByCreatedTimestampAndLastUpdateTimestampIsNull(@Param("tanggalCreate") String createDate);
//
//    @Query(value = "select * from MST_JOB_CODES_V where CREATED_TIMESTAMP is null AND TRUNC(LASTUPDATE_TIMESTAMP) = TO_DATE (:tanggalUpdate,'DD/MM/YYYY')", nativeQuery = true)
//    List<mstJobCodes> getByCreatedTimestampIsNullAndLastUpdateTimestamp(@Param("tanggalUpdate") String updateDate);
}