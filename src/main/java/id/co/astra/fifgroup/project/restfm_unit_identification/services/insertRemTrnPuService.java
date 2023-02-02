package id.co.astra.fifgroup.project.restfm_unit_identification.services;


import id.co.astra.fifgroup.project.restfm_unit_identification.dto.RemTrnMotifPuInsertDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.RemTrnSkpcDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.RemTrnSkpcParamDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("insertRemTrnPuService")
public interface insertRemTrnPuService {
    public ResponseEntity insertRemTrnPu(RemTrnMotifPuInsertDto remTrnMotifPuDto);

    public ResponseEntity getByContractNoAndBapkpNo(RemTrnSkpcParamDto remTrnSkpcParamDto);

    public ResponseEntity changeStatus(String contractNo);

    public ResponseEntity getByContractNo(RemTrnMotifPuInsertDto remTrnMotifPuInsertDto);
}
