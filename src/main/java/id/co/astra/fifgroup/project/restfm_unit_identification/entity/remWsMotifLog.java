package id.co.astra.fifgroup.project.restfm_unit_identification.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

@Entity
@Table(name = "REM_WS_MOTIF_LOG", schema = "ACCTMGMT")
public class remWsMotifLog {
    @Id
    @Column(name = "UUID", nullable = false)
    private String uuidMotif;

    @Column(name = "CONTRACT_NO")
    private String contractNo;

    @Column(name = "APPL_NO")
    private  String applNo;

    @Column(name = "REQUEST_TYPE")
    private String requestType;

    @Column(name = "SEND_STAT")
    private String sendStat;

    @Column(name = "MESSAGE_STAT")
    private String messageStat;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "REQUEST_BY")
    private String requestBy;

    public String getUuidMotif() {
        return uuidMotif;
    }

    public void setUuidMotif(String uuidMotif) {
        this.uuidMotif = uuidMotif;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getApplNo() {
        return applNo;
    }

    public void setApplNo(String applNo) {
        this.applNo = applNo;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public String getSendStat() {
        return sendStat;
    }

    public void setSendStat(String sendStat) {
        this.sendStat = sendStat;
    }

    public String getMessageStat() {
        return messageStat;
    }

    public void setMessageStat(String messageStat) {
        this.messageStat = messageStat;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }
}