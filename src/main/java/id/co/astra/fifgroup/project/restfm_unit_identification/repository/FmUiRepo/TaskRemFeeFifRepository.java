package id.co.astra.fifgroup.project.restfm_unit_identification.repository.FmUiRepo;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FmUiEntity.taskRemFeeFif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface TaskRemFeeFifRepository extends JpaRepository<taskRemFeeFif, Integer> {

    @Query(value = "SELECT A.ID,A.TASK_ID,A.CONTRACT_NO,A.TIPE_PENUGASAN,A.OFFICE_CODE,A.STATUS_TASK,A.HASIL_PENUGASAN,A.TANGGAL_VERIFIKASI,A.MITRA_CODE,A.PERIODE\n" +
            "  FROM TASK_REM_FEE_FIF A , FMUI.UI_MST_PARAM B\n" +
            " WHERE     PERIODE = TO_CHAR (SYSDATE, 'YYYYMM')\n" +
            " AND A.HASIL_PENUGASAN=B.HASIL_PENUGASAN\n" +
            "       AND NOT EXISTS\n" +
            "               (SELECT 1\n" +
            "                  FROM FMUI.UI_TRN_REM_FEE\n" +
            "                 WHERE     A.CONTRACT_NO = CONTRACT_NO\n" +
            "                       AND MITRA_CODE = A.MITRA_CODE\n" +
            "                       AND PERIODE = TO_CHAR (SYSDATE, 'YYYYMM'))", nativeQuery = true)
    List<taskRemFeeFif> findLoopData();

    @Query(value = "SELECT A.ID, A.TASK_ID,CONTRACT_NO,A.TIPE_PENUGASAN,A.OFFICE_CODE,A.STATUS_TASK,A.HASIL_PENUGASAN,A.TANGGAL_VERIFIKASI,A.MITRA_CODE,A.PERIODE\n" +
            "  FROM TASK_REM_FEE_FIF A , FMUI.UI_MST_PARAM B\n" +
            " WHERE     PERIODE = TO_CHAR (SYSDATE, 'YYYYMM')\n" +
            " AND A.HASIL_PENUGASAN=B.HASIL_PENUGASAN\n" +
            "       AND NOT EXISTS\n" +
            "               (SELECT 1\n" +
            "                  FROM FMUI.UI_TRN_REM_FEE\n" +
            "                 WHERE     A.CONTRACT_NO = CONTRACT_NO\n" +
            "                       AND MITRA_CODE = A.MITRA_CODE\n" +
            "                       AND PERIODE = TO_CHAR (SYSDATE, 'YYYYMM'))", nativeQuery = true)
    List<taskRemFeeFif> findLoopDataThe1st();
}