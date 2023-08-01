package id.co.astra.fifgroup.project.restfm_unit_identification.repository.FmUiRepo;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FmUiEntity.uiMstParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UiMstParamRepository extends JpaRepository<uiMstParam, Integer> {

    @Query(value = "select group_name from UI_MST_PARAM where hasil_penugasan = :hasilPenugasan", nativeQuery = true)
    String findGroupName (@Param("hasilPenugasan") String hasilPenugasan);

}