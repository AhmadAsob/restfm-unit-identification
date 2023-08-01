package id.co.astra.fifgroup.project.restfm_unit_identification.gateway;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.dataPickupDto;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;

@Component
public class getSumBayarGateway {

    @PersistenceContext
    private EntityManager entityManager;

    public BigDecimal getSumBayar(String contractNo){

        String queryStr = "SELECT SUM (PRNC_AMT_DTL_CUST_PAID\n" +
                "           + INTR_AMT_DTL_AR_PAID\n" +
                "           + PENALTY_AMT_PAID\n" +
                "           + COLL_FEE_PAID)\n" +
                "  FROM acctmgmt.ar_trn_installment_dtls A,FIFOCM.CM_TRN_CONTRACT_BUCKETS B\n" +
                "  where A.REFERENCE_NO=B.RV_NO\n" +
                "  AND B.PERIODE=TO_CHAR(SYSDATE,'YYYYMM')\n" +
                "  AND B.CONTRACT_NO= '" + contractNo + "'";

        Query query = entityManager.createNativeQuery(queryStr);
        BigDecimal data = (BigDecimal) query.getSingleResult();

        return data;
    }

    public dataPickupDto getPalNoBapkpNo(String contractNo){

        String queryStr = "SELECT pu.pal_no, pu.bastbj_no\n" +
                "  FROM REPINVT.RI_TRN_PICKUP_HDR PU, ACCTMGMT.AR_TRN_SUM_CONTRACTS ATSC\n" +
                " WHERE PU.CONTRACT_NO = ATSC.CONTRACT_NO \n" +
                " AND PU.PAL_NO = ATSC.CURR_PAL_NO\n" +
                " and pu.status='OK' and ATSC.CONTRACT_NO = '" + contractNo + "'";

        Query query = entityManager.createNativeQuery(queryStr);
        Object result = null;

        try {
            result = query.getSingleResult();
        } catch (NoResultException e) {
            // Handle case when there's no result (optional)
        }

        // Check if the result is not null and convert it to dataPickupDto
        if (result != null) {
            Object[] row = (Object[]) result;
            dataPickupDto data = new dataPickupDto((String) row[0], (String) row[1]);
            return data;
        } else {
            // Return null or throw an exception, depending on your use case
            return null;
        }
    }
}
