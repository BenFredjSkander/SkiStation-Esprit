package tn.esprit.skistation.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.domain.*;
import tn.esprit.skistation.domain.enums.TypeAbonnement;
import tn.esprit.skistation.repositories.CoursRepository;
import tn.esprit.skistation.repositories.PisteRepository;
import tn.esprit.skistation.repositories.SkieurRepository;
import tn.esprit.skistation.services.ISkieurService;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Skander Ben Fredj
 * @created 24-Oct-23
 * @project SkiStation
 */

@Service
@RequiredArgsConstructor
public class SkieurService implements ISkieurService {

    private final SkieurRepository skieurRepository;
    private final PisteRepository pisteRepository;
    private final CoursRepository coursRepository;


    @Override
    public List<Skieur> retrieveAllSkieurs() {
        return skieurRepository.findAll();
    }

    @Override
    public Skieur addSkieur(Skieur skieur) {
        Abonnement abonnement = new Abonnement();
        abonnement.setDateDebut(LocalDate.now());
        abonnement.setDateFin(LocalDate.now().plusMonths(3));
        abonnement.setTypeAbonnement(TypeAbonnement.SEMESTRIEL);
        abonnement.setPrixAbonnement(45.0F);
        skieur.setAbonnement(abonnement);
        return skieurRepository.save(skieur);
    }

    @Override
    public void removeSkieur(Long numSkieur) {
        skieurRepository.deleteById(numSkieur);
    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepository.findById(numSkieur).orElseThrow(NullPointerException::new);
    }

    @Override
    public Skieur assignSkierToPiste(Long numSkieur, Long numPiste) {
        Piste piste = pisteRepository.findById(numPiste).orElseThrow(NullPointerException::new);
        Skieur skieur = skieurRepository.findById(numSkieur).orElseThrow(NullPointerException::new);
        skieur.getPistes().add(piste);
        return skieurRepository.save(skieur);
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur skieur, Long numCourse) {
        Cours cours = coursRepository.findById(numCourse).orElseThrow(NullPointerException::new);

        Inscription inscription = new Inscription();
        inscription.setNumSemaine(5);
        inscription.setCours(cours);
        skieur.getInscriptions().add(inscription);
        return skieurRepository.save(skieur);
    }

    @Override
    public List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement) {
        return skieurRepository.findAllByAbonnement_TypeAbonnement(typeAbonnement);
    }
}
