package tn.esprit.skistation.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.domain.Cours;
import tn.esprit.skistation.domain.Inscription;
import tn.esprit.skistation.domain.Skieur;
import tn.esprit.skistation.domain.enums.TypeCours;
import tn.esprit.skistation.repositories.CoursRepository;
import tn.esprit.skistation.repositories.InscriptionRepository;
import tn.esprit.skistation.repositories.SkieurRepository;
import tn.esprit.skistation.services.IInscriptionService;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

/**
 * @author Skander Ben Fredj
 * @created 15-Nov-23
 * @project SkiStation
 */

@Service
@AllArgsConstructor
public class InscriptionService implements IInscriptionService {
    private final InscriptionRepository inscriptionRepository;
    private final SkieurRepository skieurRepository;
    private final CoursRepository coursRepository;

    @Override
    public Inscription addRegistrationAndAssignToSkier(Inscription inscription, Long numSkier) {

        Skieur skieur = skieurRepository.findById(numSkier).orElseThrow(NullPointerException::new);
        inscription.setSkieur(skieur);
        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription assignRegistrationToCourse(Long numInscription, Long numCourse) {
        Cours cours = coursRepository.findById(numCourse).orElseThrow(NullPointerException::new);
        Inscription inscription = inscriptionRepository.findById(numInscription).orElseThrow(NullPointerException::new);
        inscription.setCours(cours);

        return inscriptionRepository.save(inscription);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {
        Cours cours = coursRepository.findById(numCours).orElseThrow(NullPointerException::new);
        if (Arrays.asList(TypeCours.COLLECTIF_ADULTE, TypeCours.COLLECTIF_ENFANT).contains(cours.getTypeCours()) && cours.getInscriptions().size() >= 6) {
            throw new IllegalArgumentException("Impossible d'ajouter une inscription a ce cours");
        }
        Skieur skieur = skieurRepository.findById(numSkieur).orElseThrow(NullPointerException::new);
        if (getUserAge(skieur.getDateNaissance()) < 18 && cours.getTypeCours() == TypeCours.COLLECTIF_ADULTE
                || getUserAge(skieur.getDateNaissance()) > 18 && cours.getTypeCours() == TypeCours.COLLECTIF_ENFANT) {
            throw new IllegalArgumentException("L'age du skieur ne correspond pas au type d'abonnement choisi");
        }

        inscription.setSkieur(skieur);
        inscription.setCours(cours);

        return inscriptionRepository.save(inscription);
    }

    private long getUserAge(LocalDate birthDate) {
        return ChronoUnit.YEARS.between(birthDate, LocalDate.now());
    }

}
