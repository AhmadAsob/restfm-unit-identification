package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

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
@Table(name = "MST_COMPANY_V", schema = "ACCTMGMT")
@NoArgsConstructor
@AllArgsConstructor
public class mstCompany {

    @Id
    @Column(name = "COY_ID",  nullable = false)
    private String coyId;

    @Column(name = "COY_NAME", nullable = false)
    private String coyName;

    @Column(name = "SEGMENT_COY", nullable = false)
    private String segementCoy;

    @Column(name = "SET_OF_BOOK_ID", nullable = false)
    private String setOfBookId;

    @Column(name = "CREATE_BY", nullable = false)
    private String createBy;

    @Column(name = "CREATE_DATE", nullable = false)
    private LocalDate createDate;

    @Column(name = "UPDATE_BY")
    private String updateBy;

    @Column(name = "UPDATE_DATE")
    private LocalDate updateDate;

    @Column(name = "SEGMENT_NO")
    private int segmentNo;

    @Column(name = "PREF_JE_CATEGORY")
    private String prefJeCategory;

    @Column(name = "DEFAULT_PLATFORM")
    private String defaultPlatform;

    @Column(name = "NAME_SHORT")
    private String nameShort;
}
