package tn.esprit.skistation.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "skieur")
public class Skieur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long numSkieur;

    private String nomSkieur;

    private String prenomSkieur;

    private LocalDate dateNaissance;

    private String ville;


    @ManyToMany(mappedBy = "skieurs")
    private Set<Piste> pistes = new LinkedHashSet<>();

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "abonnement_id", nullable = false)
    private Abonnement abonnement;

    @OneToMany(mappedBy = "skieur", orphanRemoval = true)
    private Set<Inscription> inscriptions = new LinkedHashSet<>();

}