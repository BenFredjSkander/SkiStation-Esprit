package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tn.esprit.skistation.domain.Inscription;
import tn.esprit.skistation.domain.enums.Support;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
}