package id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.FsMstSupplierAcct;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.FsMstSupplierAcctId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FsMstSupplierAcctRepository extends JpaRepository<FsMstSupplierAcct, FsMstSupplierAcctId> {
}