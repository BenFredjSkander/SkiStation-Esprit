package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.skistation.domain.Cours;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}