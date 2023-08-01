package id.co.astra.fifgroup.project.restfm_unit_identification.gateway;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Component
public class lawyerGateway {

    @PersistenceContext
    private EntityManager entitiyManager;

    public String getCurrPalNo(String contractNo) {
        String queryStr = "SELECT CURR_PAL_NO FROM ACCTMGMT.AR_TRN_SUM_CONTRACTS WHERE CONTRACT_NO = '" + contractNo +"'";
        Query query = entitiyManager.createNativeQuery(queryStr);
    //        query.setParameter("contractNo", contractNo);
        String dataTo = (String) query.getSingleResult();

        return dataTo;
    }

    public String getNominalPembayaran(String contractNo, String periode){

        String queryStr = "SELECT PRNC_AC + INTR_AC + PENALTY_AC FROM FIFOCM.CM_TRN_CONTRACT_BUCKETS WHERE CONTRACT_NO = '" + contractNo +"' and PERIODE = '" + periode + "'";
        Query query = entitiyManager.createNativeQuery(queryStr);
        System.out.println(queryStr);
        System.out.println(query);
//        query.setParameter("contractNo", contractNo);
//        query.setParameter("periode", periode);
        String dataTo = query.getSingleResult().toString();
        System.out.println(dataTo);

        return dataTo;
    }

    public String getEmplCode(String contractNo){

        String queryStr = "SELECT CREATED_BY FROM REPINVT.RI_TRN_PICKUP_HDR WHERE CONTRACT_NO = '" + contractNo + "'";
        Query query = entitiyManager.createNativeQuery(queryStr);
        try {
            String dataTo = query.getSingleResult().toString();
            return dataTo;
        } catch (NoResultException e) {
            throw new RuntimeException("Unit belum dipickup di FIFAPPS / GRAN");
        }
    }

    public String getEmplName (String emplCode){

        String queryStr = "SELECT EMPL_NAME FROM FIFAPPS.FS_MST_EMPLOYEES WHERE EMPL_CODE = '" + emplCode + "'";
        Query query = entitiyManager.createNativeQuery(queryStr);
//        query.setParameter("emplCode", emplCode);
        String dataTo = query.getSingleResult().toString();

        return dataTo;
    }

    public String getBapkpNo (String contractNo, String periode){

        String queryStr = "SELECT BASTBJ_NO FROM REPINVT.RI_TRN_PICKUP_HDR WHERE CONTRACT_NO = '" + contractNo + "'";
        Query query = entitiyManager.createNativeQuery(queryStr);
        try {
            String dataTo = query.getSingleResult().toString();
            return dataTo;
        } catch (NoResultException e) {
            throw new RuntimeException("Unit belum dipickup di FIFAPPS / GRAN");
        }
    }
}
