package id.co.astra.fifgroup.project.restfm_unit_identification.repository;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.CmMstCtrMapOffice;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstCompany;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface MstCompanyRepository extends JpaRepository<mstCompany, String> {

//    @Query(value = "select * from MST_COMPANY_V where trunc(create_date) = to_date(:tanggalCreate,'DD/MM/YYYY') AND TRUNC(UPDATE_DATE) = TO_DATE (:tanggalUpdate,'DD/MM/YYYY')", nativeQuery = true)
//    List<mstCompany> findByCreateDateAndUpdateDate(@Param("tanggalCreate") String tanggalCreate, @Param("tanggalUpdate") String tanggalUpdate);
//
//    @Query(value = "select * from MST_COMPANY_V where TRUNC(CREATE_DATE) = TO_DATE (:tanggalCreate,'DD/MM/YYYY') AND UPDATE_DATE is null", nativeQuery = true)
//    List<mstCompany> findByCreateDateAndUpdateDateIsNull(@Param("tanggalCreate") String tanggalCreate);
//
//    @Query(value = "select * from MST_COMPANY_V where CREATE_DATE is null AND TRUNC(UPDATE_DATE) = TO_DATE (:tanggalUpdate,'DD/MM/YYYY')", nativeQuery = true)
//    List<mstCompany> findByCreateDateIsNullAndUpdateDate(@Param("tanggalUpdate") String tanggalUpdate);
}