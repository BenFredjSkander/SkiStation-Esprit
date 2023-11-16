package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.skistation.domain.Inscription;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}