package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.lawyerDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemTrnMotifPu;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.RemTrnMotifPuId;
import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.lawyerGateway;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.RemTrnMotifPuRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.postTaskLawyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service("postTaskLawyerServiceImpl")
public class postTaskLawyerServiceImpl implements postTaskLawyerService {

    @Autowired
    private RemTrnMotifPuRepository remTrnMotifPuRepository;

    @Autowired
    lawyerGateway lawyerGateway;

    private HttpStatus StatusResponse;

    public ResponseEntity postTaskLawyer(lawyerDto lawyerDto) {

        responseObj responseObj = new responseObj();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM");
        String tahun = String.valueOf(LocalDate.now().getYear());
        String bulan = String.valueOf(LocalDate.now().format(formatter));
        String ym = tahun + bulan;

        try {

            RemTrnMotifPuId remTrnMotifPuId = new RemTrnMotifPuId();

            remTrnMotifPuId.setPcId(lawyerDto.getPcId());
            if (remTrnMotifPuId.getPcId() == null || remTrnMotifPuId.getPcId().equals("")) {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Pc Id can't null");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
                remTrnMotifPuId.setCreatedTimestamp(LocalDateTime.now());
                remTrnMotifPuId.setContractNo(lawyerDto.getContractNo());

                if (remTrnMotifPuId.getContractNo() == null || remTrnMotifPuId.getContractNo().equals("")) {
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage("Contract No can't null");
                    StatusResponse = HttpStatus.BAD_REQUEST;
                } else {

                    RemTrnMotifPu remTrnMotifPu = new RemTrnMotifPu();
                    remTrnMotifPu.setId(remTrnMotifPuId);
                    if (lawyerGateway.getCurrPalNo(lawyerDto.getContractNo()) == null || lawyerGateway.getCurrPalNo(lawyerDto.getContractNo()).equals("")){
                        remTrnMotifPu.setPalNo("");
                        System.out.println(remTrnMotifPu.getPalNo() + "0");
                    } else {
                        remTrnMotifPu.setPalNo(lawyerGateway.getCurrPalNo(lawyerDto.getContractNo()));
                        System.out.println(remTrnMotifPu.getPalNo() + "1");
                    }
                    System.out.println(remTrnMotifPu.getPalNo());
                    remTrnMotifPu.setOfficeCode(lawyerDto.getOfficeCode());
                    if (remTrnMotifPu.getOfficeCode() == null || remTrnMotifPu.getOfficeCode().equals("")){
                        responseObj.setRespHttpCode("400");
                        responseObj.setRespHttpMessage("Office Code can't null");
                        StatusResponse = HttpStatus.BAD_REQUEST;
                    } else {
                        remTrnMotifPu.setAlasan(lawyerDto.getAlasan());
                        remTrnMotifPu.setStatus(lawyerDto.getStatus());
                        if (remTrnMotifPu.getStatus() == null || remTrnMotifPu.getStatus().equals("")){
                            responseObj.setRespHttpCode("400");
                            responseObj.setRespHttpMessage("Status can't null");
                            StatusResponse = HttpStatus.BAD_REQUEST;
                        } else {
                            remTrnMotifPu.setType(lawyerDto.getType());
                            System.out.println(remTrnMotifPu.getType());
                            if(remTrnMotifPu.getType() == null || remTrnMotifPu.getType().equals("")) {
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Type can't null");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            }else if (remTrnMotifPu.getType() == "BAYAR" || remTrnMotifPu.getType().equals("BAYAR")){
                                System.out.println(ym);
                                Long nominalPembayaran = Long.valueOf(lawyerGateway.getNominalPembayaran(lawyerDto.getContractNo(), ym));
                                System.out.println("nominalPembayaran : " + nominalPembayaran);
                                remTrnMotifPu.setNominalPembayaran(nominalPembayaran);
                                if (nominalPembayaran == 0 || nominalPembayaran.equals(0)){
                                    responseObj.setRespHttpCode("400");
                                    responseObj.setRespHttpMessage("Konsumen belum melakukan pembayaran");
                                    StatusResponse = HttpStatus.BAD_REQUEST;
                                } else {
                                    responseObj.setRespHttpCode("200");
                                    responseObj.setRespHttpMessage("Succesfully");
                                    StatusResponse = HttpStatus.OK;
                                    remTrnMotifPuRepository.save(remTrnMotifPu);
                                }
                            } else if (remTrnMotifPu.getType() == "PICKUP" || remTrnMotifPu.getType().equals("PICKUP")){
                                String periode = String.valueOf(LocalDate.now());
                                String bapkpNo = null;
                                try{
                                    bapkpNo = lawyerGateway.getBapkpNo(lawyerDto.getContractNo(), periode);
                                    remTrnMotifPu.setBapkpNo(bapkpNo);
                                    remTrnMotifPu.setNominalPembayaran(Long.valueOf("0"));
                                    String emplCode = lawyerGateway.getEmplCode(lawyerDto.getContractNo());
                                    remTrnMotifPu.setEmplCode(emplCode);
                                    remTrnMotifPu.setEmplName(lawyerGateway.getEmplName(emplCode));

                                    responseObj.setRespHttpCode("200");
                                    responseObj.setRespHttpMessage("Succesfully");
                                    StatusResponse = HttpStatus.OK;
                                    remTrnMotifPuRepository.save(remTrnMotifPu);

                                } catch (RuntimeException e) {
                                    responseObj.setRespHttpCode("400");
                                    responseObj.setRespHttpMessage(e.getMessage());
                                    StatusResponse = HttpStatus.BAD_REQUEST;
                                    return new ResponseEntity(responseObj, StatusResponse);
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
