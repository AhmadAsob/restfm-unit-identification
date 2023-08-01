package id.co.astra.fifgroup.project.restfm_unit_identification.gateway;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.contractBucketDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.spcBucketDto;
import org.springframework.stereotype.Component;

import javax.imageio.plugins.jpeg.JPEGImageReadParam;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class spcBucketGateway {

    @PersistenceContext
    private EntityManager entityManager;

    public List<spcBucketDto> getSpcBucket() {

        String queryStr = "SELECT CONTRACT_NO, PERIODE FROM FIFOCM.CM_TRN_UPL_SPEC_BUCKETS A WHERE periode = TO_CHAR (SYSDATE, 'YYYYMM') AND IS_ACTIVE = 'Y' AND IS_STATUS = 'AP' AND NOT EXISTS (SELECT 1 FROM ACCTMGMT.REM_TRN_BUCKET_PAID WHERE PERIODE = A.PERIODE AND CONTRACT_NO = A.CONTRACT_NO)";
        Query query = entityManager.createNativeQuery(queryStr);

        List <Object[]> data = query.getResultList();
        List<spcBucketDto> dataBucket =new ArrayList<>();
        for (Object [] obj : data) {
            String contractNo = (String) obj[0];
            String periode = (String) obj[1];

            dataBucket.add(
                    new spcBucketDto(contractNo, periode));
        }
        return dataBucket;
    }

    public List<contractBucketDto> getContractBucket(String contractNo) {

        String queryStr = "SELECT CONTRACT_NO, PAID_DATE, CONTRACT_STATUS FROM FIFOCM.CM_TRN_CONTRACT_BUCKETS WHERE PERIODE = TO_CHAR (SYSDATE, 'YYYYMM') and CONTRACT_NO = '" + contractNo + "'";
        Query query = entityManager.createNativeQuery(queryStr);

        List <Object[]> data = query.getResultList();
        List<contractBucketDto> dataBucket =new ArrayList<>();
        for (Object [] obj : data) {
            String contractNoo = (String) obj[0];
            Date paidDate = (Date) obj[1];
            String contractStatus = (String) obj[2];

            dataBucket.add(
                    new contractBucketDto(contractNoo, paidDate, contractStatus));
        }
        return dataBucket;
    }
}
