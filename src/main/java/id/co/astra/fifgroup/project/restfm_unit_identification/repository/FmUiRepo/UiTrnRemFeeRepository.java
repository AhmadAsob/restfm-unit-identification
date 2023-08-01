package id.co.astra.fifgroup.project.restfm_unit_identification.repository.FmUiRepo;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FmUiEntity.uiTrnRemFee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UiTrnRemFeeRepository extends JpaRepository<uiTrnRemFee, Integer> {
}