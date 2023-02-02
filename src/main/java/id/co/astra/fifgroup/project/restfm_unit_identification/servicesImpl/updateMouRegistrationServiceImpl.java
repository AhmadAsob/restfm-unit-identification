package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.MouDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.RiTrnMouHdr;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.RiTrnMouHdrRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.updateMouRegistrationService;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service("updateMouRegistrationServiceImpl")
public class updateMouRegistrationServiceImpl implements updateMouRegistrationService {

    @Autowired
    private RiTrnMouHdrRepository riTrnMouHdrRepository;

    private HttpStatus StatusResponse;

    public ResponseEntity updateMouRegistration(String mouId, MouDto riTrnMouHdr) {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        RiTrnMouHdr riTrnMouHdr1 = riTrnMouHdrRepository.getById(mouId);
        responseObj responseObj = new responseObj();
        try {

            if (riTrnMouHdr1 != null) {
                riTrnMouHdr1.setMouDate(LocalDate.parse(riTrnMouHdr.getMouDate(), format));
                riTrnMouHdr1.setDescription(riTrnMouHdr.getDescription());
                riTrnMouHdr1.setStartDate(LocalDate.parse(riTrnMouHdr.getStartDate(), format));
                riTrnMouHdr1.setEndDate(LocalDate.parse(riTrnMouHdr.getEndDate(), format));
                riTrnMouHdr1.setStatus(riTrnMouHdr.getStatus());
                if (riTrnMouHdr1.getStatus() == null || riTrnMouHdr1.getStatus().equals("")) {
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage("Supl Code can't null");
                    StatusResponse = HttpStatus.BAD_REQUEST;
                }
                riTrnMouHdr1.setSuplCode(riTrnMouHdr.getSuplCode());

                responseObj.setRespHttpCode("200");
                responseObj.setRespHttpMessage("Succesfully");
                StatusResponse = HttpStatus.OK;
                riTrnMouHdrRepository.save(riTrnMouHdr1);

            } else {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Mou Id not found");
                StatusResponse = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity(responseObj, StatusResponse);
    }

}
