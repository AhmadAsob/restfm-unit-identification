package id.co.astra.fifgroup.project.restfm_unit_identification.repository;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.CmMstCtrMapOfficeParamDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.CmMstCtrMapOffice;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.CmMstCtrMapOfficeId;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@Transactional
public interface CmMstCtrMapOfficeRepository extends JpaRepository<CmMstCtrMapOffice, CmMstCtrMapOfficeId> {
//
//    @Query(value = "select * from FIFOCM.CM_MST_CTR_MAP_OFFICE where TRUNC(CREATE_DATE) = TO_DATE (:tanggalCreate,'DD/MM/YYYY') AND MODIFY_DATE is null", nativeQuery = true)
//    List<CmMstCtrMapOffice> findByCreateDateAndModifyDateIsNull(@Param("tanggalCreate") String tanggalCreate);
//
//    @Query(value = "select * from FIFOCM.CM_MST_CTR_MAP_OFFICE where TRUNC(CREATE_DATE) = TO_DATE (:tanggalCreate,'DD/MM/YYYY') AND TRUNC(MODIFY_DATE) = TO_DATE (:tanggalModify,'DD/MM/YYYY')", nativeQuery = true)
//    List<CmMstCtrMapOffice> getByCreateDateAndModifyDate(@Param("tanggalCreate") String  createDate, @Param("tanggalModify") String modifyDate);
//
//    @Query(value = "select * from FIFOCM.CM_MST_CTR_MAP_OFFICE where CREATE_DATE is null AND TRUNC(MODIFY_DATE) = TO_DATE (:tanggalModify,'DD/MM/YYYY')", nativeQuery = true)
//    List<CmMstCtrMapOffice> getByCreateDateIsNullAndModifyDate(@Param("tanggalModify") String modifyDate);
}