package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "RemLogMotifErr")
@Getter
@Setter
@Table(name = "REM_LOG_MOTIF_ERR", schema = "ACCTMGMT")
public class RemLogMotifErr {

    @Id
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "REQUEST", nullable = false)
    private String request;

    @Column(name = "RESPONSE", nullable = false)
    private String response;

    @Column(name = "SERVICE", nullable = false)
    private String service;

    @Column(name = "DETAIL", nullable = false)
    private String detail;

    @Column(name = "CREATED_DATE", nullable = false)
    private LocalDateTime createdDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }
}
