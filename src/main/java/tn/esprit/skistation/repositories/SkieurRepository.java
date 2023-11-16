package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.skistation.domain.Skieur;

public interface SkieurRepository extends JpaRepository<Skieur, Long> {
}