package id.co.astra.fifgroup.project.restfm_unit_identification.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "FsMstPersonalDatum")
@Table(name = "FS_MST_PERSONAL_DATA", schema = "FIFAPPS")
public class FsMstPersonalDatum {
    private String id;

    private String personalFullName;

    private String personalNickName;

    private String personalBirtPlace;

    private LocalDate personalBirtDate;

    private String personalAddr1;

    private String personalAddr2;

    private String personalCity;

    private String personalZipCode;

    private String personalReligion;

    private String personalSex;

    private String personalRace;

    private String personalMaritalSts;

    private LocalDate personalMaritalDate;

    private Short personalNoOfDependent;

    private String personalFavoriteColor;

    private String personalClothesSize;

    private String personalPhone1;

    private String personalPhone2;

    private String personalFax;

    private String personalMobilephone;

    private String personalMobilephone2;

    private String personalEmail;

    private String personalOtherBusiness1;

    private String personalOtherBusiness2;

    private String personalOtherBusiness3;

    private String personalSpecialInfo;

    private String personalHobbyMembaca;

    private String personalHobbyBelanja;

    private String personalHobbySeni;

    private String personalHobbySeniDesc;

    private String personalHobbyMemancing;

    private String personalHobbyTraveling;

    private String personalHobbyKoleksi;

    private String personalHobbyKoleksiDesc;

    private String personalHobbyMusik;

    private String personalHobbyOlahraga;

    private String personalHobbyOlahragaDesc;

    private String personalHobbyOtoMtr;

    private String personalHobbyOtoMbl;

    private String personalHobbyMenyelam;

    private String personalHobbyPecintaAlam;

    private String personalHobbyPiaraBntg;

    private String personalHobbyPiaraBntgDesc;

    private String personalHobbyOthers;

    private String personalHobbyOthersDesc;

    private String personalOtherOwner;

    private String personalIdSpouse;

    private String personalIdParent;

    private String personalSuplFlag;

    private String personalCreatedBy;

    private LocalDate personalCreatedDate;

    private String personalModifiedBy;

    private LocalDateTime personalModifiedDate;

    private String personalIdAddr1;

    private String personalIdAddr2;

    private String lastEducationLvl;

    private String personalIdEmcCall;

    private String personalIdCity;

    private String personalIdZipcode;

    private String personalIdEmcName;

    private String personalIdEmcAddr1;

    private String personalIdEmcPhone;

    private String personalIdEmcAddr2;

    private String personalIdIndentifikasi;

    private String personalKecamatan;

    private String personalKelurahan;

    private String personalType;

    private String personalRtrw;

    private String personalStatus;

    private LocalDate personalJoinDate;

    private String personalPosition;

    private String personalHubDgnPemilik;

    private String personalIdType;

    private Short personalLamaBekerja;

    private String personalDmsAddr2;

    private String personalDmsAddr1;

    private String personalDmsRtrw;

    private String personalDmsKelurahan;

    private String personalDmsKecamatan;

    private String personalDmsZipCode;

    private String personalDmsCity;

    private String sertifikasiNo;

    private LocalDate sertifikasiDate;

