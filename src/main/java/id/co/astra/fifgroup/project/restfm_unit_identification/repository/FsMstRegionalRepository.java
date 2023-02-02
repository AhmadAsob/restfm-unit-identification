package id.co.astra.fifgroup.project.restfm_unit_identification.repository;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.FsMstRegionalDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FsMstRegional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FsMstRegionalRepository extends JpaRepository<FsMstRegional, String> {

//    @Query(value = "select * from FIFAPPS.FS_MST_REGIONALS where TRUNC(CREATED_TIMESTAMP) = TO_DATE (:tanggalCreate,'DD/MM/YYYY') AND LASTUPDATE_TIMESTAMP is null", nativeQuery = true)
//    List<FsMstRegional> findByCreateDateAndModifyDateIsNull(@Param("tanggalCreate") String tanggalCreate);
//
//    @Query(value = "select * from FIFAPPS.FS_MST_REGIONALS where TRUNC(CREATED_TIMESTAMP) = TO_DATE (:tanggalCreate,'DD/MM/YYYY') AND TRUNC(LASTUPDATE_TIMESTAMP) = TO_DATE (:tanggalModify,'DD/MM/YYYY')", nativeQuery = true)
//    List<FsMstRegional> findByCreateTimestampAndUpdateTimestamp(@Param("tanggalCreate") String  createDate, @Param("tanggalModify") String modifyDate);
//
//    @Query(value = "select * from FIFAPPS.FS_MST_REGIONALS where CREATED_TIMESTAMP is null AND TRUNC(LASTUPDATE_TIMESTAMP) = TO_DATE (:tanggalModify,'DD/MM/YYYY')", nativeQuery = true)
//    List<FsMstRegional> findByCreateTimestampIsNullAndUpdateTimestamp(@Param("tanggalModify") String modifyDate);

}