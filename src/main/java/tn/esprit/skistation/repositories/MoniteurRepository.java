package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.skistation.domain.Cours;
import tn.esprit.skistation.domain.Moniteur;
import tn.esprit.skistation.domain.enums.TypeCours;

import java.util.List;

public interface MoniteurRepository extends JpaRepository<Moniteur, Long> {
//    List<Moniteur> findByNumMoniteurAndCourses_TypeCours(Long numMoniteur, TypeCours typeCours);
}