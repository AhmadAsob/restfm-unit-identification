package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.mstMouHdrs;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.FsMstSupplierRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.MstMouHdrsRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMstMouHdrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("findAllMstMouHdrsServiceImpl")
public class findAllMstMouHdrsServiceImpl implements findAllMstMouHdrsService {

    @Autowired
    private MstMouHdrsRepository mstMouHdrsRepository;

    @Autowired
    private FsMstSupplierRepository supplierRepository;

    private HttpStatus StatusResponse;

    @Value("${pageLimit.mou}")
    private int pageLimit;

    @Override
    public ResponseEntity findAllMstMouHdrs(
//            String createdTimestamp, String lastUpdateTimestamp,
            int page) {
        responseFiduciaObj responseObj = new responseFiduciaObj();
//        if (createdTimestamp == "" && lastUpdateTimestamp == ""){
            try {
                Page<mstMouHdrs> mstMouHdrs = mstMouHdrsRepository.findAll(PageRequest.of(page, pageLimit));
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
//                List<mstMouHdrs> mstMouHdrs = mstMouHdrsRepository.findByCreateTimestampAndLastUpdateTimestampIsNull(createdTimestamp);
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
//                List<mstMouHdrs> mstMouHdrs = mstMouHdrsRepository.findByCreateTimestampIsNullAndLastUpdateTimestamp(lastUpdateTimestamp);
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
//                List<mstMouHdrs> mstMouHdrs = mstMouHdrsRepository.findByCreateTimestampAndaLastUpdateTimestamp(createdTimestamp, lastUpdateTimestamp);
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
