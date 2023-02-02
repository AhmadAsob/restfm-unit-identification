package id.co.astra.fifgroup.project.restfm_unit_identification.repository;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.RiTrnMouHdr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RiTrnMouHdrRepository extends JpaRepository<RiTrnMouHdr, String> {

    @Query(value = "select * from fifapps.ri_trn_mou_hdrs where mou_no = ?1", nativeQuery = true)
    RiTrnMouHdr findByMouNo(String mouNo);


}