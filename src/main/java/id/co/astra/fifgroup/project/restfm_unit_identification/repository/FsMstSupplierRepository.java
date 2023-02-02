package id.co.astra.fifgroup.project.restfm_unit_identification.repository;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FsMstSupplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface FsMstSupplierRepository extends JpaRepository<FsMstSupplier, String> {

    @Query(value = "SELECT SUPL_BRANCH_ID FROM FIFAPPS.FS_MST_SUPPLIER WHERE SUPL_CODE = :pc", nativeQuery = true)
    String suplBranchId (@Param("pc") String pc);

}