package id.co.astra.fifgroup.project.restfm_unit_identification.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "MST_JOB_CODES_V", schema = "ACCTMGMT")
@NoArgsConstructor
@AllArgsConstructor
public class mstJobCodes {

    @Id
    @Column(name = "JOB_CODE",nullable = false)
    private String jobCode;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "OFFICE_CODE")
    private String officeCode;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_TIMESTAMP")
    private LocalDate createdTimestamp;

    @Column(name = "LASTUPDATE_BY")
    private String lastupdateBy;

    @Column(name = "LASTUPDATE_TIMESTAMP")
    private LocalDate lastupdateTimestamp;
}
