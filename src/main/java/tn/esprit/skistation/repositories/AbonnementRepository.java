package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.skistation.domain.Abonnement;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {
}