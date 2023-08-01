package id.co.astra.fifgroup.project.restfm_unit_identification.services;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.lawyerDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service("postTaskLawyerService")
public interface postTaskLawyerService {

    public ResponseEntity postTaskLawyer(lawyerDto lawyerDto);
}
