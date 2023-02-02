package id.co.astra.fifgroup.project.restfm_unit_identification.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity(name = "ArTrnSumContract")
@Table(name = "AR_TRN_SUM_CONTRACTS", schema = "ACCTMGMT")
public class ArTrnSumContract {
    private String id;

    private String applNo;

    private String custNo;

    private Long versionNo;

    private String officeCode;

    private String coyId;

    private String contractStatus;

    private LocalDate contractDate;

    private Long pctPelunasan;

    private Long pctPenalty;

    private LocalDate maturityDate;

    private LocalDate contractActiveDate;

    private LocalDate anniversaryCymDate;

    private LocalDate autoWoDate;

    private LocalDate calcPenDate;

    private String calcPenaltyFlag;

    private String blkExclusionValue;

    private String dcaInd;

    private Long penaltyMinimum;

    private Long penaltyGracePeriod;

    private String penNegoFlag;

    private LocalDate phoneAddrChgInd;

    private LocalDate closedDate;

    private LocalDate closedTriadDate;

    private LocalDate lastPaidDate;

    private LocalDate lastFullPaidDate;

    private Long prncAmtDtlCust;

    private Long prncAmtSubsidi;

    private Long intrAmtDtlAr;

    private Long intrAmtKrdtDp;

    private Long intrAmtSubsidi;

    private Long nextInstNo;

    private LocalDate nextDueDate;

    private Long adminPtAmt;

    private Long adminRremAmt;

    private String currPalNo;

    private LocalDate currPalDate;

    private String currPalSts;

    private String currPalFlag;

    private String woReason;

    private Long prevDlqInstNo;

    private String isPrevInstDlq;

    private Long penaltyAmtNego;

    private Long penaltyAmtPaid;

    private Long prncAmtDtlCustOts;

    private Long prncAmtSubsidiOts;

    private Long intrAmtDtlArOts;

    private Long intrAmtKrdtDpOts;

    private Long intrAmtSubsidiOts;

    private Long closedPrncAmtDtlCustOts;

    private Long closedPrncAmtSubsidiOts;

    private Long closedIntrAmtDtlArOts;

    private Long closedIntrAmtKrdtDpOts;

    private Long closedIntrAmtSubsidiOts;

    private Long prncAmtDtlCustPaid;

    private Long prncAmtSubsidiPaid;

    private Long intrAmtDtlArPaid;

    private Long intrAmtKrdtDpPaid;

    private Long intrAmtSubsidiPaid;

    private Long nextBillInstNo;

    private LocalDate nextBillDate;

    private Long currBillInstNo;

    private LocalDate currBillDate;

    private Long prncAmtDtlCustPaidPcycle;

    private Long prncAmtSubsidiPaidPcycle;

    private Long intrAmtDtlArPaidPcycle;

    private Long intrAmtKrdtDpPaidPcycle;

    private Long intrAmtSubsidiPaidPcycle;

    private Long currDlqInstNo;

    private LocalDate currDlqDate;

    private Long hiCycDlq;

    private Long currCycDlq;

    private Long monthsWithDlq;

    private Long num1CycDlq;

    private Long num2CycDlq;

    private Long num3CycDlq;

    private Long num4pCycDlq;

    private Long prncAmtDtlCustOvd;

    private Long prncAmtSubsidiOvd;

    private Long intrAmtDtlArOvd;

    private Long intrAmtKrdtDpOvd;

    private Long intrAmtSubsidiOvd;

    private Long dpd;

    private Long penaltyAmt;

    private String gcId;

    private String gcMouNo;

    private Long collFee;

    private Long collFeeNego;

    private Long collFeePaid;

    private Long penaltyAmtTemp;

    private Long eodFlag;

    private String createdBy;

    private LocalDate createdTimestamp;

    private String lastupdateBy;

    private LocalDate lastupdateTimestamp;

    private Long defCollFee;

    private LocalDate ppdcfArDate;

    private LocalDate ppdcfPaidDate;

    private Long collDate;

    private Long collAddMonths;

    private String facilityCode;

    private Long reschedVersionNo;

    private String collId;

    private String cycleAwal;

    private String cycleAkhir;

    private String dkhStatus;

    private String isAutoWo;

    private Long totalPrinted;

    private String badAcctFlag;

    private LocalDate badAcctDate;

    private LocalDate lastPostDate;

    private LocalDate lastPrintedDate;

    private String incentiveLetter;

    private String posId;

    private Long ba2Flag;

    private LocalDate ba2Date;

    private Long tazirAmt;

    private Long tazir;

    private Long tazirNego;

