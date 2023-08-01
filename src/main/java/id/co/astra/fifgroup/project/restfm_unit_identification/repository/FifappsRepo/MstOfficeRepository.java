package id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.mstOffice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MstOfficeRepository extends JpaRepository<mstOffice, String> {

//    @Query(value = "select * from FS_MST_OFFICE where TRUNC(CREATED_TIMESTAMP) = TO_DATE (:tanggalCreate,'DD/MM/YYYY') AND LASTUPDATE_TIMESTAMP is null", nativeQuery = true)
//    Page<mstOffice> findByCreateDateAndModifyDateIsNull(@Param("tanggalCreate") String tanggalCreate, Pageable pageable);
//
//    @Query(value = "select * from FS_MST_OFFICE where TRUNC(CREATED_TIMESTAMP) = TO_DATE (:tanggalCreate,'DD/MM/YYYY') AND TRUNC(LASTUPDATE_TIMESTAMP) = TO_DATE (:tanggalModify,'DD/MM/YYYY')", nativeQuery = true)
//    Page<mstOffice> findByCreateTimestampAndUpdateTimestamp(@Param("tanggalCreate") String  createDate, @Param("tanggalModify") String modifyDate, Pageable pageable);
//
//    @Query(value = "select * from FS_MST_OFFICE where CREATED_TIMESTAMP is null AND TRUNC(LASTUPDATE_TIMESTAMP) = TO_DATE (:tanggalModify,'DD/MM/YYYY')", nativeQuery = true)
//    Page<mstOffice> findByCreateTimestampIsNullAndUpdateTimestamp(@Param("tanggalModify") String modifyDate, Pageable pageable);
}