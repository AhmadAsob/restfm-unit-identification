package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "FsMstSupplier")
@Table(name = "FS_MST_SUPPLIER", schema = "FIFAPPS")
public class FsMstSupplier {
    private String id;

    private String suplBranchId;

    private String suplName;

    private String suplAddress1;

    private String suplAddress2;

    private String suplCity;

    private String suplProvince;

    private String suplZipcode;

    private String suplTelp1;

    private String suplTelp2;

    private String suplFax;

    private String suplEmail;

    private String suplPic;

    private String suplNpwp;

    private LocalDate suplTglPkp;

    private String suplTaxCode;

    private Short suplTermPayment;

    private String suplUserApproved;

    private LocalDate suplDateApproved;

    private String suplStatus;

    private String suplType;

    private String suplSubType;

    private String suplCreatedBy;

    private LocalDateTime suplCreatedDate;

    private String suplModifiedBy;

    private LocalDate suplModifiedDate;

    private String suplGroupId;

    private String createdBy;

    private LocalDate createdTimestamp;

    private String lastupdateBy;

    private LocalDate lastupdateTimestamp;

    private String suplOutletType;

    private String suplCompType;

    private LocalDate suplEstablished;

    private String suplLocation;

    private String suplNpwpName;

    private String suplNpwpAddress;

    private String suplAuthorize;

    private String suplRegionalId;

    private String suplMaindealerId;

    private String suplCompName;

    private String suplPersonalIdOwner;

    private String suplPersonalIdPic;

    private String suplDecisionMakerDesc;

    private String suplDecisionMakerRelation;

    private String suplDecisionMaker;

    private String suplNpwpOld;

    private String suplNpwpNameOld;

    private String suplNpwpAddressOld;

    private String suplNpwp2;

    private String suplNpwpName2;

    private String suplNpwpAddress2;

    private String suplNpwpOld2;

    private String suplNpwpNameOld2;

    private String suplNpwpAddressOld2;

    private String suplTaxCode2;

    private String suplNpwp3;

    private String suplNpwpName3;

    private String suplNpwpAddress3;

    private String suplNpwpOld3;

    private String suplNpwpNameOld3;

    private String suplNpwpAddressOld3;

    private String suplTaxCode3;

    private String suplNpwpAddress1;

    private String suplCodeParent;

    private String suplCodeSpouse;

    private String suplNickName;

    private String suplBirtPlace;

    private LocalDate suplBirtDate;

    private String suplReligion;

    private String suplSex;

    private String suplRace;

    private String suplMaritalSts;

    private LocalDate suplMaritalDate;

    private Short suplNoOfDependent;

    private String suplFavoriteColor;

    private String suplClothesSize;

    private String suplMobilephone;

    private String suplMobilephone2;

    private String suplOtherBusiness1;

    private String suplOtherBusiness2;

    private String suplOtherBusiness3;

    private String suplSpecialInfo;

    private String suplSegmentDealer;

    private Short processBpkbDays;

    private String coyId;

    private String vendorId;

    private String hsoSuplId;

    private Long quotaCollateral;

    private String suplJamsostekId;

    private Long uppingAmount;

    private String suplKecamatan;

    private String suplKelurahan;

    private Short suplNumOfEmpl;

    private String suplCsFifExist;

    private String suplTypeOfBuss;

    private String suplVisi;

    private String suplMisi;

    private String suplHrdMgr;

    private String suplFinMgr;

    private String suplMktMgr;

    private String suplCooperation;

    private LocalDate suplJoinDate;

    private Float suplMs;

    private Float suplMg;

    private String suplMainCompetitor;

    private Integer suplCashFlow;

    private Integer suplProgramKerjaSama;

    private Integer suplHubBaikDenganFif;

    private String suplValues;

    private Long uppingAmountSyariah;

    private String storeType;

    private String suplPpn;

    private String activeMail;

    private String suplNik;

    private String suplNikName;

    private LocalDate suplNikExpdate;

    private String suplMobilephone3;

    private String suplFpType;

    private String suplPkp;

    private String suplFlagIc;

    private String suplFlagNpwp;

    private String suplFlagIc2;

    private String suplFlagNpwp2;

    private String suplFlagIc3;

    private String suplFlagNpwp3;

    private String pcIdReff;

    private Long pcSubType;

    private String suplNonPph;

    private LocalDate suplNonPphStartdate;

    private LocalDate suplNonPphEnddate;

    private String suplNonPphDocno;

    private String fasilitasEdis;

    private LocalDate activeDateEdis;

    private String typeAgen;

    private Long idSkb;

    private String suplSiup;

    private LocalDate suplSiupExpdate;

    private String suplTdp;

    private LocalDate suplTdpExpdate;

    private Long idStgSuplMotif;

    private LocalDate suplNonPphValiddate;

    private String suplNonPphUmkm;

    private String skbType;

    private Set<FsMstSupplierAcctTemp> fsMstSupplierAcctTemps = new LinkedHashSet<>();

    private Set<FsMstSupplierAcct> fsMstSupplierAccts = new LinkedHashSet<>();

    private Set<MkTrnMouDtl> mkTrnMouDtls = new LinkedHashSet<>();

    private Set<FsMstMou> fsMstMous = new LinkedHashSet<>();

