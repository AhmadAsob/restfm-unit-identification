package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseSkpcProcedure;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemTrnSkpc;
import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.skpcGetway;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.RemTrnSKPCRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllRemTrnSkpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("findAllMstRemTrnSkpcServiceImpl")
public class findAllRemTrnSkpcServiceImpl implements findAllRemTrnSkpcService {

    @Autowired
    private RemTrnSKPCRepository remTrnSKPCRepository;

    @Autowired
    public skpcGetway skpcGetway;


    private HttpStatus StatusResponse;

    @Value("${pageLimit.skpc}")
    private int pageLimit;

    @Override
    public ResponseEntity findAllRemTrnSkpc(
//            String createdTimestamp, String lastUpdateTimestamp,
            Integer page) {{
            responseFiduciaObj responseObj = new responseFiduciaObj();
//        if (createdTimestamp == "" && lastUpdateTimestamp == ""){
            try {
                Page<RemTrnSkpc> mstMouHdrs = remTrnSKPCRepository.findAll(PageRequest.of(page, pageLimit));
                responseObj.setRespHttpCode("200");
                responseObj.setRespHttpMessage("Successfully");
                responseObj.setData(mstMouHdrs);
                StatusResponse = HttpStatus.OK;
            } catch (Exception e) {
                responseObj.setRespHttpCode("01");
                responseObj.setRespHttpMessage("Failed");
                responseObj.setData(e.getMessage());
                StatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
            }
//        } else if (lastUpdateTimestamp == null) {
//            try {
//                List<RemTrnSkpc> mstMouHdrs = remTrnSKPCRepository.createTimestampAndLastUpdateTimestampIsNull(createdTimestamp);
//                responseObj.setRespHttpCode("200");
//                responseObj.setRespHttpMessage("Successfully");
//                responseObj.setData(mstMouHdrs);
//                StatusResponse = HttpStatus.OK;
//            } catch (Exception e) {
//                responseObj.setRespHttpCode("01");
//                responseObj.setRespHttpMessage("Failed");
//                responseObj.setData(e.getMessage());
//                StatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
//            }
//        } else if (createdTimestamp == null) {
//            try {
//                List<RemTrnSkpc> mstMouHdrs = remTrnSKPCRepository.createTimestampIsNullAndLastUpdateTimestamp(lastUpdateTimestamp);
//                responseObj.setRespHttpCode("200");
//                responseObj.setRespHttpMessage("Successfully");
//                responseObj.setData(mstMouHdrs);
//                StatusResponse = HttpStatus.OK;
//            } catch (Exception e) {
//                responseObj.setRespHttpCode("01");
//                responseObj.setRespHttpMessage("Failed");
//                responseObj.setData(e.getMessage());
//                StatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
//            }
//        } else {
//            try {
//                List<RemTrnSkpc> mstMouHdrs = remTrnSKPCRepository.createTimestampAndaLastUpdateTimestamp(createdTimestamp, lastUpdateTimestamp);
//                responseObj.setRespHttpCode("200");
//                responseObj.setRespHttpMessage("Successfully");
//                responseObj.setData(mstMouHdrs);
//                StatusResponse = HttpStatus.OK;
//            } catch (Exception e) {
//                responseObj.setRespHttpCode("01");
//                responseObj.setRespHttpMessage("Failed");
//                responseObj.setData(e.getMessage());
//                StatusResponse = HttpStatus.INTERNAL_SERVER_ERROR;
//            }
//        }
            return new ResponseEntity(responseObj, StatusResponse);
        }
    }

    @Override
    public List<responseSkpcProcedure> skpcProcedure (String skpcNo, String skpcDate, String skpcExpireDate, String pc, String contractNo, String type){
        List<responseSkpcProcedure> skpc = skpcGetway.skpcGetway(skpcNo, skpcDate, skpcExpireDate, pc, contractNo, type);
        return skpc;
    }
}
