package tn.enig.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.enig.model.Materiel;
@Repository
public interface IMateriel extends JpaRepository<Materiel, Integer> {

}