    @Id
    @Column(name = "SUPL_CODE", nullable = false, length = 12)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "SUPL_BRANCH_ID", length = 5)
    public String getSuplBranchId() {
        return suplBranchId;
    }

    public void setSuplBranchId(String suplBranchId) {
        this.suplBranchId = suplBranchId;
    }

    @Column(name = "SUPL_NAME", length = 70)
    public String getSuplName() {
        return suplName;
    }

    public void setSuplName(String suplName) {
        this.suplName = suplName;
    }

    @Column(name = "SUPL_ADDRESS1", length = 120)
    public String getSuplAddress1() {
        return suplAddress1;
    }

    public void setSuplAddress1(String suplAddress1) {
        this.suplAddress1 = suplAddress1;
    }

    @Column(name = "SUPL_ADDRESS2", length = 100)
    public String getSuplAddress2() {
        return suplAddress2;
    }

    public void setSuplAddress2(String suplAddress2) {
        this.suplAddress2 = suplAddress2;
    }

    @Column(name = "SUPL_CITY", length = 100)
    public String getSuplCity() {
        return suplCity;
    }

    public void setSuplCity(String suplCity) {
        this.suplCity = suplCity;
    }

    @Column(name = "SUPL_PROVINCE", length = 20)
    public String getSuplProvince() {
        return suplProvince;
    }

    public void setSuplProvince(String suplProvince) {
        this.suplProvince = suplProvince;
    }

    @Column(name = "SUPL_ZIPCODE", length = 5)
    public String getSuplZipcode() {
        return suplZipcode;
    }

    public void setSuplZipcode(String suplZipcode) {
        this.suplZipcode = suplZipcode;
    }

    @Column(name = "SUPL_TELP1", length = 30)
    public String getSuplTelp1() {
        return suplTelp1;
    }

    public void setSuplTelp1(String suplTelp1) {
        this.suplTelp1 = suplTelp1;
    }

    @Column(name = "SUPL_TELP2", length = 30)
    public String getSuplTelp2() {
        return suplTelp2;
    }

    public void setSuplTelp2(String suplTelp2) {
        this.suplTelp2 = suplTelp2;
    }

    @Column(name = "SUPL_FAX", length = 30)
    public String getSuplFax() {
        return suplFax;
    }

    public void setSuplFax(String suplFax) {
        this.suplFax = suplFax;
    }

    @Column(name = "SUPL_EMAIL", length = 50)
    public String getSuplEmail() {
        return suplEmail;
    }

    public void setSuplEmail(String suplEmail) {
        this.suplEmail = suplEmail;
    }

    @Column(name = "SUPL_PIC", length = 30)
    public String getSuplPic() {
        return suplPic;
    }

    public void setSuplPic(String suplPic) {
        this.suplPic = suplPic;
    }

    @Column(name = "SUPL_NPWP", length = 20)
    public String getSuplNpwp() {
        return suplNpwp;
    }

    public void setSuplNpwp(String suplNpwp) {
        this.suplNpwp = suplNpwp;
    }

    @Column(name = "SUPL_TGL_PKP")
    public LocalDate getSuplTglPkp() {
        return suplTglPkp;
    }

    public void setSuplTglPkp(LocalDate suplTglPkp) {
        this.suplTglPkp = suplTglPkp;
    }

    @Column(name = "SUPL_TAX_CODE", length = 5)
    public String getSuplTaxCode() {
        return suplTaxCode;
    }

    public void setSuplTaxCode(String suplTaxCode) {
        this.suplTaxCode = suplTaxCode;
    }

    @Column(name = "SUPL_TERM_PAYMENT")
    public Short getSuplTermPayment() {
        return suplTermPayment;
    }

    public void setSuplTermPayment(Short suplTermPayment) {
        this.suplTermPayment = suplTermPayment;
    }

    @Column(name = "SUPL_USER_APPROVED", length = 12)
    public String getSuplUserApproved() {
        return suplUserApproved;
    }

    public void setSuplUserApproved(String suplUserApproved) {
        this.suplUserApproved = suplUserApproved;
    }

    @Column(name = "SUPL_DATE_APPROVED")
    public LocalDate getSuplDateApproved() {
        return suplDateApproved;
    }

    public void setSuplDateApproved(LocalDate suplDateApproved) {
        this.suplDateApproved = suplDateApproved;
    }

    @Column(name = "SUPL_STATUS", length = 2)
    public String getSuplStatus() {
        return suplStatus;
    }

    public void setSuplStatus(String suplStatus) {
        this.suplStatus = suplStatus;
    }

    @Column(name = "SUPL_TYPE", length = 1)
    public String getSuplType() {
        return suplType;
    }

    public void setSuplType(String suplType) {
        this.suplType = suplType;
    }

    @Column(name = "SUPL_SUB_TYPE", length = 2)
    public String getSuplSubType() {
        return suplSubType;
    }

    public void setSuplSubType(String suplSubType) {
        this.suplSubType = suplSubType;
    }

    @Column(name = "SUPL_CREATED_BY", length = 12)
    public String getSuplCreatedBy() {
        return suplCreatedBy;
    }

    public void setSuplCreatedBy(String suplCreatedBy) {
        this.suplCreatedBy = suplCreatedBy;
    }

    @Column(name = "SUPL_CREATED_DATE")
    public LocalDateTime getSuplCreatedDate() {
        return suplCreatedDate;
    }

    public void setSuplCreatedDate(LocalDateTime suplCreatedDate) {
        this.suplCreatedDate = suplCreatedDate;
    }

    @Column(name = "SUPL_MODIFIED_BY", length = 12)
    public String getSuplModifiedBy() {
        return suplModifiedBy;
    }

    public void setSuplModifiedBy(String suplModifiedBy) {
        this.suplModifiedBy = suplModifiedBy;
    }

    @Column(name = "SUPL_MODIFIED_DATE")
    public LocalDate getSuplModifiedDate() {
        return suplModifiedDate;
    }

    public void setSuplModifiedDate(LocalDate suplModifiedDate) {
        this.suplModifiedDate = suplModifiedDate;
    }

    @Column(name = "SUPL_GROUP_ID", length = 12)
    public String getSuplGroupId() {
        return suplGroupId;
    }

    public void setSuplGroupId(String suplGroupId) {
        this.suplGroupId = suplGroupId;
    }

    @Column(name = "CREATED_BY", length = 15)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    @Column(name = "CREATED_TIMESTAMP")
    public LocalDate getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(LocalDate createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    @Column(name = "LASTUPDATE_BY", length = 15)
    public String getLastupdateBy() {
        return lastupdateBy;
    }

    public void setLastupdateBy(String lastupdateBy) {
        this.lastupdateBy = lastupdateBy;
    }

    @Column(name = "LASTUPDATE_TIMESTAMP")
    public LocalDate getLastupdateTimestamp() {
        return lastupdateTimestamp;
    }

    public void setLastupdateTimestamp(LocalDate lastupdateTimestamp) {
        this.lastupdateTimestamp = lastupdateTimestamp;
    }

    @Column(name = "SUPL_OUTLET_TYPE", length = 2)
    public String getSuplOutletType() {
        return suplOutletType;
    }

    public void setSuplOutletType(String suplOutletType) {
        this.suplOutletType = suplOutletType;
    }

    @Column(name = "SUPL_COMP_TYPE", length = 5)
    public String getSuplCompType() {
        return suplCompType;
    }

    public void setSuplCompType(String suplCompType) {
        this.suplCompType = suplCompType;
    }

    @Column(name = "SUPL_ESTABLISHED")
    public LocalDate getSuplEstablished() {
        return suplEstablished;
    }

    public void setSuplEstablished(LocalDate suplEstablished) {
        this.suplEstablished = suplEstablished;
    }

    @Column(name = "SUPL_LOCATION", length = 5)
    public String getSuplLocation() {
        return suplLocation;
    }

    public void setSuplLocation(String suplLocation) {
        this.suplLocation = suplLocation;
    }

    @Column(name = "SUPL_NPWP_NAME", length = 60)
    public String getSuplNpwpName() {
        return suplNpwpName;
    }

    public void setSuplNpwpName(String suplNpwpName) {
        this.suplNpwpName = suplNpwpName;
    }

    @Column(name = "SUPL_NPWP_ADDRESS", length = 160)
    public String getSuplNpwpAddress() {
        return suplNpwpAddress;
    }

    public void setSuplNpwpAddress(String suplNpwpAddress) {
        this.suplNpwpAddress = suplNpwpAddress;
    }

    @Column(name = "SUPL_AUTHORIZE", length = 1)
    public String getSuplAuthorize() {
        return suplAuthorize;
    }

    public void setSuplAuthorize(String suplAuthorize) {
        this.suplAuthorize = suplAuthorize;
    }

    @Column(name = "SUPL_REGIONAL_ID", length = 5)
    public String getSuplRegionalId() {
        return suplRegionalId;
    }

    public void setSuplRegionalId(String suplRegionalId) {
        this.suplRegionalId = suplRegionalId;
    }

    @Column(name = "SUPL_MAINDEALER_ID", length = 3)
    public String getSuplMaindealerId() {
        return suplMaindealerId;
    }

    public void setSuplMaindealerId(String suplMaindealerId) {
        this.suplMaindealerId = suplMaindealerId;
    }

    @Column(name = "SUPL_COMP_NAME", length = 30)
    public String getSuplCompName() {
        return suplCompName;
    }

    public void setSuplCompName(String suplCompName) {
        this.suplCompName = suplCompName;
    }

    @Column(name = "SUPL_PERSONAL_ID_OWNER", length = 30)
    public String getSuplPersonalIdOwner() {
        return suplPersonalIdOwner;
    }

    public void setSuplPersonalIdOwner(String suplPersonalIdOwner) {
        this.suplPersonalIdOwner = suplPersonalIdOwner;
    }

    @Column(name = "SUPL_PERSONAL_ID_PIC", length = 30)
    public String getSuplPersonalIdPic() {
        return suplPersonalIdPic;
    }

    public void setSuplPersonalIdPic(String suplPersonalIdPic) {
        this.suplPersonalIdPic = suplPersonalIdPic;
    }

    @Column(name = "SUPL_DECISION_MAKER_DESC", length = 30)
    public String getSuplDecisionMakerDesc() {
        return suplDecisionMakerDesc;
    }

    public void setSuplDecisionMakerDesc(String suplDecisionMakerDesc) {
        this.suplDecisionMakerDesc = suplDecisionMakerDesc;
    }

    @Column(name = "SUPL_DECISION_MAKER_RELATION", length = 30)
    public String getSuplDecisionMakerRelation() {
        return suplDecisionMakerRelation;
    }

    public void setSuplDecisionMakerRelation(String suplDecisionMakerRelation) {
        this.suplDecisionMakerRelation = suplDecisionMakerRelation;
    }

    @Column(name = "SUPL_DECISION_MAKER", length = 5)
    public String getSuplDecisionMaker() {
        return suplDecisionMaker;
    }

    public void setSuplDecisionMaker(String suplDecisionMaker) {
        this.suplDecisionMaker = suplDecisionMaker;
    }

    @Column(name = "SUPL_NPWP_OLD", length = 20)
    public String getSuplNpwpOld() {
        return suplNpwpOld;
    }

    public void setSuplNpwpOld(String suplNpwpOld) {
        this.suplNpwpOld = suplNpwpOld;
    }

    @Column(name = "SUPL_NPWP_NAME_OLD", length = 60)
    public String getSuplNpwpNameOld() {
        return suplNpwpNameOld;
    }

    public void setSuplNpwpNameOld(String suplNpwpNameOld) {
        this.suplNpwpNameOld = suplNpwpNameOld;
    }

    @Column(name = "SUPL_NPWP_ADDRESS_OLD", length = 160)
    public String getSuplNpwpAddressOld() {
        return suplNpwpAddressOld;
    }

    public void setSuplNpwpAddressOld(String suplNpwpAddressOld) {
        this.suplNpwpAddressOld = suplNpwpAddressOld;
    }

    @Column(name = "SUPL_NPWP2", length = 20)
    public String getSuplNpwp2() {
        return suplNpwp2;
    }

    public void setSuplNpwp2(String suplNpwp2) {
        this.suplNpwp2 = suplNpwp2;
    }

    @Column(name = "SUPL_NPWP_NAME2", length = 160)
    public String getSuplNpwpName2() {
        return suplNpwpName2;
    }

    public void setSuplNpwpName2(String suplNpwpName2) {
        this.suplNpwpName2 = suplNpwpName2;
    }

    @Column(name = "SUPL_NPWP_ADDRESS2", length = 160)
    public String getSuplNpwpAddress2() {
        return suplNpwpAddress2;
    }

    public void setSuplNpwpAddress2(String suplNpwpAddress2) {
        this.suplNpwpAddress2 = suplNpwpAddress2;
    }

    @Column(name = "SUPL_NPWP_OLD2", length = 20)
    public String getSuplNpwpOld2() {
        return suplNpwpOld2;
    }

    public void setSuplNpwpOld2(String suplNpwpOld2) {
        this.suplNpwpOld2 = suplNpwpOld2;
    }

    @Column(name = "SUPL_NPWP_NAME_OLD2", length = 160)
    public String getSuplNpwpNameOld2() {
        return suplNpwpNameOld2;
    }

    public void setSuplNpwpNameOld2(String suplNpwpNameOld2) {
        this.suplNpwpNameOld2 = suplNpwpNameOld2;
    }

    @Column(name = "SUPL_NPWP_ADDRESS_OLD2", length = 160)
    public String getSuplNpwpAddressOld2() {
        return suplNpwpAddressOld2;
    }

    public void setSuplNpwpAddressOld2(String suplNpwpAddressOld2) {
        this.suplNpwpAddressOld2 = suplNpwpAddressOld2;
    }

    @Column(name = "SUPL_TAX_CODE2", length = 5)
    public String getSuplTaxCode2() {
        return suplTaxCode2;
    }

    public void setSuplTaxCode2(String suplTaxCode2) {
        this.suplTaxCode2 = suplTaxCode2;
    }

    @Column(name = "SUPL_NPWP3", length = 20)
    public String getSuplNpwp3() {
        return suplNpwp3;
    }

    public void setSuplNpwp3(String suplNpwp3) {
        this.suplNpwp3 = suplNpwp3;
    }

    @Column(name = "SUPL_NPWP_NAME3", length = 160)
    public String getSuplNpwpName3() {
        return suplNpwpName3;
    }

    public void setSuplNpwpName3(String suplNpwpName3) {
        this.suplNpwpName3 = suplNpwpName3;
    }

    @Column(name = "SUPL_NPWP_ADDRESS3", length = 160)
    public String getSuplNpwpAddress3() {
        return suplNpwpAddress3;
    }

    public void setSuplNpwpAddress3(String suplNpwpAddress3) {
        this.suplNpwpAddress3 = suplNpwpAddress3;
    }

    @Column(name = "SUPL_NPWP_OLD3", length = 20)
    public String getSuplNpwpOld3() {
        return suplNpwpOld3;
    }

    public void setSuplNpwpOld3(String suplNpwpOld3) {
        this.suplNpwpOld3 = suplNpwpOld3;
    }

    @Column(name = "SUPL_NPWP_NAME_OLD3", length = 160)
    public String getSuplNpwpNameOld3() {
        return suplNpwpNameOld3;
    }

    public void setSuplNpwpNameOld3(String suplNpwpNameOld3) {
        this.suplNpwpNameOld3 = suplNpwpNameOld3;
    }

    @Column(name = "SUPL_NPWP_ADDRESS_OLD3", length = 160)
    public String getSuplNpwpAddressOld3() {
        return suplNpwpAddressOld3;
    }

    public void setSuplNpwpAddressOld3(String suplNpwpAddressOld3) {
        this.suplNpwpAddressOld3 = suplNpwpAddressOld3;
    }

    @Column(name = "SUPL_TAX_CODE3", length = 5)
    public String getSuplTaxCode3() {
        return suplTaxCode3;
    }

    public void setSuplTaxCode3(String suplTaxCode3) {
        this.suplTaxCode3 = suplTaxCode3;
    }

    @Column(name = "SUPL_NPWP_ADDRESS1", length = 160)
    public String getSuplNpwpAddress1() {
        return suplNpwpAddress1;
    }

    public void setSuplNpwpAddress1(String suplNpwpAddress1) {
        this.suplNpwpAddress1 = suplNpwpAddress1;
    }

    @Column(name = "SUPL_CODE_PARENT", length = 12)
    public String getSuplCodeParent() {
        return suplCodeParent;
    }

    public void setSuplCodeParent(String suplCodeParent) {
        this.suplCodeParent = suplCodeParent;
    }

    @Column(name = "SUPL_CODE_SPOUSE", length = 12)
    public String getSuplCodeSpouse() {
        return suplCodeSpouse;
    }

    public void setSuplCodeSpouse(String suplCodeSpouse) {
        this.suplCodeSpouse = suplCodeSpouse;
    }

    @Column(name = "SUPL_NICK_NAME", length = 60)
    public String getSuplNickName() {
        return suplNickName;
    }

    public void setSuplNickName(String suplNickName) {
        this.suplNickName = suplNickName;
    }

    @Column(name = "SUPL_BIRT_PLACE", length = 30)
    public String getSuplBirtPlace() {
        return suplBirtPlace;
    }

    public void setSuplBirtPlace(String suplBirtPlace) {
        this.suplBirtPlace = suplBirtPlace;
    }

    @Column(name = "SUPL_BIRT_DATE")
    public LocalDate getSuplBirtDate() {
        return suplBirtDate;
    }

    public void setSuplBirtDate(LocalDate suplBirtDate) {
        this.suplBirtDate = suplBirtDate;
    }

    @Column(name = "SUPL_RELIGION", length = 3)
    public String getSuplReligion() {
        return suplReligion;
    }

    public void setSuplReligion(String suplReligion) {
        this.suplReligion = suplReligion;
    }

    @Column(name = "SUPL_SEX", length = 1)
    public String getSuplSex() {
        return suplSex;
    }

    public void setSuplSex(String suplSex) {
        this.suplSex = suplSex;
    }

    @Column(name = "SUPL_RACE", length = 15)
    public String getSuplRace() {
        return suplRace;
    }

    public void setSuplRace(String suplRace) {
        this.suplRace = suplRace;
    }

    @Column(name = "SUPL_MARITAL_STS", length = 1)
    public String getSuplMaritalSts() {
        return suplMaritalSts;
    }

    public void setSuplMaritalSts(String suplMaritalSts) {
        this.suplMaritalSts = suplMaritalSts;
    }

    @Column(name = "SUPL_MARITAL_DATE")
    public LocalDate getSuplMaritalDate() {
        return suplMaritalDate;
    }

    public void setSuplMaritalDate(LocalDate suplMaritalDate) {
        this.suplMaritalDate = suplMaritalDate;
    }

    @Column(name = "SUPL_NO_OF_DEPENDENT")
    public Short getSuplNoOfDependent() {
        return suplNoOfDependent;
    }

    public void setSuplNoOfDependent(Short suplNoOfDependent) {
        this.suplNoOfDependent = suplNoOfDependent;
    }

    @Column(name = "SUPL_FAVORITE_COLOR", length = 2)
    public String getSuplFavoriteColor() {
        return suplFavoriteColor;
    }

    public void setSuplFavoriteColor(String suplFavoriteColor) {
        this.suplFavoriteColor = suplFavoriteColor;
    }

    @Column(name = "SUPL_CLOTHES_SIZE", length = 2)
    public String getSuplClothesSize() {
        return suplClothesSize;
    }

    public void setSuplClothesSize(String suplClothesSize) {
        this.suplClothesSize = suplClothesSize;
    }

    @Column(name = "SUPL_MOBILEPHONE", length = 15)
    public String getSuplMobilephone() {
        return suplMobilephone;
    }

    public void setSuplMobilephone(String suplMobilephone) {
        this.suplMobilephone = suplMobilephone;
    }

    @Column(name = "SUPL_MOBILEPHONE2", length = 15)
    public String getSuplMobilephone2() {
        return suplMobilephone2;
    }

    public void setSuplMobilephone2(String suplMobilephone2) {
        this.suplMobilephone2 = suplMobilephone2;
    }

    @Column(name = "SUPL_OTHER_BUSINESS1", length = 60)
    public String getSuplOtherBusiness1() {
        return suplOtherBusiness1;
    }

    public void setSuplOtherBusiness1(String suplOtherBusiness1) {
        this.suplOtherBusiness1 = suplOtherBusiness1;
    }

    @Column(name = "SUPL_OTHER_BUSINESS2", length = 60)
    public String getSuplOtherBusiness2() {
        return suplOtherBusiness2;
    }

    public void setSuplOtherBusiness2(String suplOtherBusiness2) {
        this.suplOtherBusiness2 = suplOtherBusiness2;
    }

    @Column(name = "SUPL_OTHER_BUSINESS3", length = 60)
    public String getSuplOtherBusiness3() {
        return suplOtherBusiness3;
    }

    public void setSuplOtherBusiness3(String suplOtherBusiness3) {
        this.suplOtherBusiness3 = suplOtherBusiness3;
    }

    @Column(name = "SUPL_SPECIAL_INFO", length = 4000)
    public String getSuplSpecialInfo() {
        return suplSpecialInfo;
    }

    public void setSuplSpecialInfo(String suplSpecialInfo) {
        this.suplSpecialInfo = suplSpecialInfo;
    }

    @Column(name = "SUPL_SEGMENT_DEALER", length = 20)
    public String getSuplSegmentDealer() {
        return suplSegmentDealer;
    }

    public void setSuplSegmentDealer(String suplSegmentDealer) {
        this.suplSegmentDealer = suplSegmentDealer;
    }

    @Column(name = "PROCESS_BPKB_DAYS")
    public Short getProcessBpkbDays() {
        return processBpkbDays;
    }

    public void setProcessBpkbDays(Short processBpkbDays) {
        this.processBpkbDays = processBpkbDays;
    }

    @Column(name = "COY_ID", length = 5)
    public String getCoyId() {
        return coyId;
    }

    public void setCoyId(String coyId) {
        this.coyId = coyId;
    }

    @Column(name = "VENDOR_ID", length = 12)
    public String getVendorId() {
        return vendorId;
    }

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    @Column(name = "HSO_SUPL_ID", length = 6)
    public String getHsoSuplId() {
        return hsoSuplId;
    }

    public void setHsoSuplId(String hsoSuplId) {
        this.hsoSuplId = hsoSuplId;
    }

    @Column(name = "QUOTA_COLLATERAL")
    public Long getQuotaCollateral() {
        return quotaCollateral;
    }

    public void setQuotaCollateral(Long quotaCollateral) {
        this.quotaCollateral = quotaCollateral;
    }

    @Column(name = "SUPL_JAMSOSTEK_ID", length = 50)
    public String getSuplJamsostekId() {
        return suplJamsostekId;
    }

    public void setSuplJamsostekId(String suplJamsostekId) {
        this.suplJamsostekId = suplJamsostekId;
    }

    @Column(name = "UPPING_AMOUNT")
    public Long getUppingAmount() {
        return uppingAmount;
    }

    public void setUppingAmount(Long uppingAmount) {
        this.uppingAmount = uppingAmount;
    }

    @Column(name = "SUPL_KECAMATAN", length = 30)
    public String getSuplKecamatan() {
        return suplKecamatan;
    }

    public void setSuplKecamatan(String suplKecamatan) {
        this.suplKecamatan = suplKecamatan;
    }

    @Column(name = "SUPL_KELURAHAN", length = 30)
    public String getSuplKelurahan() {
        return suplKelurahan;
    }

    public void setSuplKelurahan(String suplKelurahan) {
        this.suplKelurahan = suplKelurahan;
    }

    @Column(name = "SUPL_NUM_OF_EMPL")
    public Short getSuplNumOfEmpl() {
        return suplNumOfEmpl;
    }

    public void setSuplNumOfEmpl(Short suplNumOfEmpl) {
        this.suplNumOfEmpl = suplNumOfEmpl;
    }

    @Column(name = "SUPL_CS_FIF_EXIST", length = 1)
    public String getSuplCsFifExist() {
        return suplCsFifExist;
    }

    public void setSuplCsFifExist(String suplCsFifExist) {
        this.suplCsFifExist = suplCsFifExist;
    }

    @Column(name = "SUPL_TYPE_OF_BUSS", length = 200)
    public String getSuplTypeOfBuss() {
        return suplTypeOfBuss;
    }

    public void setSuplTypeOfBuss(String suplTypeOfBuss) {
        this.suplTypeOfBuss = suplTypeOfBuss;
    }

    @Column(name = "SUPL_VISI", length = 200)
    public String getSuplVisi() {
        return suplVisi;
    }

    public void setSuplVisi(String suplVisi) {
        this.suplVisi = suplVisi;
    }

    @Column(name = "SUPL_MISI", length = 200)
    public String getSuplMisi() {
        return suplMisi;
    }

    public void setSuplMisi(String suplMisi) {
        this.suplMisi = suplMisi;
    }

    @Column(name = "SUPL_HRD_MGR", length = 30)
    public String getSuplHrdMgr() {
        return suplHrdMgr;
    }

    public void setSuplHrdMgr(String suplHrdMgr) {
        this.suplHrdMgr = suplHrdMgr;
    }

    @Column(name = "SUPL_FIN_MGR", length = 30)
    public String getSuplFinMgr() {
        return suplFinMgr;
    }

    public void setSuplFinMgr(String suplFinMgr) {
        this.suplFinMgr = suplFinMgr;
    }

    @Column(name = "SUPL_MKT_MGR", length = 30)
    public String getSuplMktMgr() {
        return suplMktMgr;
    }

    public void setSuplMktMgr(String suplMktMgr) {
        this.suplMktMgr = suplMktMgr;
    }

    @Column(name = "SUPL_COOPERATION", length = 100)
    public String getSuplCooperation() {
        return suplCooperation;
    }

    public void setSuplCooperation(String suplCooperation) {
        this.suplCooperation = suplCooperation;
    }

    @Column(name = "SUPL_JOIN_DATE")
    public LocalDate getSuplJoinDate() {
        return suplJoinDate;
    }

    public void setSuplJoinDate(LocalDate suplJoinDate) {
        this.suplJoinDate = suplJoinDate;
    }

    @Column(name = "SUPL_MS")
    public Float getSuplMs() {
        return suplMs;
    }

    public void setSuplMs(Float suplMs) {
        this.suplMs = suplMs;
    }

    @Column(name = "SUPL_MG")
    public Float getSuplMg() {
        return suplMg;
    }

    public void setSuplMg(Float suplMg) {
        this.suplMg = suplMg;
    }

    @Column(name = "SUPL_MAIN_COMPETITOR", length = 100)
    public String getSuplMainCompetitor() {
        return suplMainCompetitor;
    }

    public void setSuplMainCompetitor(String suplMainCompetitor) {
        this.suplMainCompetitor = suplMainCompetitor;
    }

    @Column(name = "SUPL_CASH_FLOW")
    public Integer getSuplCashFlow() {
        return suplCashFlow;
    }

    public void setSuplCashFlow(Integer suplCashFlow) {
        this.suplCashFlow = suplCashFlow;
    }

    @Column(name = "SUPL_PROGRAM_KERJA_SAMA")
    public Integer getSuplProgramKerjaSama() {
        return suplProgramKerjaSama;
    }

    public void setSuplProgramKerjaSama(Integer suplProgramKerjaSama) {
        this.suplProgramKerjaSama = suplProgramKerjaSama;
    }

    @Column(name = "SUPL_HUB_BAIK_DENGAN_FIF")
    public Integer getSuplHubBaikDenganFif() {
        return suplHubBaikDenganFif;
    }

    public void setSuplHubBaikDenganFif(Integer suplHubBaikDenganFif) {
        this.suplHubBaikDenganFif = suplHubBaikDenganFif;
    }

    @Column(name = "SUPL_VALUES", length = 200)
    public String getSuplValues() {
        return suplValues;
    }

    public void setSuplValues(String suplValues) {
        this.suplValues = suplValues;
    }

    @Column(name = "UPPING_AMOUNT_SYARIAH")
    public Long getUppingAmountSyariah() {
        return uppingAmountSyariah;
    }

    public void setUppingAmountSyariah(Long uppingAmountSyariah) {
        this.uppingAmountSyariah = uppingAmountSyariah;
    }

    @Column(name = "STORE_TYPE", length = 5)
    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    @Column(name = "SUPL_PPN", length = 1)
    public String getSuplPpn() {
        return suplPpn;
    }

    public void setSuplPpn(String suplPpn) {
        this.suplPpn = suplPpn;
    }

    @Column(name = "ACTIVE_MAIL", length = 5)
    public String getActiveMail() {
        return activeMail;
    }

    public void setActiveMail(String activeMail) {
        this.activeMail = activeMail;
    }

    @Column(name = "SUPL_NIK", length = 20)
    public String getSuplNik() {
        return suplNik;
    }

    public void setSuplNik(String suplNik) {
        this.suplNik = suplNik;
    }

    @Column(name = "SUPL_NIK_NAME", length = 50)
    public String getSuplNikName() {
        return suplNikName;
    }

    public void setSuplNikName(String suplNikName) {
        this.suplNikName = suplNikName;
    }

    @Column(name = "SUPL_NIK_EXPDATE")
    public LocalDate getSuplNikExpdate() {
        return suplNikExpdate;
    }

    public void setSuplNikExpdate(LocalDate suplNikExpdate) {
        this.suplNikExpdate = suplNikExpdate;
    }

    @Column(name = "SUPL_MOBILEPHONE3", length = 15)
    public String getSuplMobilephone3() {
        return suplMobilephone3;
    }

    public void setSuplMobilephone3(String suplMobilephone3) {
        this.suplMobilephone3 = suplMobilephone3;
    }

    @Column(name = "SUPL_FP_TYPE", length = 2)
    public String getSuplFpType() {
        return suplFpType;
    }

    public void setSuplFpType(String suplFpType) {
        this.suplFpType = suplFpType;
    }

    @Column(name = "SUPL_PKP", length = 3)
    public String getSuplPkp() {
        return suplPkp;
    }

    public void setSuplPkp(String suplPkp) {
        this.suplPkp = suplPkp;
    }

    @Column(name = "SUPL_FLAG_IC", length = 1)
    public String getSuplFlagIc() {
        return suplFlagIc;
    }

    public void setSuplFlagIc(String suplFlagIc) {
        this.suplFlagIc = suplFlagIc;
    }

    @Column(name = "SUPL_FLAG_NPWP", length = 1)
    public String getSuplFlagNpwp() {
        return suplFlagNpwp;
    }

    public void setSuplFlagNpwp(String suplFlagNpwp) {
        this.suplFlagNpwp = suplFlagNpwp;
    }

    @Column(name = "SUPL_FLAG_IC2", length = 1)
    public String getSuplFlagIc2() {
        return suplFlagIc2;
    }

    public void setSuplFlagIc2(String suplFlagIc2) {
        this.suplFlagIc2 = suplFlagIc2;
    }

    @Column(name = "SUPL_FLAG_NPWP2", length = 1)
    public String getSuplFlagNpwp2() {
        return suplFlagNpwp2;
    }

    public void setSuplFlagNpwp2(String suplFlagNpwp2) {
        this.suplFlagNpwp2 = suplFlagNpwp2;
    }

    @Column(name = "SUPL_FLAG_IC3", length = 1)
    public String getSuplFlagIc3() {
        return suplFlagIc3;
    }

    public void setSuplFlagIc3(String suplFlagIc3) {
        this.suplFlagIc3 = suplFlagIc3;
    }

    @Column(name = "SUPL_FLAG_NPWP3", length = 1)
    public String getSuplFlagNpwp3() {
        return suplFlagNpwp3;
    }

    public void setSuplFlagNpwp3(String suplFlagNpwp3) {
        this.suplFlagNpwp3 = suplFlagNpwp3;
    }

    @Column(name = "PC_ID_REFF", length = 12)
    public String getPcIdReff() {
        return pcIdReff;
    }

    public void setPcIdReff(String pcIdReff) {
        this.pcIdReff = pcIdReff;
    }

    @Column(name = "PC_SUB_TYPE")
    public Long getPcSubType() {
        return pcSubType;
    }

    public void setPcSubType(Long pcSubType) {
        this.pcSubType = pcSubType;
    }

    @Column(name = "SUPL_NON_PPH", length = 1)
    public String getSuplNonPph() {
        return suplNonPph;
    }

    public void setSuplNonPph(String suplNonPph) {
        this.suplNonPph = suplNonPph;
    }

    @Column(name = "SUPL_NON_PPH_STARTDATE")
    public LocalDate getSuplNonPphStartdate() {
        return suplNonPphStartdate;
    }

    public void setSuplNonPphStartdate(LocalDate suplNonPphStartdate) {
        this.suplNonPphStartdate = suplNonPphStartdate;
    }

    @Column(name = "SUPL_NON_PPH_ENDDATE")
    public LocalDate getSuplNonPphEnddate() {
        return suplNonPphEnddate;
    }

    public void setSuplNonPphEnddate(LocalDate suplNonPphEnddate) {
        this.suplNonPphEnddate = suplNonPphEnddate;
    }

    @Column(name = "SUPL_NON_PPH_DOCNO", length = 100)
    public String getSuplNonPphDocno() {
        return suplNonPphDocno;
    }

    public void setSuplNonPphDocno(String suplNonPphDocno) {
        this.suplNonPphDocno = suplNonPphDocno;
    }

    @Column(name = "FASILITAS_EDIS", length = 1)
    public String getFasilitasEdis() {
        return fasilitasEdis;
    }

    public void setFasilitasEdis(String fasilitasEdis) {
        this.fasilitasEdis = fasilitasEdis;
    }

    @Column(name = "ACTIVE_DATE_EDIS")
    public LocalDate getActiveDateEdis() {
        return activeDateEdis;
    }

    public void setActiveDateEdis(LocalDate activeDateEdis) {
        this.activeDateEdis = activeDateEdis;
    }

    @Column(name = "TYPE_AGEN", length = 5)
    public String getTypeAgen() {
        return typeAgen;
    }

    public void setTypeAgen(String typeAgen) {
        this.typeAgen = typeAgen;
    }

    @Column(name = "ID_SKB")
    public Long getIdSkb() {
        return idSkb;
    }

    public void setIdSkb(Long idSkb) {
        this.idSkb = idSkb;
    }

    @Column(name = "SUPL_SIUP", length = 50)
    public String getSuplSiup() {
        return suplSiup;
    }

    public void setSuplSiup(String suplSiup) {
        this.suplSiup = suplSiup;
    }

    @Column(name = "SUPL_SIUP_EXPDATE")
    public LocalDate getSuplSiupExpdate() {
        return suplSiupExpdate;
    }

    public void setSuplSiupExpdate(LocalDate suplSiupExpdate) {
        this.suplSiupExpdate = suplSiupExpdate;
    }

    @Column(name = "SUPL_TDP", length = 50)
    public String getSuplTdp() {
        return suplTdp;
    }

    public void setSuplTdp(String suplTdp) {
        this.suplTdp = suplTdp;
    }

    @Column(name = "SUPL_TDP_EXPDATE")
    public LocalDate getSuplTdpExpdate() {
        return suplTdpExpdate;
    }

    public void setSuplTdpExpdate(LocalDate suplTdpExpdate) {
        this.suplTdpExpdate = suplTdpExpdate;
    }

    @Column(name = "ID_STG_SUPL_MOTIF")
    public Long getIdStgSuplMotif() {
        return idStgSuplMotif;
    }

    public void setIdStgSuplMotif(Long idStgSuplMotif) {
        this.idStgSuplMotif = idStgSuplMotif;
    }

    @Column(name = "SUPL_NON_PPH_VALIDDATE")
    public LocalDate getSuplNonPphValiddate() {
        return suplNonPphValiddate;
    }

    public void setSuplNonPphValiddate(LocalDate suplNonPphValiddate) {
        this.suplNonPphValiddate = suplNonPphValiddate;
    }

    @Column(name = "SUPL_NON_PPH_UMKM", length = 1)
    public String getSuplNonPphUmkm() {
        return suplNonPphUmkm;
    }

    public void setSuplNonPphUmkm(String suplNonPphUmkm) {
        this.suplNonPphUmkm = suplNonPphUmkm;
    }

    @Column(name = "SKB_TYPE", length = 1)
    public String getSkbType() {
        return skbType;
    }

    public void setSkbType(String skbType) {
        this.skbType = skbType;
    }

    @OneToMany(mappedBy = "suplCode")
    public Set<FsMstSupplierAcctTemp> getFsMstSupplierAcctTemps() {
        return fsMstSupplierAcctTemps;
    }

    public void setFsMstSupplierAcctTemps(Set<FsMstSupplierAcctTemp> fsMstSupplierAcctTemps) {
        this.fsMstSupplierAcctTemps = fsMstSupplierAcctTemps;
    }

//    @OneToMany(mappedBy = "suplCode")
//    public Set<FsMstSupplierAcct> getFsMstSupplierAccts() {
//        return fsMstSupplierAccts;
//    }
//
//    public void setFsMstSupplierAccts(Set<FsMstSupplierAcct> fsMstSupplierAccts) {
//        this.fsMstSupplierAccts = fsMstSupplierAccts;
//    }

    @OneToMany(mappedBy = "suplCode")
    public Set<MkTrnMouDtl> getMkTrnMouDtls() {
        return mkTrnMouDtls;
    }

    public void setMkTrnMouDtls(Set<MkTrnMouDtl> mkTrnMouDtls) {
        this.mkTrnMouDtls = mkTrnMouDtls;
    }

    @OneToMany(mappedBy = "suplCode")
    public Set<FsMstMou> getFsMstMous() {
        return fsMstMous;
    }

    public void setFsMstMous(Set<FsMstMou> fsMstMous) {
        this.fsMstMous = fsMstMous;
    }

}