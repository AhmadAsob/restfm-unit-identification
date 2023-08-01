package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.InsertDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity.*;
import id.co.astra.fifgroup.project.restfm_unit_identification.gateway.RemLogMotifErrGateway;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.FsMstPersonalDatumRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.FsMstSupplierAcctRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.FsMstSupplierDcRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo.FsMstSupplierRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.updateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service("updateServiceImpl")
public class updateServiceImpl implements updateService {

    @Autowired
    private FsMstSupplierRepository supplierRepository;

    @Autowired
    private FsMstSupplierAcctRepository supplierAcctRepository;

    @Autowired
    private FsMstSupplierDcRepository dcRepository;

    @Autowired
    private FsMstPersonalDatumRepository datumRepository;

    @Autowired
    private RemLogMotifErrGateway remLogMotifErrGateway;


    private HttpStatus StatusResponse;

    public ResponseEntity update(String suplCode, InsertDto insertDto) {

        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        FsMstSupplier fsMstSupplier = supplierRepository.getById(suplCode);

        FsMstSupplierAcctId fsMstSupplierAcctId = new FsMstSupplierAcctId();
        fsMstSupplierAcctId.setSuplCode(suplCode);
        fsMstSupplierAcctId.setSuplAccountSeqn(Short.parseShort("1"));
        FsMstSupplierAcct fsMstSupplierAcct = supplierAcctRepository.getById(fsMstSupplierAcctId);

//        FsMstSupplierDcId fsMstSupplierDcId = new FsMstSupplierDcId();
//
//            fsMstSupplierDcId.setSuplCode(suplCode);

        FsMstSupplierDc fsMstSupplierDc = dcRepository.getPersonalId(suplCode);

        String personalId = dcRepository.getPersonalId2(suplCode);
        System.out.println("personalId = " + personalId);

        FsMstPersonalDatum fsMstPersonalDatum = datumRepository.getById(personalId);

        responseObj responseObj = new responseObj();

        try{
            if(fsMstSupplier != null){
                if (insertDto.getSuplBranchId() != null){
                    fsMstSupplier.setSuplBranchId(insertDto.getSuplBranchId());
                } else {
                    fsMstSupplier.setSuplBranchId(fsMstSupplier.getSuplBranchId());
                }
                if (insertDto.getSuplName() != null){
                    fsMstSupplier.setSuplName(insertDto.getSuplName());
                } else {
                    fsMstSupplier.setSuplName(fsMstSupplier.getSuplName());
                }
                if (insertDto.getSuplAddress1() != null){
                    fsMstSupplier.setSuplAddress1(insertDto.getSuplAddress1());
                } else {
                    fsMstSupplier.setSuplAddress1(fsMstSupplier.getSuplAddress1());
                }
                if (insertDto.getSuplAddress2() != null){
                    fsMstSupplier.setSuplAddress2(insertDto.getSuplAddress2());
                } else {
                    fsMstSupplier.setSuplAddress2(fsMstSupplier.getSuplAddress2());
                }
                if (insertDto.getSuplCity() != null){
                    fsMstSupplier.setSuplCity(insertDto.getSuplCity());
                } else {
                    fsMstSupplier.setSuplCity(fsMstSupplier.getSuplCity());
                }
                if ( insertDto.getSuplProvince() != null ){
                if (insertDto.getSuplProvince().length() > 20 || insertDto.getSuplProvince() != null){
                    fsMstSupplier.setSuplProvince(insertDto.getSuplProvince().substring(0, Math.min(insertDto.getSuplProvince().length(), 20)));
                }
                else if (insertDto.getSuplProvince().length() <= 20 || insertDto.getSuplProvince() != null){
                    fsMstSupplier.setSuplProvince(insertDto.getSuplProvince());
                }}
                else {
                    fsMstSupplier.setSuplProvince(fsMstSupplier.getSuplProvince());
                }
                if (insertDto.getSuplZipCode() != null){
                    fsMstSupplier.setSuplZipcode(insertDto.getSuplZipCode());
                } else {
                    fsMstSupplier.setSuplZipcode(fsMstSupplier.getSuplZipcode());
                }
                if (insertDto.getSuplTelp1() != null){
                    fsMstSupplier.setSuplTelp1(insertDto.getSuplTelp1());
                } else {
                    fsMstSupplier.setSuplTelp1(fsMstSupplier.getSuplTelp1());
                }
                if (insertDto.getSuplFax() != null){
                    fsMstSupplier.setSuplFax(insertDto.getSuplFax());
                } else {
                    fsMstSupplier.setSuplFax(fsMstSupplier.getSuplFax());
                }
                if (insertDto.getSuplEmail() != null){
                    fsMstSupplier.setSuplEmail(insertDto.getSuplEmail());
                } else {
                    fsMstSupplier.setSuplEmail(fsMstSupplier.getSuplEmail());
                }
                if (insertDto.getSuplNpwp() != null){
                    fsMstSupplier.setSuplNpwp(insertDto.getSuplNpwp());
                } else {
                    fsMstSupplier.setSuplNpwp(fsMstSupplier.getSuplNpwp());
                }
                if (insertDto.getSuplUserApproved() != null){
                    fsMstSupplier.setSuplUserApproved(insertDto.getSuplUserApproved());
                } else {
                    fsMstSupplier.setSuplUserApproved(fsMstSupplier.getSuplUserApproved());
                }
                if(insertDto.getSuplDateApproved() != null || insertDto.getSuplDateApproved() == ""){
                    fsMstSupplier.setSuplDateApproved(LocalDate.parse(insertDto.getSuplDateApproved(), formatter));
                }else{
                    fsMstSupplier.setSuplDateApproved(null);
                }
                if(insertDto.getSuplStatus() != null || insertDto.getSuplStatus() == ""){
                    fsMstSupplier.setSuplStatus(insertDto.getSuplStatus());
                }else{
                    fsMstSupplier.setSuplStatus(fsMstSupplier.getSuplStatus());
                }
                if (insertDto.getSuplType() != null){
                    fsMstSupplier.setSuplType(insertDto.getSuplType());
                } else {
                    fsMstSupplier.setSuplType(fsMstSupplier.getSuplType());
                }
                fsMstSupplier.setSuplSubType("8");
                if (insertDto.getSuplCreatedBy() != null){
                    fsMstSupplier.setSuplCreatedBy(insertDto.getSuplCreatedBy());
                } else {
                    fsMstSupplier.setSuplCreatedBy(fsMstSupplier.getSuplCreatedBy());
                }
                if (insertDto.getSuplCreatedDate() != null || insertDto.getSuplCreatedDate() == ""){
                    fsMstSupplier.setSuplCreatedDate(LocalDateTime.parse(insertDto.getSuplCreatedDate(), formatter2));
                }else{
                    fsMstSupplier.setSuplCreatedDate(null);
                }
                fsMstSupplier.setSuplGroupId("000");
                if (insertDto.getSuplCompType() != null){
                    fsMstSupplier.setSuplCompType(insertDto.getSuplCompType());
                } else {
                    fsMstSupplier.setSuplCompType(fsMstSupplier.getSuplCompType());
                }
                if (insertDto.getSuplBranchId() != null){
                    fsMstSupplier.setSuplLocation(insertDto.getSuplBranchId());
                } else {
                    fsMstSupplier.setSuplLocation(fsMstSupplier.getSuplLocation());
                }
                if (insertDto.getSuplNpwpName() != null){
                    fsMstSupplier.setSuplNpwpName(insertDto.getSuplNpwpName());
                } else {
                    fsMstSupplier.setSuplNpwpName(fsMstSupplier.getSuplNpwpName());
                }
                if (insertDto.getSuplNpwpAddress() != null){
                    fsMstSupplier.setSuplNpwpAddress(insertDto.getSuplNpwpAddress());
                } else {
                    fsMstSupplier.setSuplNpwpAddress(fsMstSupplier.getSuplNpwpAddress());
                }
                fsMstSupplier.setCoyId("01");
                if (insertDto.getSuplKecamatan() != null){
                    fsMstSupplier.setSuplKecamatan(insertDto.getSuplKecamatan());
                } else {
                    fsMstSupplier.setSuplKecamatan(fsMstSupplier.getSuplKecamatan());
                }
                if (insertDto.getSuplKelurahan() != null){
                    fsMstSupplier.setSuplKelurahan(insertDto.getSuplKelurahan());
                } else {
                    fsMstSupplier.setSuplKelurahan(fsMstSupplier.getSuplKelurahan());
                }
                if (insertDto.getPersonalIdIndentifikasi() != null){
                    fsMstSupplier.setSuplNik(insertDto.getPersonalIdIndentifikasi());
                } else {
                    fsMstSupplier.setSuplNik(fsMstSupplier.getSuplNik());
                }
                if (insertDto.getSuplPkp() != null){
                    fsMstSupplier.setSuplPkp(insertDto.getSuplPkp());
                } else {
                    fsMstSupplier.setSuplPkp(fsMstSupplier.getSuplPkp());
                }
                if (insertDto.getPcSubType() != null || insertDto.getPcSubType() == ""){
                    fsMstSupplier.setPcSubType(Long.parseLong(insertDto.getPcSubType()));
                }else{
                    fsMstSupplier.setPcSubType(fsMstSupplier.getPcSubType());
                }
                fsMstSupplier.setSuplNonPph(insertDto.getSuplNonPph());
                if (insertDto.getSuplNonPphStartdate() != null || insertDto.getSuplNonPphStartdate() == ""){
                    fsMstSupplier.setSuplNonPphStartdate(LocalDate.parse(insertDto.getSuplNonPphStartdate(),formatter));
                }else{
                    fsMstSupplier.setSuplNonPphStartdate(fsMstSupplier.getSuplNonPphStartdate());
                }
                if (insertDto.getSuplNonPphEnddate() != null || insertDto.getSuplNonPphEnddate() == ""){
                    fsMstSupplier.setSuplNonPphEnddate(LocalDate.parse(insertDto.getSuplNonPphEnddate(),formatter));
                }else{
                    fsMstSupplier.setSuplNonPphEnddate(fsMstSupplier.getSuplNonPphEnddate());
                }
                if (insertDto.getSuplNonPphDocno() != null ){
                    fsMstSupplier.setSuplNonPphDocno(insertDto.getSuplNonPphDocno());
                }else{
                    fsMstSupplier.setSuplNonPphDocno(fsMstSupplier.getSuplNonPphDocno());
                }
                if (insertDto.getSuplSiup() != null){
                    fsMstSupplier.setSuplSiup(insertDto.getSuplSiup());
                }else{
                    fsMstSupplier.setSuplSiup(fsMstSupplier.getSuplSiup());
                }
                if (insertDto.getSuplTdp() != null){
                    fsMstSupplier.setSuplTdp(insertDto.getSuplTdp());
                }else{
                    fsMstSupplier.setSuplTdp(fsMstSupplier.getSuplTdp());
                }
                if(insertDto.getSuplTdpExpdate() != null){
                    fsMstSupplier.setSuplTdpExpdate(LocalDate.parse(insertDto.getSuplTdpExpdate(),formatter));
                }else{
                    fsMstSupplier.setSuplTdpExpdate(null);
                }

                if (insertDto.getSuplBankId() != null){
                    fsMstSupplierAcct.setSuplBankId(insertDto.getSuplBankId());
                }else{
                    fsMstSupplierAcct.setSuplBankId(fsMstSupplierAcct.getSuplBankId());
                }
                if (insertDto.getSuplBankName() != null){
                    fsMstSupplierAcct.setSuplBankName(insertDto.getSuplBankName());
                }else{
                    fsMstSupplierAcct.setSuplBankName(fsMstSupplierAcct.getSuplBankName());
                }
                if (insertDto.getSuplAccountNo() != null){
                    fsMstSupplierAcct.setSuplAccountNo(insertDto.getSuplAccountNo());
                }else{
                    fsMstSupplierAcct.setSuplAccountNo(fsMstSupplierAcct.getSuplAccountNo());
                }
                if (insertDto.getSuplAccountName() != null){
                    fsMstSupplierAcct.setSuplAccountName(insertDto.getSuplAccountName());
                }else{
                    fsMstSupplierAcct.setSuplAccountName(fsMstSupplierAcct.getSuplAccountName());
                }
                if (insertDto.getSuplAccStatus() != null){
                    fsMstSupplierAcct.setSuplAccStatus(insertDto.getSuplAccStatus());
                } else {
                    fsMstSupplierAcct.setSuplAccStatus(fsMstSupplierAcct.getSuplAccStatus());
                }
                fsMstSupplierAcct.setSuplAccCurr("IDR");
                if (insertDto.getSuplCreatedBy() != null){
                    fsMstSupplierAcct.setSuplCreatedBy(insertDto.getSuplCreatedBy());
                }else{
                    fsMstSupplierAcct.setSuplCreatedBy(fsMstSupplierAcct.getSuplCreatedBy());
                }
                if (insertDto.getSuplCreatedDate() != null){
                    fsMstSupplierAcct.setSuplCreatedDate(LocalDateTime.parse(insertDto.getSuplCreatedDate(),formatter2));
                }else{
                    fsMstSupplierAcct.setSuplCreatedDate(fsMstSupplierAcct.getSuplCreatedDate());
                }
                if (insertDto.getSuplCreatedBy() != null){
                    fsMstSupplierAcct.setCreatedBy(insertDto.getSuplCreatedBy());
                }else{
                    fsMstSupplierAcct.setCreatedBy(fsMstSupplierAcct.getCreatedBy());
                }
                if (insertDto.getSuplCreatedDate() != null){
                    fsMstSupplierAcct.setCreatedTimestamp(LocalDateTime.parse(insertDto.getSuplCreatedDate(),formatter2));
                }else{
                    fsMstSupplierAcct.setCreatedTimestamp(fsMstSupplierAcct.getCreatedTimestamp());
                }
                if (insertDto.getPersonalId() != null){
                    fsMstSupplierDc.setPersonalId(insertDto.getPersonalId());
                    fsMstSupplierDc.setSuplCode(suplCode);
                } else {
                    fsMstSupplierDc.setPersonalId(fsMstSupplierDc.getPersonalId());
                }
                if (insertDto.getSuplCreatedBy() != null){
                    fsMstSupplierDc.setCreatedBy(insertDto.getSuplCreatedBy());
                }else{
                    fsMstSupplierDc.setCreatedBy(fsMstSupplierDc.getCreatedBy());
                }
                if (insertDto.getSuplCreatedDate() != null){
                    fsMstSupplierDc.setCreatedDate(LocalDate.parse(insertDto.getSuplCreatedDate(),formatter2));
                }else{
                    fsMstSupplierDc.setCreatedDate(fsMstSupplierDc.getCreatedDate());
                }
                fsMstSupplierDc.setModifiedBy("MOTIF");
                fsMstSupplierDc.setModifiedDate(LocalDate.now());

                if(insertDto.getPersonalId() != null){
                    fsMstPersonalDatum.setId(insertDto.getPersonalId());
                }else{
                    fsMstPersonalDatum.setId(fsMstPersonalDatum.getId());
                }
                if(insertDto.getPersonalFullName() != null){
                    fsMstPersonalDatum.setPersonalFullName(insertDto.getPersonalFullName());
                }else{
                    fsMstPersonalDatum.setPersonalFullName(fsMstPersonalDatum.getPersonalFullName());
                }
                if (insertDto.getPersonalBirtPlace() != null){
                    fsMstPersonalDatum.setPersonalBirtPlace(insertDto.getPersonalBirtPlace());
                }else{
                    fsMstPersonalDatum.setPersonalBirtPlace(fsMstPersonalDatum.getPersonalBirtPlace());
                }
                if (insertDto.getPersonalBirtDate() != null){
                    fsMstPersonalDatum.setPersonalBirtDate(LocalDate.parse(insertDto.getPersonalBirtDate(),formatter));
                }else{
                    fsMstPersonalDatum.setPersonalBirtDate(fsMstPersonalDatum.getPersonalBirtDate());
                }
                System.out.println("pesonalIdAddr1" + insertDto.getPersonalIdAddr1());
                if (insertDto.getPersonalIdAddr1() != null){
                    fsMstPersonalDatum.setPersonalAddr1(insertDto.getPersonalIdAddr1());
                }else{
                    fsMstPersonalDatum.setPersonalAddr1(fsMstPersonalDatum.getPersonalAddr1());
                }
                if (insertDto.getPersonalIdCity() != null){
                    fsMstPersonalDatum.setPersonalCity(insertDto.getPersonalIdCity());
                }else{
                    fsMstPersonalDatum.setPersonalCity(fsMstPersonalDatum.getPersonalCity());
                }
                if (insertDto.getPersonalZipCode() != null){
                    fsMstPersonalDatum.setPersonalZipCode(insertDto.getPersonalZipCode());
                }else{
                    fsMstPersonalDatum.setPersonalZipCode(fsMstPersonalDatum.getPersonalZipCode());
                }
                if (insertDto.getPersonalReligion() != null){
                    fsMstPersonalDatum.setPersonalReligion(insertDto.getPersonalReligion());
                }else{
                    fsMstPersonalDatum.setPersonalReligion(fsMstPersonalDatum.getPersonalReligion());
                }
                if (insertDto.getPersonalSex() != null){
                    fsMstPersonalDatum.setPersonalSex(insertDto.getPersonalSex());
                }else{
                    fsMstPersonalDatum.setPersonalSex(fsMstPersonalDatum.getPersonalSex());
                }
                if (insertDto.getPersonalMaritalSts() != null){
                    fsMstPersonalDatum.setPersonalMaritalSts(insertDto.getPersonalMaritalSts());
                }else{
                    fsMstPersonalDatum.setPersonalMaritalSts(fsMstPersonalDatum.getPersonalMaritalSts());
                }
                if (insertDto.getPersonalMobilephone() != null){
                    fsMstPersonalDatum.setPersonalMobilephone(insertDto.getPersonalMobilephone());
                }else{
                    fsMstPersonalDatum.setPersonalMobilephone(fsMstPersonalDatum.getPersonalMobilephone());
                }
                if (insertDto.getPersonalEmail() != null){
                    fsMstPersonalDatum.setPersonalEmail(insertDto.getPersonalEmail());
                }else{
                    fsMstPersonalDatum.setPersonalEmail(fsMstPersonalDatum.getPersonalEmail());
                }
                if (insertDto.getSuplCreatedBy() != null){
                    fsMstPersonalDatum.setPersonalModifiedBy(insertDto.getSuplCreatedBy());
                }else{
                    fsMstPersonalDatum.setPersonalModifiedBy(fsMstPersonalDatum.getPersonalModifiedBy());
                }
                if (insertDto.getSuplCreatedDate() != null){
                    fsMstPersonalDatum.setPersonalModifiedDate(LocalDateTime.parse(insertDto.getSuplCreatedDate(),formatter2));
                }else{
                    fsMstPersonalDatum.setPersonalModifiedDate(fsMstPersonalDatum.getPersonalModifiedDate());
                }
                if (insertDto.getLastEducationLvl() != null){
                    fsMstPersonalDatum.setLastEducationLvl(insertDto.getLastEducationLvl());
                }else{
                    fsMstPersonalDatum.setLastEducationLvl(fsMstPersonalDatum.getLastEducationLvl());
                }
                if (insertDto.getPersonalIdEmcName() != null){
                    fsMstPersonalDatum.setPersonalIdEmcName(insertDto.getPersonalIdEmcName());
                }else{
                    fsMstPersonalDatum.setPersonalIdEmcName(fsMstPersonalDatum.getPersonalIdEmcName());
                }
                if (insertDto.getPersonalIdEmcAddr1() != null){
                    fsMstPersonalDatum.setPersonalIdEmcAddr1(insertDto.getPersonalIdEmcAddr1());
                }else{
                    fsMstPersonalDatum.setPersonalIdEmcAddr1(fsMstPersonalDatum.getPersonalIdEmcAddr1());
                }
                if (insertDto.getPersonalIdEmcPhone() != null){
                    fsMstPersonalDatum.setPersonalIdEmcPhone(insertDto.getPersonalIdEmcPhone());
                }else{
                    fsMstPersonalDatum.setPersonalIdEmcPhone(fsMstPersonalDatum.getPersonalIdEmcPhone());
                }
                if (insertDto.getPersonalIdIndentifikasi() != null){
                    fsMstPersonalDatum.setPersonalIdIndentifikasi(insertDto.getPersonalIdIndentifikasi());
                }else{
                    fsMstPersonalDatum.setPersonalIdIndentifikasi(fsMstPersonalDatum.getPersonalIdIndentifikasi());
                }
                if (insertDto.getPersonalIdKecamatan() != null){
                    fsMstPersonalDatum.setPersonalKecamatan(insertDto.getPersonalIdKecamatan());
                }else{
                    fsMstPersonalDatum.setPersonalKecamatan(fsMstPersonalDatum.getPersonalKecamatan());
                }
                if (insertDto.getPersonalIdKelurahan() != null){
                    fsMstPersonalDatum.setPersonalKelurahan(insertDto.getPersonalIdKelurahan());
                }else{
                    fsMstPersonalDatum.setPersonalKelurahan(fsMstPersonalDatum.getPersonalKelurahan());
                }
                if (insertDto.getPersonalIdRtRw() != null){
                    fsMstPersonalDatum.setPersonalRtrw(insertDto.getPersonalIdRtRw());
                }else{
                    fsMstPersonalDatum.setPersonalRtrw(fsMstPersonalDatum.getPersonalRtrw());
                }
                fsMstPersonalDatum.setPersonalStatus("AC");
                if (insertDto.getPersonalAddr1() != null){
                    fsMstPersonalDatum.setPersonalDmsAddr1(insertDto.getPersonalAddr1());
                }else{
                    fsMstPersonalDatum.setPersonalDmsAddr1(fsMstPersonalDatum.getPersonalDmsAddr1());
                }
                if (insertDto.getPersonalRtRw() != null){
                    fsMstPersonalDatum.setPersonalDmsRtrw(insertDto.getPersonalRtRw());
                }else{
                    fsMstPersonalDatum.setPersonalDmsRtrw(fsMstPersonalDatum.getPersonalDmsRtrw());
                }
                if (insertDto.getPersonalKelurahan() != null){
                    fsMstPersonalDatum.setPersonalDmsKelurahan(insertDto.getPersonalKelurahan());
                }else{
                    fsMstPersonalDatum.setPersonalDmsKelurahan(fsMstPersonalDatum.getPersonalDmsKelurahan());
                }
                if (insertDto.getPersonalKecamatan() != null){
                    fsMstPersonalDatum.setPersonalDmsKecamatan(insertDto.getPersonalKecamatan());
                }else{
                    fsMstPersonalDatum.setPersonalDmsKecamatan(fsMstPersonalDatum.getPersonalDmsKecamatan());
                }
                if (insertDto.getPersonalCity() != null){
                    fsMstPersonalDatum.setPersonalDmsCity(insertDto.getPersonalCity());
                }else{
                    fsMstPersonalDatum.setPersonalDmsCity(fsMstPersonalDatum.getPersonalDmsCity());
                }
                if (insertDto.getPersonalZipCode() != null){
                    fsMstPersonalDatum.setPersonalDmsZipCode(insertDto.getPersonalZipCode());
                }else{
                    fsMstPersonalDatum.setPersonalDmsZipCode(fsMstPersonalDatum.getPersonalDmsZipCode());
                }
                if (insertDto.getPersonalSertProfesiDate() != null){
                    fsMstPersonalDatum.setSertifikasiDate(LocalDate.parse(insertDto.getPersonalSertProfesiDate(),formatter));
                }else{
                    fsMstPersonalDatum.setSertifikasiDate(fsMstPersonalDatum.getSertifikasiDate());
                }
                if (insertDto.getPersonalSertProfesi() != null){
                    fsMstPersonalDatum.setSertifikasiNo(insertDto.getPersonalSertProfesi());
                }else{
                    fsMstPersonalDatum.setSertifikasiNo(fsMstPersonalDatum.getSertifikasiNo());
                }

                supplierRepository.save(fsMstSupplier);
                supplierAcctRepository.save(fsMstSupplierAcct);
                dcRepository.save(fsMstSupplierDc);
                datumRepository.save(fsMstPersonalDatum);

                responseObj.setRespHttpCode("200");
                responseObj.setRespHttpMessage("Succesfully");
                StatusResponse = HttpStatus.OK;

            } else {
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Supl Code not found");
                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "UPDATE_PC_REGISTRATION", "Can't update to table");
                StatusResponse = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e){
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "UPDATE_PC_REGISTRATION", "Can't update to table");
            StatusResponse = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity(responseObj, StatusResponse);
    }


    private String convertObjectToJson(Object data, boolean isIncludeNull) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        if (isIncludeNull) {
            gsonBuilder.serializeNulls();
        }
        Gson gson = gsonBuilder.create();
        return gson.toJson(data);
    }}