    @Id
    @Column(name = "PERSONAL_ID", nullable = false, length = 30)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "PERSONAL_FULL_NAME", length = 60)
    public String getPersonalFullName() {
        return personalFullName;
    }

    public void setPersonalFullName(String personalFullName) {
        this.personalFullName = personalFullName;
    }

    @Column(name = "PERSONAL_NICK_NAME", length = 60)
    public String getPersonalNickName() {
        return personalNickName;
    }

    public void setPersonalNickName(String personalNickName) {
        this.personalNickName = personalNickName;
    }

    @Column(name = "PERSONAL_BIRT_PLACE", length = 30)
    public String getPersonalBirtPlace() {
        return personalBirtPlace;
    }

    public void setPersonalBirtPlace(String personalBirtPlace) {
        this.personalBirtPlace = personalBirtPlace;
    }

    @Column(name = "PERSONAL_BIRT_DATE")
    public LocalDate getPersonalBirtDate() {
        return personalBirtDate;
    }

    public void setPersonalBirtDate(LocalDate personalBirtDate) {
        this.personalBirtDate = personalBirtDate;
    }

    @Column(name = "PERSONAL_ADDR1", length = 60)
    public String getPersonalAddr1() {
        return personalAddr1;
    }

    public void setPersonalAddr1(String personalAddr1) {
        this.personalAddr1 = personalAddr1;
    }

    @Column(name = "PERSONAL_ADDR2", length = 60)
    public String getPersonalAddr2() {
        return personalAddr2;
    }

    public void setPersonalAddr2(String personalAddr2) {
        this.personalAddr2 = personalAddr2;
    }

    @Column(name = "PERSONAL_CITY", length = 30)
    public String getPersonalCity() {
        return personalCity;
    }

    public void setPersonalCity(String personalCity) {
        this.personalCity = personalCity;
    }

    @Column(name = "PERSONAL_ZIP_CODE", length = 5)
    public String getPersonalZipCode() {
        return personalZipCode;
    }

    public void setPersonalZipCode(String personalZipCode) {
        this.personalZipCode = personalZipCode;
    }

    @Column(name = "PERSONAL_RELIGION", length = 3)
    public String getPersonalReligion() {
        return personalReligion;
    }

    public void setPersonalReligion(String personalReligion) {
        this.personalReligion = personalReligion;
    }

    @Column(name = "PERSONAL_SEX", length = 1)
    public String getPersonalSex() {
        return personalSex;
    }

    public void setPersonalSex(String personalSex) {
        this.personalSex = personalSex;
    }

    @Column(name = "PERSONAL_RACE", length = 15)
    public String getPersonalRace() {
        return personalRace;
    }

    public void setPersonalRace(String personalRace) {
        this.personalRace = personalRace;
    }

    @Column(name = "PERSONAL_MARITAL_STS", length = 1)
    public String getPersonalMaritalSts() {
        return personalMaritalSts;
    }

    public void setPersonalMaritalSts(String personalMaritalSts) {
        this.personalMaritalSts = personalMaritalSts;
    }

    @Column(name = "PERSONAL_MARITAL_DATE")
    public LocalDate getPersonalMaritalDate() {
        return personalMaritalDate;
    }

    public void setPersonalMaritalDate(LocalDate personalMaritalDate) {
        this.personalMaritalDate = personalMaritalDate;
    }

    @Column(name = "PERSONAL_NO_OF_DEPENDENT")
    public Short getPersonalNoOfDependent() {
        return personalNoOfDependent;
    }

    public void setPersonalNoOfDependent(Short personalNoOfDependent) {
        this.personalNoOfDependent = personalNoOfDependent;
    }

    @Column(name = "PERSONAL_FAVORITE_COLOR", length = 2)
    public String getPersonalFavoriteColor() {
        return personalFavoriteColor;
    }

    public void setPersonalFavoriteColor(String personalFavoriteColor) {
        this.personalFavoriteColor = personalFavoriteColor;
    }

    @Column(name = "PERSONAL_CLOTHES_SIZE", length = 2)
    public String getPersonalClothesSize() {
        return personalClothesSize;
    }

    public void setPersonalClothesSize(String personalClothesSize) {
        this.personalClothesSize = personalClothesSize;
    }

    @Column(name = "PERSONAL_PHONE1", length = 15)
    public String getPersonalPhone1() {
        return personalPhone1;
    }

    public void setPersonalPhone1(String personalPhone1) {
        this.personalPhone1 = personalPhone1;
    }

    @Column(name = "PERSONAL_PHONE2", length = 15)
    public String getPersonalPhone2() {
        return personalPhone2;
    }

    public void setPersonalPhone2(String personalPhone2) {
        this.personalPhone2 = personalPhone2;
    }

    @Column(name = "PERSONAL_FAX", length = 15)
    public String getPersonalFax() {
        return personalFax;
    }

    public void setPersonalFax(String personalFax) {
        this.personalFax = personalFax;
    }

    @Column(name = "PERSONAL_MOBILEPHONE", length = 15)
    public String getPersonalMobilephone() {
        return personalMobilephone;
    }

    public void setPersonalMobilephone(String personalMobilephone) {
        this.personalMobilephone = personalMobilephone;
    }

    @Column(name = "PERSONAL_MOBILEPHONE2", length = 15)
    public String getPersonalMobilephone2() {
        return personalMobilephone2;
    }

    public void setPersonalMobilephone2(String personalMobilephone2) {
        this.personalMobilephone2 = personalMobilephone2;
    }

    @Column(name = "PERSONAL_EMAIL", length = 60)
    public String getPersonalEmail() {
        return personalEmail;
    }

    public void setPersonalEmail(String personalEmail) {
        this.personalEmail = personalEmail;
    }

    @Column(name = "PERSONAL_OTHER_BUSINESS1", length = 60)
    public String getPersonalOtherBusiness1() {
        return personalOtherBusiness1;
    }

    public void setPersonalOtherBusiness1(String personalOtherBusiness1) {
        this.personalOtherBusiness1 = personalOtherBusiness1;
    }

    @Column(name = "PERSONAL_OTHER_BUSINESS2", length = 60)
    public String getPersonalOtherBusiness2() {
        return personalOtherBusiness2;
    }

    public void setPersonalOtherBusiness2(String personalOtherBusiness2) {
        this.personalOtherBusiness2 = personalOtherBusiness2;
    }

    @Column(name = "PERSONAL_OTHER_BUSINESS3", length = 60)
    public String getPersonalOtherBusiness3() {
        return personalOtherBusiness3;
    }

    public void setPersonalOtherBusiness3(String personalOtherBusiness3) {
        this.personalOtherBusiness3 = personalOtherBusiness3;
    }

    @Column(name = "PERSONAL_SPECIAL_INFO", length = 4000)
    public String getPersonalSpecialInfo() {
        return personalSpecialInfo;
    }

    public void setPersonalSpecialInfo(String personalSpecialInfo) {
        this.personalSpecialInfo = personalSpecialInfo;
    }

    @Column(name = "PERSONAL_HOBBY_MEMBACA", length = 1)
    public String getPersonalHobbyMembaca() {
        return personalHobbyMembaca;
    }

    public void setPersonalHobbyMembaca(String personalHobbyMembaca) {
        this.personalHobbyMembaca = personalHobbyMembaca;
    }

    @Column(name = "PERSONAL_HOBBY_BELANJA", length = 1)
    public String getPersonalHobbyBelanja() {
        return personalHobbyBelanja;
    }

    public void setPersonalHobbyBelanja(String personalHobbyBelanja) {
        this.personalHobbyBelanja = personalHobbyBelanja;
    }

    @Column(name = "PERSONAL_HOBBY_SENI", length = 1)
    public String getPersonalHobbySeni() {
        return personalHobbySeni;
    }

    public void setPersonalHobbySeni(String personalHobbySeni) {
        this.personalHobbySeni = personalHobbySeni;
    }

    @Column(name = "PERSONAL_HOBBY_SENI_DESC", length = 30)
    public String getPersonalHobbySeniDesc() {
        return personalHobbySeniDesc;
    }

    public void setPersonalHobbySeniDesc(String personalHobbySeniDesc) {
        this.personalHobbySeniDesc = personalHobbySeniDesc;
    }

    @Column(name = "PERSONAL_HOBBY_MEMANCING", length = 1)
    public String getPersonalHobbyMemancing() {
        return personalHobbyMemancing;
    }

    public void setPersonalHobbyMemancing(String personalHobbyMemancing) {
        this.personalHobbyMemancing = personalHobbyMemancing;
    }

    @Column(name = "PERSONAL_HOBBY_TRAVELING", length = 1)
    public String getPersonalHobbyTraveling() {
        return personalHobbyTraveling;
    }

    public void setPersonalHobbyTraveling(String personalHobbyTraveling) {
        this.personalHobbyTraveling = personalHobbyTraveling;
    }

    @Column(name = "PERSONAL_HOBBY_KOLEKSI", length = 1)
    public String getPersonalHobbyKoleksi() {
        return personalHobbyKoleksi;
    }

    public void setPersonalHobbyKoleksi(String personalHobbyKoleksi) {
        this.personalHobbyKoleksi = personalHobbyKoleksi;
    }

    @Column(name = "PERSONAL_HOBBY_KOLEKSI_DESC", length = 30)
    public String getPersonalHobbyKoleksiDesc() {
        return personalHobbyKoleksiDesc;
    }

    public void setPersonalHobbyKoleksiDesc(String personalHobbyKoleksiDesc) {
        this.personalHobbyKoleksiDesc = personalHobbyKoleksiDesc;
    }

    @Column(name = "PERSONAL_HOBBY_MUSIK", length = 1)
    public String getPersonalHobbyMusik() {
        return personalHobbyMusik;
    }

    public void setPersonalHobbyMusik(String personalHobbyMusik) {
        this.personalHobbyMusik = personalHobbyMusik;
    }

    @Column(name = "PERSONAL_HOBBY_OLAHRAGA", length = 1)
    public String getPersonalHobbyOlahraga() {
        return personalHobbyOlahraga;
    }

    public void setPersonalHobbyOlahraga(String personalHobbyOlahraga) {
        this.personalHobbyOlahraga = personalHobbyOlahraga;
    }

    @Column(name = "PERSONAL_HOBBY_OLAHRAGA_DESC", length = 30)
    public String getPersonalHobbyOlahragaDesc() {
        return personalHobbyOlahragaDesc;
    }

    public void setPersonalHobbyOlahragaDesc(String personalHobbyOlahragaDesc) {
        this.personalHobbyOlahragaDesc = personalHobbyOlahragaDesc;
    }

    @Column(name = "PERSONAL_HOBBY_OTO_MTR", length = 1)
    public String getPersonalHobbyOtoMtr() {
        return personalHobbyOtoMtr;
    }

    public void setPersonalHobbyOtoMtr(String personalHobbyOtoMtr) {
        this.personalHobbyOtoMtr = personalHobbyOtoMtr;
    }

    @Column(name = "PERSONAL_HOBBY_OTO_MBL", length = 1)
    public String getPersonalHobbyOtoMbl() {
        return personalHobbyOtoMbl;
    }

    public void setPersonalHobbyOtoMbl(String personalHobbyOtoMbl) {
        this.personalHobbyOtoMbl = personalHobbyOtoMbl;
    }

    @Column(name = "PERSONAL_HOBBY_MENYELAM", length = 1)
    public String getPersonalHobbyMenyelam() {
        return personalHobbyMenyelam;
    }

    public void setPersonalHobbyMenyelam(String personalHobbyMenyelam) {
        this.personalHobbyMenyelam = personalHobbyMenyelam;
    }

    @Column(name = "PERSONAL_HOBBY_PECINTA_ALAM", length = 1)
    public String getPersonalHobbyPecintaAlam() {
        return personalHobbyPecintaAlam;
    }

    public void setPersonalHobbyPecintaAlam(String personalHobbyPecintaAlam) {
        this.personalHobbyPecintaAlam = personalHobbyPecintaAlam;
    }

    @Column(name = "PERSONAL_HOBBY_PIARA_BNTG", length = 1)
    public String getPersonalHobbyPiaraBntg() {
        return personalHobbyPiaraBntg;
    }

    public void setPersonalHobbyPiaraBntg(String personalHobbyPiaraBntg) {
        this.personalHobbyPiaraBntg = personalHobbyPiaraBntg;
    }

    @Column(name = "PERSONAL_HOBBY_PIARA_BNTG_DESC", length = 30)
    public String getPersonalHobbyPiaraBntgDesc() {
        return personalHobbyPiaraBntgDesc;
    }

    public void setPersonalHobbyPiaraBntgDesc(String personalHobbyPiaraBntgDesc) {
        this.personalHobbyPiaraBntgDesc = personalHobbyPiaraBntgDesc;
    }

    @Column(name = "PERSONAL_HOBBY_OTHERS", length = 3)
    public String getPersonalHobbyOthers() {
        return personalHobbyOthers;
    }

    public void setPersonalHobbyOthers(String personalHobbyOthers) {
        this.personalHobbyOthers = personalHobbyOthers;
    }

    @Column(name = "PERSONAL_HOBBY_OTHERS_DESC", length = 30)
    public String getPersonalHobbyOthersDesc() {
        return personalHobbyOthersDesc;
    }

    public void setPersonalHobbyOthersDesc(String personalHobbyOthersDesc) {
        this.personalHobbyOthersDesc = personalHobbyOthersDesc;
    }

    @Column(name = "PERSONAL_OTHER_OWNER", length = 100)
    public String getPersonalOtherOwner() {
        return personalOtherOwner;
    }

    public void setPersonalOtherOwner(String personalOtherOwner) {
        this.personalOtherOwner = personalOtherOwner;
    }

    @Column(name = "PERSONAL_ID_SPOUSE", length = 20)
    public String getPersonalIdSpouse() {
        return personalIdSpouse;
    }

    public void setPersonalIdSpouse(String personalIdSpouse) {
        this.personalIdSpouse = personalIdSpouse;
    }

    @Column(name = "PERSONAL_ID_PARENT", length = 20)
    public String getPersonalIdParent() {
        return personalIdParent;
    }

    public void setPersonalIdParent(String personalIdParent) {
        this.personalIdParent = personalIdParent;
    }

    @Column(name = "PERSONAL_SUPL_FLAG", length = 1)
    public String getPersonalSuplFlag() {
        return personalSuplFlag;
    }

    public void setPersonalSuplFlag(String personalSuplFlag) {
        this.personalSuplFlag = personalSuplFlag;
    }

    @Column(name = "PERSONAL_CREATED_BY", length = 15)
    public String getPersonalCreatedBy() {
        return personalCreatedBy;
    }

    public void setPersonalCreatedBy(String personalCreatedBy) {
        this.personalCreatedBy = personalCreatedBy;
    }

    @Column(name = "PERSONAL_CREATED_DATE")
    public LocalDate getPersonalCreatedDate() {
        return personalCreatedDate;
    }

    public void setPersonalCreatedDate(LocalDate personalCreatedDate) {
        this.personalCreatedDate = personalCreatedDate;
    }

    @Column(name = "PERSONAL_MODIFIED_BY", length = 15)
    public String getPersonalModifiedBy() {
        return personalModifiedBy;
    }

    public void setPersonalModifiedBy(String personalModifiedBy) {
        this.personalModifiedBy = personalModifiedBy;
    }

    @Column(name = "PERSONAL_MODIFIED_DATE")
    public LocalDateTime getPersonalModifiedDate() {
        return personalModifiedDate;
    }

    public void setPersonalModifiedDate(LocalDateTime personalModifiedDate) {
        this.personalModifiedDate = personalModifiedDate;
    }

    @Column(name = "PERSONAL_ID_ADDR1", length = 60)
    public String getPersonalIdAddr1() {
        return personalIdAddr1;
    }

    public void setPersonalIdAddr1(String personalIdAddr1) {
        this.personalIdAddr1 = personalIdAddr1;
    }

    @Column(name = "PERSONAL_ID_ADDR2", length = 60)
    public String getPersonalIdAddr2() {
        return personalIdAddr2;
    }

    public void setPersonalIdAddr2(String personalIdAddr2) {
        this.personalIdAddr2 = personalIdAddr2;
    }

    @Column(name = "LAST_EDUCATION_LVL", length = 3)
    public String getLastEducationLvl() {
        return lastEducationLvl;
    }

    public void setLastEducationLvl(String lastEducationLvl) {
        this.lastEducationLvl = lastEducationLvl;
    }

    @Column(name = "PERSONAL_ID_EMC_CALL", length = 20)
    public String getPersonalIdEmcCall() {
        return personalIdEmcCall;
    }

    public void setPersonalIdEmcCall(String personalIdEmcCall) {
        this.personalIdEmcCall = personalIdEmcCall;
    }

    @Column(name = "PERSONAL_ID_CITY", length = 30)
    public String getPersonalIdCity() {
        return personalIdCity;
    }

    public void setPersonalIdCity(String personalIdCity) {
        this.personalIdCity = personalIdCity;
    }

    @Column(name = "PERSONAL_ID_ZIPCODE", length = 5)
    public String getPersonalIdZipcode() {
        return personalIdZipcode;
    }

    public void setPersonalIdZipcode(String personalIdZipcode) {
        this.personalIdZipcode = personalIdZipcode;
    }

    @Column(name = "PERSONAL_ID_EMC_NAME", length = 30)
    public String getPersonalIdEmcName() {
        return personalIdEmcName;
    }

    public void setPersonalIdEmcName(String personalIdEmcName) {
        this.personalIdEmcName = personalIdEmcName;
    }

    @Column(name = "PERSONAL_ID_EMC_ADDR1", length = 60)
    public String getPersonalIdEmcAddr1() {
        return personalIdEmcAddr1;
    }

    public void setPersonalIdEmcAddr1(String personalIdEmcAddr1) {
        this.personalIdEmcAddr1 = personalIdEmcAddr1;
    }

    @Column(name = "PERSONAL_ID_EMC_PHONE", length = 30)
    public String getPersonalIdEmcPhone() {
        return personalIdEmcPhone;
    }

    public void setPersonalIdEmcPhone(String personalIdEmcPhone) {
        this.personalIdEmcPhone = personalIdEmcPhone;
    }

    @Column(name = "PERSONAL_ID_EMC_ADDR2", length = 30)
    public String getPersonalIdEmcAddr2() {
        return personalIdEmcAddr2;
    }

    public void setPersonalIdEmcAddr2(String personalIdEmcAddr2) {
        this.personalIdEmcAddr2 = personalIdEmcAddr2;
    }

    @Column(name = "PERSONAL_ID_INDENTIFIKASI", length = 30)
    public String getPersonalIdIndentifikasi() {
        return personalIdIndentifikasi;
    }

    public void setPersonalIdIndentifikasi(String personalIdIndentifikasi) {
        this.personalIdIndentifikasi = personalIdIndentifikasi;
    }

    @Column(name = "PERSONAL_KECAMATAN", length = 30)
    public String getPersonalKecamatan() {
        return personalKecamatan;
    }

    public void setPersonalKecamatan(String personalKecamatan) {
        this.personalKecamatan = personalKecamatan;
    }

    @Column(name = "PERSONAL_KELURAHAN", length = 30)
    public String getPersonalKelurahan() {
        return personalKelurahan;
    }

    public void setPersonalKelurahan(String personalKelurahan) {
        this.personalKelurahan = personalKelurahan;
    }

    @Column(name = "PERSONAL_TYPE", length = 2)
    public String getPersonalType() {
        return personalType;
    }

    public void setPersonalType(String personalType) {
        this.personalType = personalType;
    }

    @Column(name = "PERSONAL_RTRW", length = 20)
    public String getPersonalRtrw() {
        return personalRtrw;
    }

    public void setPersonalRtrw(String personalRtrw) {
        this.personalRtrw = personalRtrw;
    }

    @Column(name = "PERSONAL_STATUS", length = 2)
    public String getPersonalStatus() {
        return personalStatus;
    }

    public void setPersonalStatus(String personalStatus) {
        this.personalStatus = personalStatus;
    }

    @Column(name = "PERSONAL_JOIN_DATE")
    public LocalDate getPersonalJoinDate() {
        return personalJoinDate;
    }

    public void setPersonalJoinDate(LocalDate personalJoinDate) {
        this.personalJoinDate = personalJoinDate;
    }

    @Column(name = "PERSONAL_POSITION", length = 50)
    public String getPersonalPosition() {
        return personalPosition;
    }

    public void setPersonalPosition(String personalPosition) {
        this.personalPosition = personalPosition;
    }

    @Column(name = "PERSONAL_HUB_DGN_PEMILIK", length = 15)
    public String getPersonalHubDgnPemilik() {
        return personalHubDgnPemilik;
    }

    public void setPersonalHubDgnPemilik(String personalHubDgnPemilik) {
        this.personalHubDgnPemilik = personalHubDgnPemilik;
    }

    @Column(name = "PERSONAL_ID_TYPE", length = 10)
    public String getPersonalIdType() {
        return personalIdType;
    }

    public void setPersonalIdType(String personalIdType) {
        this.personalIdType = personalIdType;
    }

    @Column(name = "PERSONAL_LAMA_BEKERJA")
    public Short getPersonalLamaBekerja() {
        return personalLamaBekerja;
    }

    public void setPersonalLamaBekerja(Short personalLamaBekerja) {
        this.personalLamaBekerja = personalLamaBekerja;
    }

    @Column(name = "PERSONAL_DMS_ADDR2", length = 60)
    public String getPersonalDmsAddr2() {
        return personalDmsAddr2;
    }

    public void setPersonalDmsAddr2(String personalDmsAddr2) {
        this.personalDmsAddr2 = personalDmsAddr2;
    }

    @Column(name = "PERSONAL_DMS_ADDR1", length = 60)
    public String getPersonalDmsAddr1() {
        return personalDmsAddr1;
    }

    public void setPersonalDmsAddr1(String personalDmsAddr1) {
        this.personalDmsAddr1 = personalDmsAddr1;
    }

    @Column(name = "PERSONAL_DMS_RTRW", length = 20)
    public String getPersonalDmsRtrw() {
        return personalDmsRtrw;
    }

    public void setPersonalDmsRtrw(String personalDmsRtrw) {
        this.personalDmsRtrw = personalDmsRtrw;
    }

    @Column(name = "PERSONAL_DMS_KELURAHAN", length = 30)
    public String getPersonalDmsKelurahan() {
        return personalDmsKelurahan;
    }

    public void setPersonalDmsKelurahan(String personalDmsKelurahan) {
        this.personalDmsKelurahan = personalDmsKelurahan;
    }

    @Column(name = "PERSONAL_DMS_KECAMATAN", length = 30)
    public String getPersonalDmsKecamatan() {
        return personalDmsKecamatan;
    }

    public void setPersonalDmsKecamatan(String personalDmsKecamatan) {
        this.personalDmsKecamatan = personalDmsKecamatan;
    }

    @Column(name = "PERSONAL_DMS_ZIP_CODE", length = 10)
    public String getPersonalDmsZipCode() {
        return personalDmsZipCode;
    }

    public void setPersonalDmsZipCode(String personalDmsZipCode) {
        this.personalDmsZipCode = personalDmsZipCode;
    }

    @Column(name = "PERSONAL_DMS_CITY", length = 30)
    public String getPersonalDmsCity() {
        return personalDmsCity;
    }

    public void setPersonalDmsCity(String personalDmsCity) {
        this.personalDmsCity = personalDmsCity;
    }

    @Column(name = "PERSONAL_CERTIFICATION_DATE")
    public LocalDate getSertifikasiDate(){return sertifikasiDate;}

    public void setSertifikasiDate(LocalDate sertifikasiDate){this.sertifikasiDate = sertifikasiDate;}

    @Column(name = "PERSONAL_CERTIFICATION_NO")
    public String getSertifikasiNo(){return sertifikasiNo;}

    public void setSertifikasiNo(String sertifikasiNo){this.sertifikasiNo = sertifikasiNo;}
}