    private Long tazirPaid;

    private String isPelsus;

    private Long collFeeArea;

    @Id
    @Column(name = "CONTRACT_NO", nullable = false, length = 20)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Column(name = "APPL_NO", nullable = false, length = 20)
    public String getApplNo() {
        return applNo;
    }

    public void setApplNo(String applNo) {
        this.applNo = applNo;
    }

    @Column(name = "CUST_NO", nullable = false, length = 20)
    public String getCustNo() {
        return custNo;
    }

    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }

    @Column(name = "VERSION_NO", nullable = false)
    public Long getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(Long versionNo) {
        this.versionNo = versionNo;
    }

    @Column(name = "OFFICE_CODE", nullable = false, length = 5)
    public String getOfficeCode() {
        return officeCode;
    }

    public void setOfficeCode(String officeCode) {
        this.officeCode = officeCode;
    }

    @Column(name = "COY_ID", length = 5)
    public String getCoyId() {
        return coyId;
    }

    public void setCoyId(String coyId) {
        this.coyId = coyId;
    }

    @Column(name = "CONTRACT_STATUS", nullable = false, length = 2)
    public String getContractStatus() {
        return contractStatus;
    }

    public void setContractStatus(String contractStatus) {
        this.contractStatus = contractStatus;
    }

    @Column(name = "CONTRACT_DATE", nullable = false)
    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    @Column(name = "PCT_PELUNASAN")
    public Long getPctPelunasan() {
        return pctPelunasan;
    }

    public void setPctPelunasan(Long pctPelunasan) {
        this.pctPelunasan = pctPelunasan;
    }

    @Column(name = "PCT_PENALTY", nullable = false)
    public Long getPctPenalty() {
        return pctPenalty;
    }

    public void setPctPenalty(Long pctPenalty) {
        this.pctPenalty = pctPenalty;
    }

    @Column(name = "MATURITY_DATE")
    public LocalDate getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(LocalDate maturityDate) {
        this.maturityDate = maturityDate;
    }

    @Column(name = "CONTRACT_ACTIVE_DATE")
    public LocalDate getContractActiveDate() {
        return contractActiveDate;
    }

    public void setContractActiveDate(LocalDate contractActiveDate) {
        this.contractActiveDate = contractActiveDate;
    }

    @Column(name = "ANNIVERSARY_CYM_DATE")
    public LocalDate getAnniversaryCymDate() {
        return anniversaryCymDate;
    }

    public void setAnniversaryCymDate(LocalDate anniversaryCymDate) {
        this.anniversaryCymDate = anniversaryCymDate;
    }

    @Column(name = "AUTO_WO_DATE")
    public LocalDate getAutoWoDate() {
        return autoWoDate;
    }

    public void setAutoWoDate(LocalDate autoWoDate) {
        this.autoWoDate = autoWoDate;
    }

    @Column(name = "CALC_PEN_DATE")
    public LocalDate getCalcPenDate() {
        return calcPenDate;
    }

    public void setCalcPenDate(LocalDate calcPenDate) {
        this.calcPenDate = calcPenDate;
    }

    @Column(name = "CALC_PENALTY_FLAG", nullable = false, length = 1)
    public String getCalcPenaltyFlag() {
        return calcPenaltyFlag;
    }

    public void setCalcPenaltyFlag(String calcPenaltyFlag) {
        this.calcPenaltyFlag = calcPenaltyFlag;
    }

    @Column(name = "BLK_EXCLUSION_VALUE", length = 1)
    public String getBlkExclusionValue() {
        return blkExclusionValue;
    }

    public void setBlkExclusionValue(String blkExclusionValue) {
        this.blkExclusionValue = blkExclusionValue;
    }

    @Column(name = "DCA_IND", length = 1)
    public String getDcaInd() {
        return dcaInd;
    }

    public void setDcaInd(String dcaInd) {
        this.dcaInd = dcaInd;
    }

    @Column(name = "PENALTY_MINIMUM")
    public Long getPenaltyMinimum() {
        return penaltyMinimum;
    }

    public void setPenaltyMinimum(Long penaltyMinimum) {
        this.penaltyMinimum = penaltyMinimum;
    }

    @Column(name = "PENALTY_GRACE_PERIOD", nullable = false)
    public Long getPenaltyGracePeriod() {
        return penaltyGracePeriod;
    }

    public void setPenaltyGracePeriod(Long penaltyGracePeriod) {
        this.penaltyGracePeriod = penaltyGracePeriod;
    }

    @Column(name = "PEN_NEGO_FLAG", nullable = false, length = 1)
    public String getPenNegoFlag() {
        return penNegoFlag;
    }

    public void setPenNegoFlag(String penNegoFlag) {
        this.penNegoFlag = penNegoFlag;
    }

    @Column(name = "PHONE_ADDR_CHG_IND")
    public LocalDate getPhoneAddrChgInd() {
        return phoneAddrChgInd;
    }

    public void setPhoneAddrChgInd(LocalDate phoneAddrChgInd) {
        this.phoneAddrChgInd = phoneAddrChgInd;
    }

    @Column(name = "CLOSED_DATE")
    public LocalDate getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(LocalDate closedDate) {
        this.closedDate = closedDate;
    }

    @Column(name = "CLOSED_TRIAD_DATE")
    public LocalDate getClosedTriadDate() {
        return closedTriadDate;
    }

    public void setClosedTriadDate(LocalDate closedTriadDate) {
        this.closedTriadDate = closedTriadDate;
    }

    @Column(name = "LAST_PAID_DATE")
    public LocalDate getLastPaidDate() {
        return lastPaidDate;
    }

    public void setLastPaidDate(LocalDate lastPaidDate) {
        this.lastPaidDate = lastPaidDate;
    }

    @Column(name = "LAST_FULL_PAID_DATE")
    public LocalDate getLastFullPaidDate() {
        return lastFullPaidDate;
    }

    public void setLastFullPaidDate(LocalDate lastFullPaidDate) {
        this.lastFullPaidDate = lastFullPaidDate;
    }

    @Column(name = "PRNC_AMT_DTL_CUST")
    public Long getPrncAmtDtlCust() {
        return prncAmtDtlCust;
    }

    public void setPrncAmtDtlCust(Long prncAmtDtlCust) {
        this.prncAmtDtlCust = prncAmtDtlCust;
    }

    @Column(name = "PRNC_AMT_SUBSIDI")
    public Long getPrncAmtSubsidi() {
        return prncAmtSubsidi;
    }

    public void setPrncAmtSubsidi(Long prncAmtSubsidi) {
        this.prncAmtSubsidi = prncAmtSubsidi;
    }

    @Column(name = "INTR_AMT_DTL_AR")
    public Long getIntrAmtDtlAr() {
        return intrAmtDtlAr;
    }

    public void setIntrAmtDtlAr(Long intrAmtDtlAr) {
        this.intrAmtDtlAr = intrAmtDtlAr;
    }

    @Column(name = "INTR_AMT_KRDT_DP")
    public Long getIntrAmtKrdtDp() {
        return intrAmtKrdtDp;
    }

    public void setIntrAmtKrdtDp(Long intrAmtKrdtDp) {
        this.intrAmtKrdtDp = intrAmtKrdtDp;
    }

    @Column(name = "INTR_AMT_SUBSIDI")
    public Long getIntrAmtSubsidi() {
        return intrAmtSubsidi;
    }

    public void setIntrAmtSubsidi(Long intrAmtSubsidi) {
        this.intrAmtSubsidi = intrAmtSubsidi;
    }

    @Column(name = "NEXT_INST_NO")
    public Long getNextInstNo() {
        return nextInstNo;
    }

    public void setNextInstNo(Long nextInstNo) {
        this.nextInstNo = nextInstNo;
    }

    @Column(name = "NEXT_DUE_DATE")
    public LocalDate getNextDueDate() {
        return nextDueDate;
    }

    public void setNextDueDate(LocalDate nextDueDate) {
        this.nextDueDate = nextDueDate;
    }

    @Column(name = "ADMIN_PT_AMT")
    public Long getAdminPtAmt() {
        return adminPtAmt;
    }

    public void setAdminPtAmt(Long adminPtAmt) {
        this.adminPtAmt = adminPtAmt;
    }

    @Column(name = "ADMIN_RREM_AMT")
    public Long getAdminRremAmt() {
        return adminRremAmt;
    }

    public void setAdminRremAmt(Long adminRremAmt) {
        this.adminRremAmt = adminRremAmt;
    }

    @Column(name = "CURR_PAL_NO", length = 20)
    public String getCurrPalNo() {
        return currPalNo;
    }

    public void setCurrPalNo(String currPalNo) {
        this.currPalNo = currPalNo;
    }

    @Column(name = "CURR_PAL_DATE")
    public LocalDate getCurrPalDate() {
        return currPalDate;
    }

    public void setCurrPalDate(LocalDate currPalDate) {
        this.currPalDate = currPalDate;
    }

    @Column(name = "CURR_PAL_STS", length = 20)
    public String getCurrPalSts() {
        return currPalSts;
    }

    public void setCurrPalSts(String currPalSts) {
        this.currPalSts = currPalSts;
    }

    @Column(name = "CURR_PAL_FLAG", nullable = false, length = 1)
    public String getCurrPalFlag() {
        return currPalFlag;
    }

    public void setCurrPalFlag(String currPalFlag) {
        this.currPalFlag = currPalFlag;
    }

    @Column(name = "WO_REASON", length = 1)
    public String getWoReason() {
        return woReason;
    }

    public void setWoReason(String woReason) {
        this.woReason = woReason;
    }

    @Column(name = "PREV_DLQ_INST_NO")
    public Long getPrevDlqInstNo() {
        return prevDlqInstNo;
    }

    public void setPrevDlqInstNo(Long prevDlqInstNo) {
        this.prevDlqInstNo = prevDlqInstNo;
    }

    @Column(name = "IS_PREV_INST_DLQ", length = 1)
    public String getIsPrevInstDlq() {
        return isPrevInstDlq;
    }

    public void setIsPrevInstDlq(String isPrevInstDlq) {
        this.isPrevInstDlq = isPrevInstDlq;
    }

    @Column(name = "PENALTY_AMT_NEGO")
    public Long getPenaltyAmtNego() {
        return penaltyAmtNego;
    }

    public void setPenaltyAmtNego(Long penaltyAmtNego) {
        this.penaltyAmtNego = penaltyAmtNego;
    }

    @Column(name = "PENALTY_AMT_PAID")
    public Long getPenaltyAmtPaid() {
        return penaltyAmtPaid;
    }

    public void setPenaltyAmtPaid(Long penaltyAmtPaid) {
        this.penaltyAmtPaid = penaltyAmtPaid;
    }

    @Column(name = "PRNC_AMT_DTL_CUST_OTS")
    public Long getPrncAmtDtlCustOts() {
        return prncAmtDtlCustOts;
    }

    public void setPrncAmtDtlCustOts(Long prncAmtDtlCustOts) {
        this.prncAmtDtlCustOts = prncAmtDtlCustOts;
    }

    @Column(name = "PRNC_AMT_SUBSIDI_OTS")
    public Long getPrncAmtSubsidiOts() {
        return prncAmtSubsidiOts;
    }

    public void setPrncAmtSubsidiOts(Long prncAmtSubsidiOts) {
        this.prncAmtSubsidiOts = prncAmtSubsidiOts;
    }

    @Column(name = "INTR_AMT_DTL_AR_OTS")
    public Long getIntrAmtDtlArOts() {
        return intrAmtDtlArOts;
    }

    public void setIntrAmtDtlArOts(Long intrAmtDtlArOts) {
        this.intrAmtDtlArOts = intrAmtDtlArOts;
    }

    @Column(name = "INTR_AMT_KRDT_DP_OTS")
    public Long getIntrAmtKrdtDpOts() {
        return intrAmtKrdtDpOts;
    }

    public void setIntrAmtKrdtDpOts(Long intrAmtKrdtDpOts) {
        this.intrAmtKrdtDpOts = intrAmtKrdtDpOts;
    }

    @Column(name = "INTR_AMT_SUBSIDI_OTS")
    public Long getIntrAmtSubsidiOts() {
        return intrAmtSubsidiOts;
    }

    public void setIntrAmtSubsidiOts(Long intrAmtSubsidiOts) {
        this.intrAmtSubsidiOts = intrAmtSubsidiOts;
    }

    @Column(name = "CLOSED_PRNC_AMT_DTL_CUST_OTS")
    public Long getClosedPrncAmtDtlCustOts() {
        return closedPrncAmtDtlCustOts;
    }

    public void setClosedPrncAmtDtlCustOts(Long closedPrncAmtDtlCustOts) {
        this.closedPrncAmtDtlCustOts = closedPrncAmtDtlCustOts;
    }

    @Column(name = "CLOSED_PRNC_AMT_SUBSIDI_OTS")
    public Long getClosedPrncAmtSubsidiOts() {
        return closedPrncAmtSubsidiOts;
    }

    public void setClosedPrncAmtSubsidiOts(Long closedPrncAmtSubsidiOts) {
        this.closedPrncAmtSubsidiOts = closedPrncAmtSubsidiOts;
    }

    @Column(name = "CLOSED_INTR_AMT_DTL_AR_OTS")
    public Long getClosedIntrAmtDtlArOts() {
        return closedIntrAmtDtlArOts;
    }

    public void setClosedIntrAmtDtlArOts(Long closedIntrAmtDtlArOts) {
        this.closedIntrAmtDtlArOts = closedIntrAmtDtlArOts;
    }

    @Column(name = "CLOSED_INTR_AMT_KRDT_DP_OTS")
    public Long getClosedIntrAmtKrdtDpOts() {
        return closedIntrAmtKrdtDpOts;
    }

    public void setClosedIntrAmtKrdtDpOts(Long closedIntrAmtKrdtDpOts) {
        this.closedIntrAmtKrdtDpOts = closedIntrAmtKrdtDpOts;
    }

    @Column(name = "CLOSED_INTR_AMT_SUBSIDI_OTS")
    public Long getClosedIntrAmtSubsidiOts() {
        return closedIntrAmtSubsidiOts;
    }

    public void setClosedIntrAmtSubsidiOts(Long closedIntrAmtSubsidiOts) {
        this.closedIntrAmtSubsidiOts = closedIntrAmtSubsidiOts;
    }

    @Column(name = "PRNC_AMT_DTL_CUST_PAID")
    public Long getPrncAmtDtlCustPaid() {
        return prncAmtDtlCustPaid;
    }

    public void setPrncAmtDtlCustPaid(Long prncAmtDtlCustPaid) {
        this.prncAmtDtlCustPaid = prncAmtDtlCustPaid;
    }

    @Column(name = "PRNC_AMT_SUBSIDI_PAID")
    public Long getPrncAmtSubsidiPaid() {
        return prncAmtSubsidiPaid;
    }

    public void setPrncAmtSubsidiPaid(Long prncAmtSubsidiPaid) {
        this.prncAmtSubsidiPaid = prncAmtSubsidiPaid;
    }

    @Column(name = "INTR_AMT_DTL_AR_PAID")
    public Long getIntrAmtDtlArPaid() {
        return intrAmtDtlArPaid;
    }

    public void setIntrAmtDtlArPaid(Long intrAmtDtlArPaid) {
        this.intrAmtDtlArPaid = intrAmtDtlArPaid;
    }

    @Column(name = "INTR_AMT_KRDT_DP_PAID")
    public Long getIntrAmtKrdtDpPaid() {
        return intrAmtKrdtDpPaid;
    }

    public void setIntrAmtKrdtDpPaid(Long intrAmtKrdtDpPaid) {
        this.intrAmtKrdtDpPaid = intrAmtKrdtDpPaid;
    }

    @Column(name = "INTR_AMT_SUBSIDI_PAID")
    public Long getIntrAmtSubsidiPaid() {
        return intrAmtSubsidiPaid;
    }

    public void setIntrAmtSubsidiPaid(Long intrAmtSubsidiPaid) {
        this.intrAmtSubsidiPaid = intrAmtSubsidiPaid;
    }

    @Column(name = "NEXT_BILL_INST_NO")
    public Long getNextBillInstNo() {
        return nextBillInstNo;
    }

    public void setNextBillInstNo(Long nextBillInstNo) {
        this.nextBillInstNo = nextBillInstNo;
    }

    @Column(name = "NEXT_BILL_DATE")
    public LocalDate getNextBillDate() {
        return nextBillDate;
    }

    public void setNextBillDate(LocalDate nextBillDate) {
        this.nextBillDate = nextBillDate;
    }

    @Column(name = "CURR_BILL_INST_NO")
    public Long getCurrBillInstNo() {
        return currBillInstNo;
    }

    public void setCurrBillInstNo(Long currBillInstNo) {
        this.currBillInstNo = currBillInstNo;
    }

    @Column(name = "CURR_BILL_DATE")
    public LocalDate getCurrBillDate() {
        return currBillDate;
    }

    public void setCurrBillDate(LocalDate currBillDate) {
        this.currBillDate = currBillDate;
    }

    @Column(name = "PRNC_AMT_DTL_CUST_PAID_PCYCLE")
    public Long getPrncAmtDtlCustPaidPcycle() {
        return prncAmtDtlCustPaidPcycle;
    }

    public void setPrncAmtDtlCustPaidPcycle(Long prncAmtDtlCustPaidPcycle) {
        this.prncAmtDtlCustPaidPcycle = prncAmtDtlCustPaidPcycle;
    }

    @Column(name = "PRNC_AMT_SUBSIDI_PAID_PCYCLE")
    public Long getPrncAmtSubsidiPaidPcycle() {
        return prncAmtSubsidiPaidPcycle;
    }

    public void setPrncAmtSubsidiPaidPcycle(Long prncAmtSubsidiPaidPcycle) {
        this.prncAmtSubsidiPaidPcycle = prncAmtSubsidiPaidPcycle;
    }

    @Column(name = "INTR_AMT_DTL_AR_PAID_PCYCLE")
    public Long getIntrAmtDtlArPaidPcycle() {
        return intrAmtDtlArPaidPcycle;
    }

    public void setIntrAmtDtlArPaidPcycle(Long intrAmtDtlArPaidPcycle) {
        this.intrAmtDtlArPaidPcycle = intrAmtDtlArPaidPcycle;
    }

    @Column(name = "INTR_AMT_KRDT_DP_PAID_PCYCLE")
    public Long getIntrAmtKrdtDpPaidPcycle() {
        return intrAmtKrdtDpPaidPcycle;
    }

    public void setIntrAmtKrdtDpPaidPcycle(Long intrAmtKrdtDpPaidPcycle) {
        this.intrAmtKrdtDpPaidPcycle = intrAmtKrdtDpPaidPcycle;
    }

    @Column(name = "INTR_AMT_SUBSIDI_PAID_PCYCLE")
    public Long getIntrAmtSubsidiPaidPcycle() {
        return intrAmtSubsidiPaidPcycle;
    }

    public void setIntrAmtSubsidiPaidPcycle(Long intrAmtSubsidiPaidPcycle) {
        this.intrAmtSubsidiPaidPcycle = intrAmtSubsidiPaidPcycle;
    }

    @Column(name = "CURR_DLQ_INST_NO")
    public Long getCurrDlqInstNo() {
        return currDlqInstNo;
    }

    public void setCurrDlqInstNo(Long currDlqInstNo) {
        this.currDlqInstNo = currDlqInstNo;
    }

    @Column(name = "CURR_DLQ_DATE")
    public LocalDate getCurrDlqDate() {
        return currDlqDate;
    }

    public void setCurrDlqDate(LocalDate currDlqDate) {
        this.currDlqDate = currDlqDate;
    }

    @Column(name = "HI_CYC_DLQ")
    public Long getHiCycDlq() {
        return hiCycDlq;
    }

    public void setHiCycDlq(Long hiCycDlq) {
        this.hiCycDlq = hiCycDlq;
    }

    @Column(name = "CURR_CYC_DLQ")
    public Long getCurrCycDlq() {
        return currCycDlq;
    }

    public void setCurrCycDlq(Long currCycDlq) {
        this.currCycDlq = currCycDlq;
    }

    @Column(name = "MONTHS_WITH_DLQ")
    public Long getMonthsWithDlq() {
        return monthsWithDlq;
    }

    public void setMonthsWithDlq(Long monthsWithDlq) {
        this.monthsWithDlq = monthsWithDlq;
    }

    @Column(name = "NUM_1_CYC_DLQ")
    public Long getNum1CycDlq() {
        return num1CycDlq;
    }

    public void setNum1CycDlq(Long num1CycDlq) {
        this.num1CycDlq = num1CycDlq;
    }

    @Column(name = "NUM_2_CYC_DLQ")
    public Long getNum2CycDlq() {
        return num2CycDlq;
    }

    public void setNum2CycDlq(Long num2CycDlq) {
        this.num2CycDlq = num2CycDlq;
    }

    @Column(name = "NUM_3_CYC_DLQ")
    public Long getNum3CycDlq() {
        return num3CycDlq;
    }

    public void setNum3CycDlq(Long num3CycDlq) {
        this.num3CycDlq = num3CycDlq;
    }

    @Column(name = "NUM_4P_CYC_DLQ")
    public Long getNum4pCycDlq() {
        return num4pCycDlq;
    }

    public void setNum4pCycDlq(Long num4pCycDlq) {
        this.num4pCycDlq = num4pCycDlq;
    }

    @Column(name = "PRNC_AMT_DTL_CUST_OVD")
    public Long getPrncAmtDtlCustOvd() {
        return prncAmtDtlCustOvd;
    }

    public void setPrncAmtDtlCustOvd(Long prncAmtDtlCustOvd) {
        this.prncAmtDtlCustOvd = prncAmtDtlCustOvd;
    }

    @Column(name = "PRNC_AMT_SUBSIDI_OVD")
    public Long getPrncAmtSubsidiOvd() {
        return prncAmtSubsidiOvd;
    }

    public void setPrncAmtSubsidiOvd(Long prncAmtSubsidiOvd) {
        this.prncAmtSubsidiOvd = prncAmtSubsidiOvd;
    }

    @Column(name = "INTR_AMT_DTL_AR_OVD")
    public Long getIntrAmtDtlArOvd() {
        return intrAmtDtlArOvd;
    }

    public void setIntrAmtDtlArOvd(Long intrAmtDtlArOvd) {
        this.intrAmtDtlArOvd = intrAmtDtlArOvd;
    }

    @Column(name = "INTR_AMT_KRDT_DP_OVD")
    public Long getIntrAmtKrdtDpOvd() {
        return intrAmtKrdtDpOvd;
    }

    public void setIntrAmtKrdtDpOvd(Long intrAmtKrdtDpOvd) {
        this.intrAmtKrdtDpOvd = intrAmtKrdtDpOvd;
    }

    @Column(name = "INTR_AMT_SUBSIDI_OVD")
    public Long getIntrAmtSubsidiOvd() {
        return intrAmtSubsidiOvd;
    }

    public void setIntrAmtSubsidiOvd(Long intrAmtSubsidiOvd) {
        this.intrAmtSubsidiOvd = intrAmtSubsidiOvd;
    }

    @Column(name = "DPD")
    public Long getDpd() {
        return dpd;
    }

    public void setDpd(Long dpd) {
        this.dpd = dpd;
    }

    @Column(name = "PENALTY_AMT")
    public Long getPenaltyAmt() {
        return penaltyAmt;
    }

    public void setPenaltyAmt(Long penaltyAmt) {
        this.penaltyAmt = penaltyAmt;
    }

    @Column(name = "GC_ID", length = 20)
    public String getGcId() {
        return gcId;
    }

    public void setGcId(String gcId) {
        this.gcId = gcId;
    }

    @Column(name = "GC_MOU_NO", length = 20)
    public String getGcMouNo() {
        return gcMouNo;
    }

    public void setGcMouNo(String gcMouNo) {
        this.gcMouNo = gcMouNo;
    }

    @Column(name = "COLL_FEE")
    public Long getCollFee() {
        return collFee;
    }

    public void setCollFee(Long collFee) {
        this.collFee = collFee;
    }

    @Column(name = "COLL_FEE_NEGO")
    public Long getCollFeeNego() {
        return collFeeNego;
    }

    public void setCollFeeNego(Long collFeeNego) {
        this.collFeeNego = collFeeNego;
    }

    @Column(name = "COLL_FEE_PAID")
    public Long getCollFeePaid() {
        return collFeePaid;
    }

    public void setCollFeePaid(Long collFeePaid) {
        this.collFeePaid = collFeePaid;
    }

    @Column(name = "PENALTY_AMT_TEMP")
    public Long getPenaltyAmtTemp() {
        return penaltyAmtTemp;
    }

    public void setPenaltyAmtTemp(Long penaltyAmtTemp) {
        this.penaltyAmtTemp = penaltyAmtTemp;
    }

    @Column(name = "EOD_FLAG")
    public Long getEodFlag() {
        return eodFlag;
    }

    public void setEodFlag(Long eodFlag) {
        this.eodFlag = eodFlag;
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

    @Column(name = "DEF_COLL_FEE")
    public Long getDefCollFee() {
        return defCollFee;
    }

    public void setDefCollFee(Long defCollFee) {
        this.defCollFee = defCollFee;
    }

    @Column(name = "PPDCF_AR_DATE")
    public LocalDate getPpdcfArDate() {
        return ppdcfArDate;
    }

    public void setPpdcfArDate(LocalDate ppdcfArDate) {
        this.ppdcfArDate = ppdcfArDate;
    }

    @Column(name = "PPDCF_PAID_DATE")
    public LocalDate getPpdcfPaidDate() {
        return ppdcfPaidDate;
    }

    public void setPpdcfPaidDate(LocalDate ppdcfPaidDate) {
        this.ppdcfPaidDate = ppdcfPaidDate;
    }

    @Column(name = "COLL_DATE")
    public Long getCollDate() {
        return collDate;
    }

    public void setCollDate(Long collDate) {
        this.collDate = collDate;
    }

    @Column(name = "COLL_ADD_MONTHS")
    public Long getCollAddMonths() {
        return collAddMonths;
    }

    public void setCollAddMonths(Long collAddMonths) {
        this.collAddMonths = collAddMonths;
    }

    @Column(name = "FACILITY_CODE", length = 30)
    public String getFacilityCode() {
        return facilityCode;
    }

    public void setFacilityCode(String facilityCode) {
        this.facilityCode = facilityCode;
    }

    @Column(name = "RESCHED_VERSION_NO")
    public Long getReschedVersionNo() {
        return reschedVersionNo;
    }

    public void setReschedVersionNo(Long reschedVersionNo) {
        this.reschedVersionNo = reschedVersionNo;
    }

    @Column(name = "COLL_ID", length = 20)
    public String getCollId() {
        return collId;
    }

    public void setCollId(String collId) {
        this.collId = collId;
    }

    @Column(name = "CYCLE_AWAL", length = 2)
    public String getCycleAwal() {
        return cycleAwal;
    }

    public void setCycleAwal(String cycleAwal) {
        this.cycleAwal = cycleAwal;
    }

    @Column(name = "CYCLE_AKHIR", length = 2)
    public String getCycleAkhir() {
        return cycleAkhir;
    }

    public void setCycleAkhir(String cycleAkhir) {
        this.cycleAkhir = cycleAkhir;
    }

    @Column(name = "DKH_STATUS", nullable = false, length = 2)
    public String getDkhStatus() {
        return dkhStatus;
    }

    public void setDkhStatus(String dkhStatus) {
        this.dkhStatus = dkhStatus;
    }

    @Column(name = "IS_AUTO_WO", length = 1)
    public String getIsAutoWo() {
        return isAutoWo;
    }

    public void setIsAutoWo(String isAutoWo) {
        this.isAutoWo = isAutoWo;
    }

    @Column(name = "TOTAL_PRINTED")
    public Long getTotalPrinted() {
        return totalPrinted;
    }

    public void setTotalPrinted(Long totalPrinted) {
        this.totalPrinted = totalPrinted;
    }

    @Column(name = "BAD_ACCT_FLAG", length = 1)
    public String getBadAcctFlag() {
        return badAcctFlag;
    }

    public void setBadAcctFlag(String badAcctFlag) {
        this.badAcctFlag = badAcctFlag;
    }

    @Column(name = "BAD_ACCT_DATE")
    public LocalDate getBadAcctDate() {
        return badAcctDate;
    }

    public void setBadAcctDate(LocalDate badAcctDate) {
        this.badAcctDate = badAcctDate;
    }

    @Column(name = "LAST_POST_DATE")
    public LocalDate getLastPostDate() {
        return lastPostDate;
    }

    public void setLastPostDate(LocalDate lastPostDate) {
        this.lastPostDate = lastPostDate;
    }

    @Column(name = "LAST_PRINTED_DATE")
    public LocalDate getLastPrintedDate() {
        return lastPrintedDate;
    }

    public void setLastPrintedDate(LocalDate lastPrintedDate) {
        this.lastPrintedDate = lastPrintedDate;
    }

    @Column(name = "INCENTIVE_LETTER", length = 30)
    public String getIncentiveLetter() {
        return incentiveLetter;
    }

    public void setIncentiveLetter(String incentiveLetter) {
        this.incentiveLetter = incentiveLetter;
    }

    @Column(name = "POS_ID", length = 5)
    public String getPosId() {
        return posId;
    }

    public void setPosId(String posId) {
        this.posId = posId;
    }

    @Column(name = "BA2_FLAG")
    public Long getBa2Flag() {
        return ba2Flag;
    }

    public void setBa2Flag(Long ba2Flag) {
        this.ba2Flag = ba2Flag;
    }

    @Column(name = "BA2_DATE")
    public LocalDate getBa2Date() {
        return ba2Date;
    }

    public void setBa2Date(LocalDate ba2Date) {
        this.ba2Date = ba2Date;
    }

    @Column(name = "TAZIR_AMT")
    public Long getTazirAmt() {
        return tazirAmt;
    }

    public void setTazirAmt(Long tazirAmt) {
        this.tazirAmt = tazirAmt;
    }

    @Column(name = "TAZIR")
    public Long getTazir() {
        return tazir;
    }

    public void setTazir(Long tazir) {
        this.tazir = tazir;
    }

    @Column(name = "TAZIR_NEGO")
    public Long getTazirNego() {
        return tazirNego;
    }

    public void setTazirNego(Long tazirNego) {
        this.tazirNego = tazirNego;
    }

    @Column(name = "TAZIR_PAID")
    public Long getTazirPaid() {
        return tazirPaid;
    }

    public void setTazirPaid(Long tazirPaid) {
        this.tazirPaid = tazirPaid;
    }

    @Column(name = "IS_PELSUS", length = 1)
    public String getIsPelsus() {
        return isPelsus;
    }

    public void setIsPelsus(String isPelsus) {
        this.isPelsus = isPelsus;
    }

    @Column(name = "COLL_FEE_AREA")
    public Long getCollFeeArea() {
        return collFeeArea;
    }

    public void setCollFeeArea(Long collFeeArea) {
        this.collFeeArea = collFeeArea;
    }

}