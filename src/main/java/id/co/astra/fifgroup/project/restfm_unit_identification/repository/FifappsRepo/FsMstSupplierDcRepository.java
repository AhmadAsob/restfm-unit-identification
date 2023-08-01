package id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.FsMstSupplierDc;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.FsMstSupplierDcId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FsMstSupplierDcRepository extends JpaRepository<FsMstSupplierDc, FsMstSupplierDcId> {

    @Query(value = "select * from FIFAPPS.FS_MST_SUPPLIER_DC where SUPL_CODE = ?1 ", nativeQuery = true)
    FsMstSupplierDc getPersonalId(String supplierCode);

    @Query(value = "select PERSONAL_ID from FIFAPPS.FS_MST_SUPPLIER_DC where SUPL_CODE = ?1 ", nativeQuery = true)
    String getPersonalId2(String supplierCode);
}