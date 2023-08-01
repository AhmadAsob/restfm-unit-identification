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
import id.co.astra.fifgroup.project.restfm_unit_identification.services.insertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service("insertServiceImpl")
public class insertServiceImpl implements insertService {

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

    @Transactional
    public ResponseEntity insertService (InsertDto insertDto){
        responseObj responseObj = new responseObj();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


        try {

            FsMstSupplier fsMstSupplier = new FsMstSupplier();
            fsMstSupplier.setId(insertDto.getSuplCode());
            if (fsMstSupplier.getId() == null || fsMstSupplier.getId().equals("")){
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Supplier Code can't null");
                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else if (supplierRepository.existsById(fsMstSupplier.getId())){
                responseObj.setRespHttpCode("400");
                responseObj.setRespHttpMessage("Supplier Code already exist");
                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                StatusResponse = HttpStatus.BAD_REQUEST;
            } else {
                fsMstSupplier.setSuplBranchId(insertDto.getSuplBranchId());
                if (fsMstSupplier.getSuplBranchId() == null || fsMstSupplier.getSuplBranchId().equals("")) {
                    responseObj.setRespHttpCode("400");
                    responseObj.setRespHttpMessage("Supplier Branch ID can't null");
                    remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                    StatusResponse = HttpStatus.BAD_REQUEST;
                } else {
                    fsMstSupplier.setSuplName(insertDto.getSuplName());
                    if (fsMstSupplier.getSuplName() == null || fsMstSupplier.getSuplName().equals("")) {
                        responseObj.setRespHttpCode("400");
                        responseObj.setRespHttpMessage("Supplier Name can't null");
                        remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                        StatusResponse = HttpStatus.BAD_REQUEST;
                    } else {
                        fsMstSupplier.setSuplAddress1(insertDto.getSuplAddress1());
                        if (fsMstSupplier.getSuplAddress1() == null || fsMstSupplier.getSuplAddress1().equals("")) {
                            responseObj.setRespHttpCode("400");
                            responseObj.setRespHttpMessage("Supplier Address 1 can't null");
                            remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                            StatusResponse = HttpStatus.BAD_REQUEST;
                        } else {
                            fsMstSupplier.setSuplAddress2(insertDto.getSuplAddress2());
                            fsMstSupplier.setSuplCity(insertDto.getSuplCity());
                            if (fsMstSupplier.getSuplCity() == null || fsMstSupplier.getSuplCity().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier City can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            if (insertDto.getSuplProvince().length() > 20){
                                fsMstSupplier.setSuplProvince(insertDto.getSuplProvince().substring(0, Math.min(insertDto.getSuplProvince().length(), 20)));
                            }
                            else if (insertDto.getSuplProvince().length() <= 20){
                                fsMstSupplier.setSuplProvince(insertDto.getSuplProvince());
                                }
                            if (fsMstSupplier.getSuplProvince() == null || fsMstSupplier.getSuplProvince().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Province can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplZipcode(insertDto.getSuplZipCode());
                            if (fsMstSupplier.getSuplZipcode() == null || fsMstSupplier.getSuplZipcode().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Zipcode can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplTelp1(insertDto.getSuplTelp1());
                            if (fsMstSupplier.getSuplTelp1() == null || fsMstSupplier.getSuplTelp1().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Telp 1 can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplTelp2("");
                            fsMstSupplier.setSuplFax(insertDto.getSuplFax());
                            fsMstSupplier.setSuplEmail(insertDto.getSuplEmail());
                            if (fsMstSupplier.getSuplEmail() == null || fsMstSupplier.getSuplEmail().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Email can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplPic("");
                            fsMstSupplier.setSuplNpwp(insertDto.getSuplNpwp());
                            if (fsMstSupplier.getSuplNpwp() == null || fsMstSupplier.getSuplNpwp().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier NPWP can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplTglPkp(null);
                            fsMstSupplier.setSuplTaxCode("");
                            fsMstSupplier.setSuplTermPayment(null);
                            fsMstSupplier.setSuplUserApproved("");
                            fsMstSupplier.setSuplDateApproved(null);
                            fsMstSupplier.setSuplStatus(insertDto.getSuplStatus());
                            if (fsMstSupplier.getSuplStatus() == null || fsMstSupplier.getSuplStatus().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Status can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplType(insertDto.getSuplType());
                            if (fsMstSupplier.getSuplType() == null || fsMstSupplier.getSuplType().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Type can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplSubType("8");
                            fsMstSupplier.setSuplCreatedBy(insertDto.getSuplCreatedBy());
                            if (fsMstSupplier.getSuplCreatedBy() == null || fsMstSupplier.getSuplCreatedBy().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Created By can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplCreatedDate(LocalDateTime.parse(insertDto.getSuplCreatedDate(), formatter2));
                            if (fsMstSupplier.getSuplCreatedDate() == null || fsMstSupplier.getSuplCreatedDate().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Created Date can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplModifiedBy("");
                            fsMstSupplier.setSuplGroupId("000");
                            fsMstSupplier.setCreatedBy("");
                            fsMstSupplier.setLastupdateBy("");
                            fsMstSupplier.setSuplOutletType("");
                            fsMstSupplier.setSuplCompType(insertDto.getSuplCompType());
                            fsMstSupplier.setSuplLocation(insertDto.getSuplBranchId());
                            if (fsMstSupplier.getSuplLocation() == null || fsMstSupplier.getSuplLocation().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Branch ID can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplNpwpName(insertDto.getSuplNpwpName());
                            if (fsMstSupplier.getSuplNpwpName() == null || fsMstSupplier.getSuplNpwpName().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier NPWP Name can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplNpwpAddress(insertDto.getSuplNpwpAddress());
                            if (fsMstSupplier.getSuplNpwpAddress() == null || fsMstSupplier.getSuplNpwpAddress().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier NPWP Address can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
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
                            fsMstSupplier.setSuplKecamatan(insertDto.getSuplKecamatan());
                            if (fsMstSupplier.getSuplKecamatan() == null || fsMstSupplier.getSuplKecamatan().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Kecamatan can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplKelurahan(insertDto.getSuplKelurahan());
                            if (fsMstSupplier.getSuplKelurahan() == null || fsMstSupplier.getSuplKelurahan().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Kelurahan can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
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
                            fsMstSupplier.setSuplNik(insertDto.getPersonalIdIndentifikasi());
                            if (fsMstSupplier.getSuplNik() == null || fsMstSupplier.getSuplNik().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier NIK can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplNikName("");
                            fsMstSupplier.setSuplMobilephone3("");
                            fsMstSupplier.setSuplFpType("");
                            fsMstSupplier.setSuplPkp(insertDto.getSuplPkp());
                            fsMstSupplier.setSuplFlagIc("");
                            fsMstSupplier.setSuplFlagNpwp("");
                            fsMstSupplier.setSuplFlagIc2("");
                            fsMstSupplier.setSuplFlagNpwp2("");
                            fsMstSupplier.setSuplFlagIc3("");
                            fsMstSupplier.setSuplFlagNpwp3("");
                            fsMstSupplier.setPcIdReff("");
                            fsMstSupplier.setPcSubType(Long.parseLong(insertDto.getPcSubType()));
                            if (fsMstSupplier.getPcSubType() == null || fsMstSupplier.getPcSubType().equals("")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier PC Sub Type can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplNonPph(insertDto.getSuplNonPph());
                            if (fsMstSupplier.getSuplNonPph().equals("N")){
                                fsMstSupplier.setSuplNonPphStartdate(null);
                                fsMstSupplier.setSuplNonPphEnddate(null);
                                fsMstSupplier.setSuplNonPphDocno("");
                            } else {
                            fsMstSupplier.setSuplNonPphStartdate(LocalDate.parse(insertDto.getSuplNonPphStartdate(), formatter));
                            if (fsMstSupplier.getSuplNonPphStartdate().equals("") && fsMstSupplier.getSuplNonPph().equals("Y")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Non PPH Start Date can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else if (fsMstSupplier.getSuplNonPphStartdate() == null && fsMstSupplier.getSuplNonPph().equals("Y")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Non PPH Start Date can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplNonPphEnddate(LocalDate.parse(insertDto.getSuplNonPphEnddate(), formatter));
                            if (fsMstSupplier.getSuplNonPphEnddate().equals("") && fsMstSupplier.getSuplNonPph().equals("Y")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Non PPH End Date can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else if (fsMstSupplier.getSuplNonPphEnddate() == null && fsMstSupplier.getSuplNonPph().equals("Y")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Non PPH End Date can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else {
                            fsMstSupplier.setSuplNonPphDocno(insertDto.getSuplNonPphDocno());
                            if (fsMstSupplier.getSuplNonPphDocno().equals("") && fsMstSupplier.getSuplNonPph().equals("Y")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Non PPH Doc No can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            } else if (fsMstSupplier.getSuplNonPphDocno() == null && fsMstSupplier.getSuplNonPph().equals("Y")){
                                responseObj.setRespHttpCode("400");
                                responseObj.setRespHttpMessage("Supplier Non PPH Doc No can't null");
                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                StatusResponse = HttpStatus.BAD_REQUEST;
                            }}}}
                                fsMstSupplier.setFasilitasEdis("");
                                fsMstSupplier.setTypeAgen("");
                                fsMstSupplier.setSuplSiup(insertDto.getSuplSiup());
                                if (fsMstSupplier.getSuplSiup().equals("") || fsMstSupplier.getSuplSiup() == null) {
                                    responseObj.setRespHttpCode("400");
                                    responseObj.setRespHttpMessage("Supplier SIUP can't null");
                                    remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                    StatusResponse = HttpStatus.BAD_REQUEST;
                                } else {
                                    fsMstSupplier.setSuplTdp(insertDto.getSuplTdp());
                                    if (fsMstSupplier.getSuplTdp().equals("") || fsMstSupplier.getSuplTdp() == null) {
                                        responseObj.setRespHttpCode("400");
                                        responseObj.setRespHttpMessage("Supplier TDP can't null");
                                        remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                        StatusResponse = HttpStatus.BAD_REQUEST;
                                    } else {
                                        fsMstSupplier.setSuplTdpExpdate(LocalDate.parse(insertDto.getSuplTdpExpdate(), formatter));
                                        if (fsMstSupplier.getSuplTdpExpdate().equals("") || fsMstSupplier.getSuplTdpExpdate() == null) {
                                            responseObj.setRespHttpCode("400");
                                            responseObj.setRespHttpMessage("Supplier TDP Exp Date can't null");
                                            remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER");
                                            StatusResponse = HttpStatus.BAD_REQUEST;
                                        } else {

                                            FsMstSupplierAcctId fsMstSupplierAcctId = new FsMstSupplierAcctId();
                                            fsMstSupplierAcctId.setSuplCode(insertDto.getSuplCode());
                                            fsMstSupplierAcctId.setSuplAccountSeqn(Short.parseShort("1"));

                                            FsMstSupplierAcct fsMstSupplierAcct = new FsMstSupplierAcct();
                                            fsMstSupplierAcct.setId(fsMstSupplierAcctId);
                                            fsMstSupplierAcct.setSuplBankId(insertDto.getSuplBankId());
                                            if (fsMstSupplierAcct.getSuplBankId().equals("") || fsMstSupplierAcct.getSuplBankId() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Supplier Bank ID can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER_ACCT");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstSupplierAcct.setSuplBankName(insertDto.getSuplBankName());
                                            if (fsMstSupplierAcct.getSuplBankName().equals("") || fsMstSupplierAcct.getSuplBankName() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Supplier Bank Name can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER_ACCT");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstSupplierAcct.setSuplAccountNo(insertDto.getSuplAccountNo());
                                            if (fsMstSupplierAcct.getSuplAccountNo().equals("") || fsMstSupplierAcct.getSuplAccountNo() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Supplier Account No can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER_ACCT");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstSupplierAcct.setSuplAccountName(insertDto.getSuplAccountName());
                                                if (fsMstSupplierAcct.getSuplAccountName().equals("") || fsMstSupplierAcct.getSuplAccountName() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Supplier Account Name can't null");
                                                    remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER_ACCT");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstSupplierAcct.setSuplAccountDesc("");
                                            fsMstSupplierAcct.setSuplAccStatus(insertDto.getSuplAccStatus());
                                            if (fsMstSupplierAcct.getSuplAccStatus().equals("") || fsMstSupplierAcct.getSuplAccStatus() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Supplier Account Status can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER_ACCT");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstSupplierAcct.setSuplAccType("");
                                            fsMstSupplierAcct.setSuplAccCurr("IDR");
                                            fsMstSupplierAcct.setSuplCreatedBy(insertDto.getSuplCreatedBy());
                                            if (fsMstSupplierAcct.getSuplCreatedBy().equals("") || fsMstSupplierAcct.getSuplCreatedBy() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Supplier Created By can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER_ACCT");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstSupplierAcct.setSuplCreatedDate(LocalDateTime.parse(insertDto.getSuplCreatedDate(), formatter2));
                                            if (fsMstSupplierAcct.getSuplCreatedDate().equals("") || fsMstSupplierAcct.getSuplCreatedDate() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Supplier Created Date can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER_ACCT");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstSupplierAcct.setSuplModifiedBy("");
                                            fsMstSupplierAcct.setSuplModifiedDate(null);
                                            fsMstSupplierAcct.setSuplApprovedBy("");
                                            fsMstSupplierAcct.setSuplApprovedDate(null);
                                            fsMstSupplierAcct.setSuplDefaultBankAcct("");
                                            fsMstSupplierAcct.setCreatedBy(insertDto.getSuplCreatedBy());
                                            if (fsMstSupplierAcct.getCreatedBy().equals("") || fsMstSupplierAcct.getCreatedBy() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Supplier Created By can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER_ACCT");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstSupplierAcct.setCreatedTimestamp(LocalDateTime.parse(insertDto.getSuplCreatedDate(), formatter2));
                                            if (fsMstSupplierAcct.getCreatedTimestamp().equals("") || fsMstSupplierAcct.getCreatedTimestamp() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Supplier Created Date can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER_ACCT");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstSupplierAcct.setLastupdateBy("");
                                            fsMstSupplierAcct.setLastupdateTimestamp(null);
                                            fsMstSupplierAcct.setSuplMainBankAcct("");



                                            FsMstSupplierDcId fsMstSupplierDcId = new FsMstSupplierDcId();
                                            fsMstSupplierDcId.setSuplCode(insertDto.getSuplCode());
                                            fsMstSupplierDcId.setPersonalId(insertDto.getPersonalId());
                                            if (fsMstSupplierDcId.getSuplCode().equals("") || fsMstSupplierDcId.getSuplCode() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Supplier Code can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER_DC");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {

                                            FsMstSupplierDc fsMstSupplierDc = new FsMstSupplierDc();
                                            fsMstSupplierDc.setPersonalId(fsMstSupplierDcId.getPersonalId());
                                            fsMstSupplierDc.setSuplCode(fsMstSupplierDcId.getSuplCode());
                                            fsMstSupplierDc.setReference("");
                                            fsMstSupplierDc.setCreatedBy(insertDto.getSuplCreatedBy());
                                            if (fsMstSupplierDc.getCreatedBy().equals("") || fsMstSupplierDc.getCreatedBy() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Supplier Created By can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER_DC");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstSupplierDc.setCreatedDate(LocalDate.parse(insertDto.getSuplCreatedDate(), formatter2));
                                            if (fsMstSupplierDc.getCreatedDate().equals("") || fsMstSupplierDc.getCreatedDate() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Supplier Created Date can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_SUPPLIER_DC");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstSupplierDc.setModifiedBy("");
                                            fsMstSupplierDc.setModifiedDate(null);



                                            FsMstPersonalDatum fsMstPersonalDatum = new FsMstPersonalDatum();
                                            fsMstPersonalDatum.setId(insertDto.getPersonalId());
                                            fsMstPersonalDatum.setPersonalFullName(insertDto.getPersonalFullName());
                                            if (fsMstPersonalDatum.getPersonalFullName().equals("") || fsMstPersonalDatum.getPersonalFullName() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Name can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalNickName("");
                                            fsMstPersonalDatum.setPersonalBirtPlace(insertDto.getPersonalBirtPlace());
                                            if (fsMstPersonalDatum.getPersonalBirtPlace().equals("") || fsMstPersonalDatum.getPersonalBirtPlace() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Birth Place can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalBirtDate(LocalDate.parse(insertDto.getPersonalBirtDate(), formatter));
                                            if (fsMstPersonalDatum.getPersonalBirtDate().equals("") || fsMstPersonalDatum.getPersonalBirtDate() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Birth Date can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalAddr1(insertDto.getPersonalIdAddr1());
                                            if (fsMstPersonalDatum.getPersonalAddr1().equals("") || fsMstPersonalDatum.getPersonalAddr1() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Address can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalAddr2("");
                                            fsMstPersonalDatum.setPersonalCity(insertDto.getPersonalIdCity());
                                            if (fsMstPersonalDatum.getPersonalCity().equals("") || fsMstPersonalDatum.getPersonalCity() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal City can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalZipCode(insertDto.getPersonalZipCode());
                                            if (fsMstPersonalDatum.getPersonalZipCode().equals("") || fsMstPersonalDatum.getPersonalZipCode() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Zip Code can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalReligion(insertDto.getPersonalReligion());
                                            if (fsMstPersonalDatum.getPersonalReligion().equals("") || fsMstPersonalDatum.getPersonalReligion() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Religion can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalSex(insertDto.getPersonalSex());
                                            if (fsMstPersonalDatum.getPersonalSex().equals("") || fsMstPersonalDatum.getPersonalSex() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Sex can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalRace("");
                                            fsMstPersonalDatum.setPersonalMaritalSts(insertDto.getPersonalMaritalSts());
                                            if (fsMstPersonalDatum.getPersonalMaritalSts() == "" || fsMstPersonalDatum.getPersonalMaritalSts() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Marital Status can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalMaritalDate(null);
                                            fsMstPersonalDatum.setPersonalNoOfDependent(null);
                                            fsMstPersonalDatum.setPersonalFavoriteColor("");
                                            fsMstPersonalDatum.setPersonalClothesSize("");
                                            fsMstPersonalDatum.setPersonalPhone1("");
                                            fsMstPersonalDatum.setPersonalPhone2("");
                                            fsMstPersonalDatum.setPersonalFax("");
                                            fsMstPersonalDatum.setPersonalMobilephone(insertDto.getPersonalMobilephone());
                                            if (fsMstPersonalDatum.getPersonalMobilephone() == "" || fsMstPersonalDatum.getPersonalMobilephone() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Mobile Phone can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalMobilephone2("");
                                            fsMstPersonalDatum.setPersonalEmail(insertDto.getPersonalEmail());
                                            if (fsMstPersonalDatum.getPersonalEmail() == "" || fsMstPersonalDatum.getPersonalEmail() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Email can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
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
                                            fsMstPersonalDatum.setPersonalModifiedBy(insertDto.getSuplCreatedBy());
                                            if (fsMstPersonalDatum.getPersonalModifiedBy() == "" || fsMstPersonalDatum.getPersonalModifiedBy() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Modified By can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalModifiedDate(LocalDateTime.parse(insertDto.getSuplCreatedDate(), formatter2));
                                            if (fsMstPersonalDatum.getPersonalModifiedDate() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Modified Date can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalIdAddr1("");
                                            fsMstPersonalDatum.setPersonalIdAddr2("");
                                            fsMstPersonalDatum.setLastEducationLvl(insertDto.getLastEducationLvl());
                                            if (fsMstPersonalDatum.getLastEducationLvl() == "" || fsMstPersonalDatum.getLastEducationLvl() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Last Education Level can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalIdEmcCall("");
                                            fsMstPersonalDatum.setPersonalIdCity("");
                                            fsMstPersonalDatum.setPersonalIdZipcode("");
                                            fsMstPersonalDatum.setPersonalIdEmcName(insertDto.getPersonalIdEmcName());
                                            fsMstPersonalDatum.setPersonalIdEmcAddr1(insertDto.getPersonalIdEmcAddr1());
                                            fsMstPersonalDatum.setPersonalIdEmcPhone(insertDto.getPersonalIdEmcPhone());
                                            fsMstPersonalDatum.setPersonalIdEmcAddr2("");
                                            fsMstPersonalDatum.setPersonalIdIndentifikasi(insertDto.getPersonalIdIndentifikasi());
                                            if (fsMstPersonalDatum.getPersonalIdIndentifikasi() == "" || fsMstPersonalDatum.getPersonalIdIndentifikasi() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Id Indentifikasi can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalKecamatan(insertDto.getPersonalIdKecamatan());
                                            if (fsMstPersonalDatum.getPersonalKecamatan() == "" || fsMstPersonalDatum.getPersonalKecamatan() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Kecamatan can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalKelurahan(insertDto.getPersonalIdKelurahan());
                                            if (fsMstPersonalDatum.getPersonalKelurahan() == "" || fsMstPersonalDatum.getPersonalKelurahan() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Kelurahan can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalType("PC");
                                            fsMstPersonalDatum.setPersonalRtrw(insertDto.getPersonalIdRtRw());
                                            if (fsMstPersonalDatum.getPersonalRtrw() == "" || fsMstPersonalDatum.getPersonalRtrw() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal RT/RW can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalStatus("AC");
                                            fsMstPersonalDatum.setPersonalJoinDate(null);
                                            fsMstPersonalDatum.setPersonalPosition("");
                                            fsMstPersonalDatum.setPersonalHubDgnPemilik("");
                                            fsMstPersonalDatum.setPersonalIdType("");
                                            fsMstPersonalDatum.setPersonalLamaBekerja(null);
                                            fsMstPersonalDatum.setPersonalDmsAddr2("");
                                            fsMstPersonalDatum.setPersonalDmsAddr1(insertDto.getPersonalAddr1());
                                            if (fsMstPersonalDatum.getPersonalDmsAddr1() == "" || fsMstPersonalDatum.getPersonalDmsAddr1() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Addr1 can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalDmsRtrw(insertDto.getPersonalRtRw());
                                            if (fsMstPersonalDatum.getPersonalDmsRtrw() == "" || fsMstPersonalDatum.getPersonalDmsRtrw() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal RT/RW can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalDmsKelurahan(insertDto.getPersonalKelurahan());
                                            if (fsMstPersonalDatum.getPersonalDmsKelurahan() == "" || fsMstPersonalDatum.getPersonalDmsKelurahan() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Kelurahan can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalDmsKecamatan(insertDto.getPersonalKecamatan());
                                            if (fsMstPersonalDatum.getPersonalDmsKecamatan() == "" || fsMstPersonalDatum.getPersonalDmsKecamatan() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Kecamatan can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalDmsZipCode(insertDto.getPersonalZipCode());
                                            if (fsMstPersonalDatum.getPersonalDmsZipCode() == "" || fsMstPersonalDatum.getPersonalDmsZipCode() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal ZipCode can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setPersonalDmsCity(insertDto.getPersonalCity());
                                            if (fsMstPersonalDatum.getPersonalDmsCity() == "" || fsMstPersonalDatum.getPersonalDmsCity() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal City can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setSertifikasiDate(LocalDate.parse(insertDto.getPersonalSertProfesiDate(), formatter));
                                                System.out.println("sertifikasiDate : " + insertDto.getPersonalSertProfesiDate());
                                            if (fsMstPersonalDatum.getSertifikasiDate() == null || fsMstPersonalDatum.getSertifikasiDate().equals("")) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Sertifikasi Date can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                            fsMstPersonalDatum.setSertifikasiNo(insertDto.getPersonalSertProfesi());
                                            if (fsMstPersonalDatum.getSertifikasiNo() == "" || fsMstPersonalDatum.getSertifikasiNo() == null) {
                                                responseObj.setRespHttpCode("400");
                                                responseObj.setRespHttpMessage("Personal Sertifikasi No can't null");
                                                remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Can't insert to table FS_MST_PERSONAL_DATA");
                                                StatusResponse = HttpStatus.BAD_REQUEST;
                                            } else {
                                                supplierRepository.save(fsMstSupplier);
                                                dcRepository.save(fsMstSupplierDc);
                                                supplierAcctRepository.save(fsMstSupplierAcct);
                                            datumRepository.save(fsMstPersonalDatum);


                                            responseObj.setRespHttpCode("200");
                                            responseObj.setRespHttpMessage("Succesfully");
                                            StatusResponse = HttpStatus.OK;

                                        }}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}}

        } catch (Exception e) {
            responseObj.setRespHttpCode("400");
            responseObj.setRespHttpMessage(e.getMessage());
            remLogMotifErrGateway.insertLogRemLogMotifErr(insertDto, convertObjectToJson(responseObj, true), "INSERT_PC_REGISTRATION", "Error Insert");
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
    }

}
