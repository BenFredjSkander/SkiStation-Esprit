package tn.esprit.skistation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tn.esprit.skistation.domain.enums.Support;
import tn.esprit.skistation.domain.enums.TypeCours;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "cours")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long numCours;

    private int niveau;
    @Enumerated(EnumType.STRING)
    private TypeCours typeCours;

    @Enumerated(EnumType.STRING)
    private Support support;

    private Float prix;
    private int creneau;

    @OneToMany(mappedBy = "cours", orphanRemoval = true)
    private Set<Inscription> inscriptions = new LinkedHashSet<>();

}