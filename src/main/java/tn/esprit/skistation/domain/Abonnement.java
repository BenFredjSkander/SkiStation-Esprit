package tn.esprit.skistation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tn.esprit.skistation.domain.enums.TypeAbonnement;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "abonnement")
public class Abonnement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long numAbonnement;

    private LocalDate dateDebut;
    private LocalDate dateFin;

    private Float prixAbonnement;

    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbonnement;
}