package id.co.astra.fifgroup.project.restfm_unit_identification.gateway;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemTrnBucketPaid;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemTrnBucketPaidId;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.RemTrnBucketPaidRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service("remTrnBucketPaidGateway")
public class remTrnBucketPaidGateway {

    @Autowired
    RemTrnBucketPaidRepository remTrnBucketPaidRepository;

    public RemTrnBucketPaid insertRemTrnBucketPaid(String periode, String contractNo, String paid, String pickup, String createdBy){

        RemTrnBucketPaidId remTrnBucketPaidId = new RemTrnBucketPaidId();
        remTrnBucketPaidId.setPeriode(periode);
        remTrnBucketPaidId.setContractNo(contractNo);

        RemTrnBucketPaid remTrnBucketPaid = new RemTrnBucketPaid();
        remTrnBucketPaid.setId(remTrnBucketPaidId);
        remTrnBucketPaid.setPaid(paid);
        remTrnBucketPaid.setPickup(pickup);
        remTrnBucketPaid.setCreatedDate(LocalDateTime.now());
        remTrnBucketPaid.setCreatedBy(createdBy);
        remTrnBucketPaid.setUpdateDate(null);
        remTrnBucketPaid.setUpdateBy(null);

        return remTrnBucketPaidRepository.save(remTrnBucketPaid);
    }
}
