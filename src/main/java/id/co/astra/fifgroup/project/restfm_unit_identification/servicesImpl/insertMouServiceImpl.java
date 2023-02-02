package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.MouDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.RiTrnMouHdr;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.RiTrnMouHdrRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.insertMouRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service("insertMouServiceImpl")
public class insertMouServiceImpl implements insertMouRegistrationService {

    @Autowired
    private RiTrnMouHdrRepository riTrnMouHdrRepository;

    private HttpStatus StatusResponse;;

    public ResponseEntity insertMouRegistration(MouDto mouDto) {

        responseObj responseObj = new responseObj();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {

            RiTrnMouHdr riTrnMouHdr = new RiTrnMouHdr();

            riTrnMouHdr.setId(mouDto.getMouNo());
            if (riTrnMouHdr.getId() == null || riTrnMouHdr.getId().equals("")) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Mou No can't null");
                StatusResponse = HttpStatus.BAD_REQUEST;

            }else if (riTrnMouHdrRepository.findByMouNo(mouDto.getMouNo()) != null) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Mou No already exist");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
                riTrnMouHdr.setMouDate(LocalDate.parse(mouDto.getMouDate(), format));
                if (riTrnMouHdr.getMouDate() == null || riTrnMouHdr.getMouDate().equals("")) {
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage("Mou Date can't null");
                    StatusResponse = HttpStatus.BAD_REQUEST;
                } else {
                    riTrnMouHdr.setDescription(mouDto.getDescription());
                    riTrnMouHdr.setStartDate(LocalDate.parse(mouDto.getStartDate(), format));
                    if (riTrnMouHdr.getStartDate() == null || riTrnMouHdr.getStartDate().equals("")) {
                        responseObj.setRespHttpCode("400");
                        responseObj.setRespHttpMessage("Start Date can't null");
                        StatusResponse = HttpStatus.BAD_REQUEST;
                    } else {
                        riTrnMouHdr.setEndDate(LocalDate.parse(mouDto.getEndDate(), format));
                        if (riTrnMouHdr.getEndDate() == null || riTrnMouHdr.getEndDate().equals("")) {
                            responseObj.setRespHttpCode("400");
                            responseObj.setRespHttpMessage("End Date can't null");
                            StatusResponse = HttpStatus.BAD_REQUEST;
                        } else
                            riTrnMouHdr.setStatus(mouDto.getStatus());
                        if (riTrnMouHdr.getStatus() == null || riTrnMouHdr.getStatus().equals("")) {
                            responseObj.setRespHttpCode("400");
                            responseObj.setRespHttpMessage("Status can't null");
                            StatusResponse = HttpStatus.BAD_REQUEST;
                        } else {
                            riTrnMouHdr.setCreatedBy(mouDto.getCreatedBy());
                            if (riTrnMouHdr.getCreatedBy() == null || riTrnMouHdr.getCreatedBy().equals("")) {
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Created By can't null");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                                riTrnMouHdr.setCreatedTimestamp(LocalDate.parse(mouDto.getCreatedTimestamp(), formatter));
                                if (riTrnMouHdr.getCreatedTimestamp() == null || riTrnMouHdr.getCreatedTimestamp().equals("")) {
                                    responseObj.setRespHttpCode("400");
                                    responseObj.setRespHttpMessage("Created Timestamp can't null");
                                    StatusResponse = HttpStatus.BAD_REQUEST;
                                } else {
                                    riTrnMouHdr.setMouType(mouDto.getMouType());
                                    if (riTrnMouHdr.getMouType() == null || riTrnMouHdr.getMouType().equals("")) {
                                        responseObj.setRespHttpCode("400");
                                        responseObj.setRespHttpMessage("Mou Type can't null");
                                        StatusResponse = HttpStatus.BAD_REQUEST;
                                    } else {
                                        riTrnMouHdr.setSuplCode(mouDto.getSuplCode());
                                        if (riTrnMouHdr.getSuplCode() == null || riTrnMouHdr.getSuplCode().equals("")) {
                                            responseObj.setRespHttpCode("400");
                                            responseObj.setRespHttpMessage("Supl Code can't null");
                                            StatusResponse = HttpStatus.BAD_REQUEST;
                                        } else {
                                            riTrnMouHdr.setOfficeCode(mouDto.getOfficeCode());
                                            if (riTrnMouHdr.getOfficeCode() == null || riTrnMouHdr.getOfficeCode().equals("")) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Office Code can't null");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                                riTrnMouHdr.setSuplRevisePrice(mouDto.getSuplRevisePrice());
                                                if (riTrnMouHdr.getSuplRevisePrice() == null || riTrnMouHdr.getSuplRevisePrice().equals("")) {
                                                    responseObj.setRespHttpCode("400");
                                                    responseObj.setRespHttpMessage("Supl Revise Price can't null");
                                                    StatusResponse = HttpStatus.BAD_REQUEST;
                                                } else {
                                                    riTrnMouHdr.setCoyId(mouDto.getCoyId());
                                                    if (riTrnMouHdr.getCoyId() == null || riTrnMouHdr.getCoyId().equals("")) {
                                                        responseObj.setRespHttpCode("400");
                                                        responseObj.setRespHttpMessage("Coy Id can't null");
                                                        StatusResponse = HttpStatus.BAD_REQUEST;
                                                    } else {
                                                        responseObj.setRespHttpCode("200");
                                                        responseObj.setRespHttpMessage("Succesfully");
                                                        StatusResponse = HttpStatus.OK;
                                                        riTrnMouHdrRepository.save(riTrnMouHdr);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;

        }

        return new ResponseEntity(responseObj, StatusResponse);
    }
}

