package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

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
@Table(name = "REM_TRN_WS_MOTIF", schema = "ACCTMGMT")
public class remTrnWsMotif {

    @Id
    @Column(name = "UUID", nullable = false)
    private String uuid;

    @Column(name = "CONTRACT_NO")
    private String contractNo;

    @Column(name = "SKPC_NO")
    private String skpcNo;

    @Column(name = "REQUEST_NO")
    private String requestNo;

    @Column(name = "REQUEST_TYPE")
    private String requestType;

    @Column(name = "SEND_STAT")
    private String sendStat;

    @Column(name = "MESSAGE_STAT")
    private String messageStat;

    @Column(name = "PATH_FOLDER")
    private String pathFolder;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "CREATE_BY")
    private String createBy;

    @Column(name = "REQUEST_BY")
    private String requestBy;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public String getSkpcNo() {
        return skpcNo;
    }

    public void setSkpcNo(String skpcNo) {
        this.skpcNo = skpcNo;
    }

    public String getRequestNo() {
        return requestNo;
    }

    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
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

    public String getPathFolder() {
        return pathFolder;
    }

    public void setPathFolder(String pathFolder) {
        this.pathFolder = pathFolder;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }
}
