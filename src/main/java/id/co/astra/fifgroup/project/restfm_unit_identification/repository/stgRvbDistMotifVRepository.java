package id.co.astra.fifgroup.project.restfm_unit_identification.repository;

import id.co.astra.fifgroup.project.restfm_unit_identification.entity.stgRvbDistMotifV;
import javafx.embed.swing.JFXPanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface stgRvbDistMotifVRepository extends JpaRepository<stgRvbDistMotifV, String> {
}
