package tn.esprit.skistation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "moniteur")
public class Moniteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long numMoniteur;

    private String nomMoniteur;
    private String prenomMoniteur;
    private LocalDate dateRecrutement;

    @OneToMany
    private Set<Cours> courses = new LinkedHashSet<>();

}