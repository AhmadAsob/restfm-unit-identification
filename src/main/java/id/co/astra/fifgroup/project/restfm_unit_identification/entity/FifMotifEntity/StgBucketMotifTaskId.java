package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifMotifEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Embeddable
@Getter
@Setter
public class StgBucketMotifTaskId  implements Serializable {

    private static final long serialVersionUID = -4321374690117837135L;
    @Column(name = "STG_NO_LKP")
    private String stgNoLkp;

    @Column(name = "STG_SEQN")
    private Integer stgSeqn;


    @Column(name = "STG_NO_KONTRAK")
    private String stgNoKontrak;
}
