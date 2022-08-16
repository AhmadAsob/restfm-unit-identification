package id.co.astra.fifgroup.project.restfm_unit_identification.repository;


import id.co.astra.fifgroup.project.restfm_unit_identification.entity.mstNpwpKpp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/*
 * Author : Ahmad Shobari
 */

@Repository
@Transactional
public interface MstNpwpKppRepo extends JpaRepository<mstNpwpKpp, String> {
}