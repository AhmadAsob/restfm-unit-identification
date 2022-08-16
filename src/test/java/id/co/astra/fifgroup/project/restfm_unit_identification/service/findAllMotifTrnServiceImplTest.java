package id.co.astra.fifgroup.project.restfm_unit_identification.service;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.remTrnMotifBuckets;
import id.co.astra.fifgroup.project.restfm_unit_identification.repository.motif_TrnRepo;
import id.co.astra.fifgroup.project.restfm_unit_identification.services.findAllMotifTrnService;
import org.apache.tomcat.jni.Local;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
public class findAllMotifTrnServiceImplTest {

    @Autowired
    findAllMotifTrnService findAllMotifTrnService;

    @MockBean
    motif_TrnRepo motif_trnRepo;

    @Test
    public void dataFound() throws Exception {

        //output
        List<remTrnMotifBuckets> listBu = new ArrayList<>();
        remTrnMotifBuckets bu = new remTrnMotifBuckets();
        bu.setNoKontrak("709000645915");
        bu.setCabangKontrak("PRAYA");
        bu.setKodeCabangKontrak("70900");
        bu.setNamaKonsumen("AGUS SUHARDI");
        bu.setHariKeterlambatan(1092);
        bu.setMerkMotor("HONDA");
        bu.setModelMotor("BEATFIPOPCW");
        bu.setWarnaMotor("HITAM");
        bu.setTahunMotor(2015);
        bu.setTanggalBayarTerakhir(LocalDate.of(2015,9,9));
        bu.setHutangPokok(13543758);
        bu.setNoMesin("JFS1E1103311");
        bu.setNoRangka("MH1JFS118FK105270");
        bu.setNoPolisi("DR3959TN");
        bu.setNoFidusia("W2100032574AH0501-15");
        bu.setAlamat("DUSUN LENDANG PAOK DESA SELEBUNG RT 000 RW 000 Kel Selebung Kec Batukliang Kab Lombok Tengah Prop Nusa Tenggara Barat 83555");
        bu.setHp("087865186179");
        listBu.add(bu);

        //out Service
        when(motif_trnRepo.findAll()).thenReturn(listBu);

        //Request and Get Result
        List<remTrnMotifBuckets> resultBl = null;
        resultBl = findAllMotifTrnService.findAllTrnMotifData();

        //Verify Result
        assertNotNull(resultBl);

    }
}
