package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.skistation.domain.Abonnement;
import tn.esprit.skistation.domain.enums.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface AbonnementRepository extends JpaRepository<Abonnement, Long> {

    Set<Abonnement> findAllByTypeAbonnementOrderByDateDebut(TypeAbonnement typeAbonnement);

    List<Abonnement> findAllByDateDebutBetween(LocalDate dateDebut, LocalDate dateDebut2);
}