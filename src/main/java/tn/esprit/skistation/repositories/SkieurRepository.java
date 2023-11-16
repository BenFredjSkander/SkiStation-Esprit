package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.skistation.domain.Skieur;
import tn.esprit.skistation.domain.enums.TypeAbonnement;

import java.util.List;

public interface SkieurRepository extends JpaRepository<Skieur, Long> {
    List<Skieur> findAllByAbonnement_TypeAbonnement(TypeAbonnement abonnement_typeAbonnement);
}