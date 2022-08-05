package id.co.astra.fifgroup.project.restfm_unit_identification.dto;

import org.springframework.web.multipart.MultipartFile;

/*
 * Author : 60964 - Christofer Yeremia
 * Ticket : 2021042608205225 - Motif 3.0 (FM Unit Identification)
 */

public class sendEmaildto {
    String subject;
    String emailBody;
    MultipartFile[] attachBytes;
    String[] attachName;
    String[] to;
    String[] cc;
    String requestBy;

    public sendEmaildto() {
    }

    public sendEmaildto(String subject, String emailBody, MultipartFile[] attachBytes, String[] attachName, String[] to, String[] cc, String requestBy) {
        this.subject = subject;
        this.emailBody = emailBody;
        this.attachBytes = attachBytes;
        this.attachName = attachName;
        this.to = to;
        this.cc = cc;
        this.requestBy = requestBy;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public void setEmailBody(String emailBody) {
        this.emailBody = emailBody;
    }

    public MultipartFile[] getAttachBytes() {
        return attachBytes;
    }

    public void setAttachBytes(MultipartFile[] attachBytes) {
        this.attachBytes = attachBytes;
    }

    public String[] getAttachName() {
        return attachName;
    }

    public void setAttachName(String[] attachName) {
        this.attachName = attachName;
    }

    public String[] getTo() {
        return to;
    }

    public void setTo(String[] to) {
        this.to = to;
    }

    public String[] getCc() {
        return cc;
    }

    public void setCc(String[] cc) {
        this.cc = cc;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }
}
