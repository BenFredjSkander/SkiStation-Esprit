package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.skistation.domain.Moniteur;

public interface MoniteurRepository extends JpaRepository<Moniteur, Long> {
}