package id.co.astra.fifgroup.project.restfm_unit_identification.servicesImpl;

import id.co.astra.fifgroup.project.restfm_unit_identification.dto.InsertDto;
import id.co.astra.fifgroup.project.restfm_unit_identification.dto.responseObj;
import id.co.astra.fifgroup.project.restfm_unit_identification.entity.*;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FsMstPersonalDatumRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FsMstSupplierAcctRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FsMstSupplierDcRepository;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.FsMstSupplierRepository;
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

        FsMstPersonalDatum fsMstPersonalDatum = datumRepository.getById(suplCode);

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
                if (insertDto.getSuplProvince().length() > 20 || insertDto.getSuplProvince() != null){
                    fsMstSupplier.setSuplProvince(insertDto.getSuplProvince().substring(0, Math.min(insertDto.getSuplProvince().length(), 20)));
                }
                else if (insertDto.getSuplProvince().length() <= 20 || insertDto.getSuplProvince() != null){
                    fsMstSupplier.setSuplProvince(insertDto.getSuplProvince());
                }
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
                fsMstSupplier.setSuplTelp2("");
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
                fsMstSupplier.setSuplPic("");
                if (insertDto.getSuplNpwp() != null){
                    fsMstSupplier.setSuplNpwp(insertDto.getSuplNpwp());
                } else {
                    fsMstSupplier.setSuplNpwp(fsMstSupplier.getSuplNpwp());
                }
                fsMstSupplier.setSuplTglPkp(null);
                fsMstSupplier.setSuplTaxCode("");
                fsMstSupplier.setSuplTermPayment(null);
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
                fsMstSupplier.setSuplModifiedBy("");
                fsMstSupplier.setSuplGroupId("000");
                fsMstSupplier.setCreatedBy("");
                fsMstSupplier.setLastupdateBy("");
                fsMstSupplier.setSuplOutletType("");
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
                fsMstSupplier.setSuplAuthorize("");
                fsMstSupplier.setSuplRegionalId("");
                fsMstSupplier.setSuplMaindealerId("");
                fsMstSupplier.setSuplCompName("");
                fsMstSupplier.setSuplPersonalIdOwner("");
                fsMstSupplier.setSuplPersonalIdPic("");
                fsMstSupplier.setSuplDecisionMakerDesc("");
                fsMstSupplier.setSuplDecisionMakerRelation("TEST");
                fsMstSupplier.setSuplDecisionMaker("OWN");
                fsMstSupplier.setSuplNpwpOld("");
                fsMstSupplier.setSuplNpwpNameOld("");
                fsMstSupplier.setSuplNpwpAddressOld("");
                fsMstSupplier.setSuplNpwp2("");
                fsMstSupplier.setSuplNpwpName2("");
                fsMstSupplier.setSuplNpwpAddress2("");
                fsMstSupplier.setSuplNpwpOld2("");
                fsMstSupplier.setSuplNpwpNameOld2("");
                fsMstSupplier.setSuplNpwpAddressOld2("");
                fsMstSupplier.setSuplTaxCode2("");
                fsMstSupplier.setSuplNpwp3("");
                fsMstSupplier.setSuplNpwpName3("");
                fsMstSupplier.setSuplNpwpAddress3("");
                fsMstSupplier.setSuplNpwpOld3("");
                fsMstSupplier.setSuplNpwpNameOld3("");
                fsMstSupplier.setSuplNpwpAddressOld3("");
                fsMstSupplier.setSuplTaxCode3("");
                fsMstSupplier.setSuplNpwpAddress1("");
                fsMstSupplier.setSuplCodeParent("");
                fsMstSupplier.setSuplCodeSpouse("");
                fsMstSupplier.setSuplNickName("");
                fsMstSupplier.setSuplReligion("");
                fsMstSupplier.setSuplReligion("");
                fsMstSupplier.setSuplSex("");
                fsMstSupplier.setSuplRace("");
                fsMstSupplier.setSuplMaritalSts("");
                fsMstSupplier.setSuplFavoriteColor("");
                fsMstSupplier.setSuplClothesSize("");
                fsMstSupplier.setSuplMobilephone("");
                fsMstSupplier.setSuplMobilephone2("");
                fsMstSupplier.setSuplOtherBusiness1("");
                fsMstSupplier.setSuplOtherBusiness2("");
                fsMstSupplier.setSuplOtherBusiness3("");
                fsMstSupplier.setSuplSpecialInfo("");
                fsMstSupplier.setSuplSegmentDealer("");
                fsMstSupplier.setCoyId("01");
                fsMstSupplier.setVendorId("");
                fsMstSupplier.setHsoSuplId("");
                fsMstSupplier.setSuplJamsostekId("");
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
                fsMstSupplier.setSuplCsFifExist("");
                fsMstSupplier.setSuplTypeOfBuss("");
                fsMstSupplier.setSuplVisi("");
                fsMstSupplier.setSuplMisi("");
                fsMstSupplier.setSuplHrdMgr("");
                fsMstSupplier.setSuplFinMgr("");
                fsMstSupplier.setSuplMktMgr("");
                fsMstSupplier.setSuplCooperation("");
                fsMstSupplier.setSuplMainCompetitor("");
                fsMstSupplier.setSuplValues("");
                fsMstSupplier.setStoreType("");
                fsMstSupplier.setSuplPpn("");
                fsMstSupplier.setActiveMail("");
                if (insertDto.getPersonalIdIndentifikasi() != null){
                    fsMstSupplier.setSuplNik(insertDto.getPersonalIdIndentifikasi());
                } else {
                    fsMstSupplier.setSuplNik(fsMstSupplier.getSuplNik());
                }
                fsMstSupplier.setSuplNikName("");
                fsMstSupplier.setSuplMobilephone3("");
                fsMstSupplier.setSuplFpType("");
                if (insertDto.getSuplPkp() != null){
                    fsMstSupplier.setSuplPkp(insertDto.getSuplPkp());
                } else {
                    fsMstSupplier.setSuplPkp(fsMstSupplier.getSuplPkp());
                }
                fsMstSupplier.setSuplFlagIc("");
                fsMstSupplier.setSuplFlagNpwp("");
                fsMstSupplier.setSuplFlagIc2("");
                fsMstSupplier.setSuplFlagNpwp2("");
                fsMstSupplier.setSuplFlagIc3("");
                fsMstSupplier.setSuplFlagNpwp3("");
                fsMstSupplier.setPcIdReff("");
                if (insertDto.getPcSubType() != null || insertDto.getPcSubType() == ""){
                    fsMstSupplier.setPcSubType(Long.parseLong(insertDto.getPcSubType()));
                }else{
                    fsMstSupplier.setPcSubType(null);
                }
                fsMstSupplier.setSuplNonPph(insertDto.getSuplNonPph());
                if (insertDto.getSuplNonPphStartdate() != null || insertDto.getSuplNonPphStartdate() == ""){
                    fsMstSupplier.setSuplNonPphStartdate(LocalDate.parse(insertDto.getSuplNonPphStartdate(),formatter));
                }else{
                    fsMstSupplier.setSuplNonPphStartdate(null);
                }
                if (insertDto.getSuplNonPphEnddate() != null || insertDto.getSuplNonPphEnddate() == ""){
                    fsMstSupplier.setSuplNonPphEnddate(LocalDate.parse(insertDto.getSuplNonPphEnddate(),formatter));
                }else{
                    fsMstSupplier.setSuplNonPphEnddate(null);
                }
                if (insertDto.getSuplNonPphDocno() != null ){
                    fsMstSupplier.setSuplNonPphDocno(insertDto.getSuplNonPphDocno());
                }else{
                    fsMstSupplier.setSuplNonPphDocno(fsMstSupplier.getSuplNonPphDocno());
                }
                fsMstSupplier.setFasilitasEdis("");
                fsMstSupplier.setTypeAgen("");
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
                fsMstSupplierAcct.setSuplAccountDesc("");
                if (insertDto.getSuplAccStatus() != null){
                    fsMstSupplierAcct.setSuplAccStatus(insertDto.getSuplAccStatus());
                }else{
                    fsMstSupplierAcct.setSuplAccStatus(fsMstSupplierAcct.getSuplAccStatus());
                }
                fsMstSupplierAcct.setSuplAccType("");
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
                fsMstSupplierAcct.setSuplModifiedBy("");
                fsMstSupplierAcct.setSuplModifiedDate(null);
                fsMstSupplierAcct.setSuplApprovedBy("");
                fsMstSupplierAcct.setSuplApprovedDate(null);
                fsMstSupplierAcct.setSuplDefaultBankAcct("");
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
                fsMstSupplierAcct.setLastupdateBy("");
                fsMstSupplierAcct.setLastupdateTimestamp(null);
                fsMstSupplierAcct.setSuplMainBankAcct("");



                if (insertDto.getPersonalId() != null){
                    fsMstSupplierDc.setPersonalId(insertDto.getPersonalId());
                    fsMstSupplierDc.setSuplCode(suplCode);
                } else {
                    fsMstSupplierDc.setPersonalId(fsMstSupplierDc.getPersonalId());
                }
                fsMstSupplierDc.setReference("");
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


                if(insertDto.getPersonalFullName() != null){
                    fsMstPersonalDatum.setPersonalFullName(insertDto.getPersonalFullName());
                }else{
                    fsMstPersonalDatum.setPersonalFullName(fsMstPersonalDatum.getPersonalFullName());
                }
                fsMstPersonalDatum.setPersonalNickName("");
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
                if (insertDto.getPersonalAddr1() != null){
                    fsMstPersonalDatum.setPersonalAddr1(insertDto.getPersonalAddr1());
                }else{
                    fsMstPersonalDatum.setPersonalAddr1(fsMstPersonalDatum.getPersonalAddr1());
                }
                fsMstPersonalDatum.setPersonalAddr2("");
                if (insertDto.getPersonalCity() != null){
                    fsMstPersonalDatum.setPersonalCity(insertDto.getPersonalCity());
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
                fsMstPersonalDatum.setPersonalRace("");
                if (insertDto.getPersonalMaritalSts() != null){
                    fsMstPersonalDatum.setPersonalMaritalSts(insertDto.getPersonalMaritalSts());
                }else{
                    fsMstPersonalDatum.setPersonalMaritalSts(fsMstPersonalDatum.getPersonalMaritalSts());
                }
                fsMstPersonalDatum.setPersonalMaritalDate(null);
                fsMstPersonalDatum.setPersonalNoOfDependent(null);
                fsMstPersonalDatum.setPersonalFavoriteColor("");
                fsMstPersonalDatum.setPersonalClothesSize("");
                fsMstPersonalDatum.setPersonalPhone1("");
                fsMstPersonalDatum.setPersonalPhone2("");
                fsMstPersonalDatum.setPersonalFax("");
                if (insertDto.getPersonalMobilephone() != null){
                    fsMstPersonalDatum.setPersonalMobilephone(insertDto.getPersonalMobilephone());
                }else{
                    fsMstPersonalDatum.setPersonalMobilephone(fsMstPersonalDatum.getPersonalMobilephone());
                }
                fsMstPersonalDatum.setPersonalMobilephone2("");
                if (insertDto.getPersonalEmail() != null){
                    fsMstPersonalDatum.setPersonalEmail(insertDto.getPersonalEmail());
                }else{
                    fsMstPersonalDatum.setPersonalEmail(fsMstPersonalDatum.getPersonalEmail());
                }
                fsMstPersonalDatum.setPersonalOtherBusiness1("");
                fsMstPersonalDatum.setPersonalOtherBusiness2("");
                fsMstPersonalDatum.setPersonalOtherBusiness3("");
                fsMstPersonalDatum.setPersonalSpecialInfo("");
                fsMstPersonalDatum.setPersonalHobbyMembaca("");
                fsMstPersonalDatum.setPersonalHobbyBelanja("");
                fsMstPersonalDatum.setPersonalHobbySeni("");
                fsMstPersonalDatum.setPersonalHobbySeniDesc("");
                fsMstPersonalDatum.setPersonalHobbyMemancing("");
                fsMstPersonalDatum.setPersonalHobbyTraveling("");
                fsMstPersonalDatum.setPersonalHobbyKoleksi("");
                fsMstPersonalDatum.setPersonalHobbyKoleksiDesc("");
                fsMstPersonalDatum.setPersonalHobbyMusik("");
                fsMstPersonalDatum.setPersonalHobbyOlahraga("");
                fsMstPersonalDatum.setPersonalHobbyOlahragaDesc("");
                fsMstPersonalDatum.setPersonalHobbyOtoMtr("");
                fsMstPersonalDatum.setPersonalHobbyOtoMbl("");
                fsMstPersonalDatum.setPersonalHobbyMenyelam("");
                fsMstPersonalDatum.setPersonalHobbyPecintaAlam("");
                fsMstPersonalDatum.setPersonalHobbyPiaraBntg("");
                fsMstPersonalDatum.setPersonalHobbyPiaraBntgDesc("");
                fsMstPersonalDatum.setPersonalHobbyOthers("");
                fsMstPersonalDatum.setPersonalHobbyOthersDesc("");
                fsMstPersonalDatum.setPersonalOtherOwner("");
                fsMstPersonalDatum.setPersonalIdSpouse("");
                fsMstPersonalDatum.setPersonalIdParent("");
                fsMstPersonalDatum.setPersonalSuplFlag("");
                fsMstPersonalDatum.setPersonalCreatedBy("");
                fsMstPersonalDatum.setPersonalCreatedDate(null);
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
                fsMstPersonalDatum.setPersonalIdAddr1("");
                fsMstPersonalDatum.setPersonalIdAddr2("");
                if (insertDto.getLastEducationLvl() != null){
                    fsMstPersonalDatum.setLastEducationLvl(insertDto.getLastEducationLvl());
                }else{
                    fsMstPersonalDatum.setLastEducationLvl(fsMstPersonalDatum.getLastEducationLvl());
                }
                fsMstPersonalDatum.setPersonalIdEmcCall("");
                fsMstPersonalDatum.setPersonalIdCity("");
                fsMstPersonalDatum.setPersonalIdZipcode("");
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
                fsMstPersonalDatum.setPersonalIdEmcAddr2("");
                if (insertDto.getPersonalIdIndentifikasi() != null){
                    fsMstPersonalDatum.setPersonalIdIndentifikasi(insertDto.getPersonalIdIndentifikasi());
                }else{
                    fsMstPersonalDatum.setPersonalIdIndentifikasi(fsMstPersonalDatum.getPersonalIdIndentifikasi());
                }
                if (insertDto.getSuplKecamatan() != null){
                    fsMstPersonalDatum.setPersonalKecamatan(insertDto.getSuplKecamatan());
                }else{
                    fsMstPersonalDatum.setPersonalKecamatan(fsMstPersonalDatum.getPersonalKecamatan());
                }
                if (insertDto.getSuplKelurahan() != null){
                    fsMstPersonalDatum.setPersonalKelurahan(insertDto.getSuplKelurahan());
                }else{
                    fsMstPersonalDatum.setPersonalKelurahan(fsMstPersonalDatum.getPersonalKelurahan());
                }
                fsMstPersonalDatum.setPersonalType("");
                if (insertDto.getPersonalRtRw() != null){
                    fsMstPersonalDatum.setPersonalRtrw(insertDto.getPersonalRtRw());
                }else{
                    fsMstPersonalDatum.setPersonalRtrw(fsMstPersonalDatum.getPersonalRtrw());
                }
                fsMstPersonalDatum.setPersonalStatus("AC");
                fsMstPersonalDatum.setPersonalJoinDate(null);
                fsMstPersonalDatum.setPersonalPosition("");
                fsMstPersonalDatum.setPersonalHubDgnPemilik("");
                fsMstPersonalDatum.setPersonalIdType("");
                fsMstPersonalDatum.setPersonalLamaBekerja(null);
                fsMstPersonalDatum.setPersonalDmsAddr2("");
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
                StatusResponse = HttpStatus.BAD_REQUEST;
            }
        } catch (Exception e){
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            StatusResponse = HttpStatus.BAD_REQUEST;
        }

        return new ResponseEntity(responseObj, StatusResponse);
    }
}
