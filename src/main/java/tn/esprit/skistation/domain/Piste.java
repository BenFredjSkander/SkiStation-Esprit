package tn.esprit.skistation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import tn.esprit.skistation.domain.enums.Couleur;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "piste")
public class Piste {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long numPiste;

    private String nomPiste;

    @Enumerated(EnumType.STRING)
    private Couleur couleur;

    private int longeur;

    private int pente;

    @ManyToMany
    @JoinTable(name = "piste_skieur",
            joinColumns = @JoinColumn(name = "piste_id"),
            inverseJoinColumns = @JoinColumn(name = "skieur_id"))
    private Set<Skieur> skieurs = new LinkedHashSet<>();

}