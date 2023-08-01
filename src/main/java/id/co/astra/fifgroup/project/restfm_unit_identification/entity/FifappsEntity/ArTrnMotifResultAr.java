package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "ArTrnMotifResultAr")
@Table(name = "AR_TRN_MOTIF_RESULT_AR", schema = "ACCTMGMT")
public class ArTrnMotifResultAr {
    private ArTrnMotifResultArId id;

    private String collId;

    private int mobId;

    private String lkpNo;

    private String pcId;

    private int receivedAmt;

    private int receiveInstallment;

    private int receivePenalty;

    private int receiveCollFee;

    private LocalDateTime transDate;

    private String coyId;

    private String bussUnit;

    private String platform;

    private String flagUpdate;

    private String createdBy;

    private LocalDateTime createdDate;

    private String updateBy;

    private LocalDateTime updateDate;

    private int receiveBpkbFee;

    private String lkpFlag;

    @EmbeddedId
    public ArTrnMotifResultArId getId(){return id;}

    public void setId(ArTrnMotifResultArId id){this.id = id;}

    @Column(name = "COLL_ID")
    public String getCollId(){return collId;}

    public void setCollId(String collId){this.collId = collId;}

    @Column(name = "MOB_ID")
    public int getMobId(){return mobId;}

    public void setMobId(int mobId){this.mobId = mobId;}

    @Column(name = "LKP_NO")
    public String getLkpNo(){return lkpNo;}

    public void setLkpNo (String lkpNo){this.lkpNo = lkpNo;}

    @Column(name = "PC_ID")
    public String getPcId(){return pcId;}

    public void setPcId (String pcId){this.pcId = pcId;}

    @Column(name = "RECEIVED_AMT")
    public int getReceivedAmt(){return receivedAmt;}

    public void setReceivedAmt(int receivedAmt){this.receivedAmt= receivedAmt;}

    @Column(name = "RECEIVE_INSTALLMENT")
    public int getReceiveInstallment(){return receiveInstallment;}

    public void setReceiveInstallment(int receiveInstallment){this.receiveInstallment = receiveInstallment;}

    @Column(name = "RECEIVE_PENALTY")
    public int getReceivePenalty(){return receivePenalty;}

    public void setReceivePenalty(int receivePenalty){this.receivePenalty = receivePenalty;}

    @Column(name = "RECEIVE_COLL_FEE")
    public int getReceiveCollFee(){return receiveCollFee;}

    public void setReceiveCollFee(int receiveCollFee){this.receiveCollFee = receiveCollFee;}

    @Column(name = "TRANS_DATE")
    public LocalDateTime getTransDate(){return transDate;}

    public void setTransDate (LocalDateTime transDate){this.transDate = transDate;}

    @Column(name = "COY_ID")
    public String getCoyId(){return coyId;}

    public void setCoyId (String coyId){this.coyId = coyId;}

    @Column(name = "BUSS_UNIT")
    public String getBussUnit(){return bussUnit;}

    public void setBussUnit(String bussUnit){this.bussUnit = bussUnit;}

    @Column(name = "PLATFORM")
    public String getPlatform (){return platform;}

    public void setPlatform (String platform){this.platform = platform;}

    @Column(name = "FLAG_UPDATE")
    public String getFlagUpdate(){return flagUpdate;}

    public void setFlagUpdate(String flagUpdate){this.flagUpdate = flagUpdate;}

    @Column(name = "CREATED_BY")
    public String getCreatedBy (){return createdBy;}

    public void setCreatedBy(String createdBy){this.createdBy = createdBy;}

    @Column(name = "CREATED_DATE")
    public LocalDateTime getCreatedDate(){return createdDate;}

    public void setCreatedDate(LocalDateTime createdDate){this.createdDate = createdDate;}

    @Column(name = "UPDATED_BY")
    public String getUpdateBy(){return updateBy;}

    public void setUpdateBy(String updateBy){this.updateBy = updateBy;}

    @Column(name = "UPDATED_DATE")
    public LocalDateTime getUpdateDate(){return updateDate;}

    public void setUpdateDate(LocalDateTime updateDate){this.updateDate = updateDate;}

    @Column(name = "RECEIVE_BPKB_FEE")
    public int getReceiveBpkbFee(){return receiveBpkbFee;}

    public void setReceiveBpkbFee(int receiveBpkbFee){this.receiveBpkbFee = receiveBpkbFee;}

    @Column(name = "LKP_FLAG")
    public String getLkpFlag(){return lkpFlag;}

    public void setLkpFlag(String lkpFlag){this.lkpFlag = lkpFlag;}
}
