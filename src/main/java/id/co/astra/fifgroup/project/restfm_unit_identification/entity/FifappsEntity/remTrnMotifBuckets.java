package id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "REM_TRN_MOTIF_BUCKETS" , schema = "ACCTMGMT")
@NoArgsConstructor
@AllArgsConstructor
public class remTrnMotifBuckets {

    @Id
    @Column(name = "NO_KONTRAK", nullable = false)
    private String noKontrak;

    @Column (name = "CABANG_KONTRAK", nullable = true)
    private String cabangKontrak;

    @Column (name = "KODE_CABANG_KONTRAK", nullable = false)
    private String kodeCabangKontrak;

    @Column (name = "NAMA_KONSUMEN",  nullable = false)
    private String namaKonsumen;

    @Column (name = "HARI_KETERLAMBATAN", nullable = true)
    private int hariKeterlambatan;

    @Column (name = "MERK_MOTOR", nullable = true)
    private String merkMotor;

    @Column (name = "MODEL_MOTOR", nullable = true)
    private String modelMotor;

    @Column (name = "WARNA_MOTOR", nullable = true)
    private String warnaMotor;

    @Column (name = "TAHUN_MOTOR", nullable = true)
    private int tahunMotor;

    @Column (name = "TANGGAL_BAYAR_TERAKHIR")
    private LocalDate tanggalBayarTerakhir;

    @Column (name = "HUTANG_POKOK")
    private int hutangPokok;

    @Column (name = "NO_MESIN")
    private String noMesin;

    @Column (name = "NO_RANGKA")
    private String noRangka;

    @Column (name = "NO_POLISI")
    private String noPolisi;

    @Column (name = "NO_FIDUSIA")
    private String noFidusia;

    @Column (name = "ALAMAT")
    private String alamat;

    @Column (name = "HP")
    private String hp;

}
