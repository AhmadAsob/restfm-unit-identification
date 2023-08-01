package id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.mstProvinsi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MstProvinsiRepository extends JpaRepository<mstProvinsi, String> {
}