package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.skistation.domain.Piste;

public interface PisteRepository extends JpaRepository<Piste, Long> {
}