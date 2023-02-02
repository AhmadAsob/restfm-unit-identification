package id.co.astra.fifgroup.project.restfm_unit_identification.gateway;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseSkpcProcedure;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.skpcInputProcedure;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class skpcGetway {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Transactional
    public List<responseSkpcProcedure> skpcGetway(String skpcNo, String skpcDate, String skpcExpireDate, String pc, String contractNo, String type){

        List<responseSkpcProcedure> response = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        String message = null;
        String error = null;

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withSchemaName("ACCTMGMT")
                .withProcedureName("REM_P_SKPC_MOTIF_NEW")
                .withoutProcedureColumnMetaDataAccess().declareParameters(
                        new SqlParameter("P_SKPC_NO", OracleTypes.VARCHAR),
                        new SqlParameter("P_SKPC_DATE", OracleTypes.DATE),
                        new SqlParameter("P_SKPC_EXPIRED_DATE", OracleTypes.DATE),
                        new SqlParameter("P_PC", OracleTypes.VARCHAR),
                        new SqlParameter("P_CONTRACT_NO", OracleTypes.VARCHAR),
                        new SqlParameter("P_TYPE", OracleTypes.VARCHAR),
                        new SqlOutParameter("P_MESSAGE", OracleTypes.VARCHAR),
                        new SqlOutParameter("P_ERROR", OracleTypes.VARCHAR));

        jdbcCall.compile();

        MapSqlParameterSource msps = new MapSqlParameterSource();

        msps.addValue("P_SKPC_NO", skpcNo);
        if (skpcDate == "") {
            msps.addValue("P_SKPC_DATE", null);
        } else {
            msps.addValue("P_SKPC_DATE", LocalDate.parse(skpcDate, formatter));
        }
        if (skpcExpireDate == "") {
            msps.addValue("P_SKPC_EXPIRED_DATE", null);
        } else {
            msps.addValue("P_SKPC_EXPIRED_DATE", LocalDate.parse(skpcExpireDate, formatter));
        }
        msps.addValue("P_PC", pc);
        msps.addValue("P_CONTRACT_NO", contractNo);
        msps.addValue("P_TYPE", type);
        msps.addValue("P_MESSAGE", message);
        msps.addValue("P_ERROR", error);

        Map omap2 = jdbcCall.execute(msps);

        String skpc2 = (String) omap2.get("P_MESSAGE");
        String skpc = (String) omap2.get("P_ERROR");
        
        responseSkpcProcedure procedure = new responseSkpcProcedure();
        procedure.setMessage(skpc2);
        procedure.setError(skpc);

        response.add(procedure);

        return response;

    }
}
