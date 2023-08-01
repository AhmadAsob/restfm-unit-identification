package id.co.astra.fifgroup.project.restfm_unit_identification.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("insertRemTrnBucketPaidService")
public interface insertRemTrnBucketPaidService {
    public ResponseEntity insertRemTrnBucketPaid();

    public ResponseEntity findAllBucketPaid();

    public ResponseEntity findAllBucketPaidByContractNo(String contractNo);
}
