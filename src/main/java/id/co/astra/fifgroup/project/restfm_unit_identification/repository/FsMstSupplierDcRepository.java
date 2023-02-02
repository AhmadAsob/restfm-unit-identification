package id.co.astra.fifgroup.project.restfm_unit_identification.repository;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FsMstSupplierDc;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FsMstSupplierDcId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface FsMstSupplierDcRepository extends JpaRepository<FsMstSupplierDc, FsMstSupplierDcId> {

    @Query(value = "select * from FIFAPPS.FS_MST_SUPPLIER_DC where SUPL_CODE = ?1 ", nativeQuery = true)
    FsMstSupplierDc getPersonalId(String supplierCode);
}