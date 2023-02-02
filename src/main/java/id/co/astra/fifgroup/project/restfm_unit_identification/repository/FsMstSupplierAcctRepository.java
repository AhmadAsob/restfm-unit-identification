package id.co.astra.fifgroup.project.restfm_unit_identification.repository;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FsMstSupplierAcct;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FsMstSupplierAcctId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FsMstSupplierAcctRepository extends JpaRepository<FsMstSupplierAcct, FsMstSupplierAcctId> {
}