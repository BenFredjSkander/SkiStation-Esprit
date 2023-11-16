package tn.esprit.skistation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "inscription")
public class Inscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long numInscription;

    private int numSemaine;

    @ManyToOne
    @JoinColumn(name = "skieur_id")
    private Skieur skieur;

    @ManyToOne
    @JoinColumn(name = "cours_id")
    private Cours cours;

}