package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.contractBucketDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseFiduciaObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.spcBucketDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.remTrnBucketPaidGateway;
import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.spcBucketGateway;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.RemTrnBucketPaidRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.insertRemTrnBucketPaidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("insertRemTrnBucketPaidServiceImpl")
public class insertRemTrnBucketPaidServiceImpl implements insertRemTrnBucketPaidService {

    @Autowired
    private spcBucketGateway gateway;

    @Autowired
    private remTrnBucketPaidGateway remTrnBucketPaidGateway;

    @Autowired
    private RemTrnBucketPaidRepository remTrnBucketPaidRepository;

    private HttpStatus StatusResponse;

    @Override
    public ResponseEntity insertRemTrnBucketPaid (){
        responseObj responseObj = new responseObj();

        try {
            List<spcBucketDto> spcBucket = gateway.getSpcBucket();
            for (int i = 0; i < spcBucket.size(); i++) {
                List<contractBucketDto> contractBucket = gateway.getContractBucket(spcBucket.get(i).getContractNo());
                for (int j = 0; j < contractBucket.size(); j++) {
                    System.out.println(contractBucket.get(j));
                if (contractBucket.get(j).getPaidDate() != null && contractBucket.get(j).getContractStatus() == "PU"){
                    remTrnBucketPaidGateway.insertRemTrnBucketPaid(spcBucket.get(i).getPeriode(),spcBucket.get(i).getContractNo(), "Y", "Y", "/restfmui/v1/bucket-paid");
                    responseObj.setRespHttpCode("200");
                    responseObj.setRespHttpMessage("Succesfully");
                    StatusResponse = HttpStatus.OK;
                } else if (contractBucket.get(j).getPaidDate() == null && contractBucket.get(j).getContractStatus().equals("PU")){
                    remTrnBucketPaidGateway.insertRemTrnBucketPaid(spcBucket.get(i).getPeriode(),spcBucket.get(i).getContractNo(), "N", "Y", "/restfmui/v1/bucket-paid");
                    responseObj.setRespHttpCode("200");
                    responseObj.setRespHttpMessage("Succesfully");
                    StatusResponse = HttpStatus.OK;
                } else if (contractBucket.get(j).getPaidDate() != null && contractBucket.get(j).getContractStatus() != "PU"){
                    remTrnBucketPaidGateway.insertRemTrnBucketPaid(spcBucket.get(i).getPeriode(),spcBucket.get(i).getContractNo(), "Y", "N", "/restfmui/v1/bucket-paid");
                    responseObj.setRespHttpCode("200");
                    responseObj.setRespHttpMessage("Succesfully");
                    StatusResponse = HttpStatus.OK;
                } else if (contractBucket.get(j).getPaidDate() == null && contractBucket.get(j).getContractStatus() != "PU"){
                    responseObj.setRespHttpCode("200");
                    responseObj.setRespHttpMessage("Succesfully");
                    StatusResponse = HttpStatus.OK;
                }
                }
            }



        } catch (Exception e){
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }

    @Override
    public ResponseEntity findAllBucketPaid(){
        responseFiduciaObj responseObj = new responseFiduciaObj();
        try{
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            responseObj.setData(remTrnBucketPaidRepository.findData());
            StatusResponse = HttpStatus.OK;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }

    @Override
    public ResponseEntity findAllBucketPaidByContractNo(String contractNo){
        responseFiduciaObj responseObj = new responseFiduciaObj();
        try{
            responseObj.setRespHttpCode("200");
            responseObj.setRespHttpMessage("Succesfully");
            responseObj.setData(remTrnBucketPaidRepository.findDataByContractNo(contractNo));
            StatusResponse = HttpStatus.OK;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }
}
