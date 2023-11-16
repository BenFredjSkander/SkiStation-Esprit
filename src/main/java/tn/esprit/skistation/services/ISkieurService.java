package tn.esprit.skistation.services;

import tn.esprit.skistation.domain.Skieur;
import tn.esprit.skistation.domain.enums.TypeAbonnement;

import java.util.List;

/**
 * @author Skander Ben Fredj
 * @created 24-Oct-23
 * @project SkiStation
 */

public interface ISkieurService {

    List<Skieur> retrieveAllSkieurs();

    Skieur addSkieur(Skieur skieur);

    void removeSkieur(Long numSkieur);

    Skieur retrieveSkieur(Long numSkieur);

    Skieur assignSkierToPiste(Long numSkieur, Long numPiste);

    Skieur addSkierAndAssignToCourse(Skieur skier, Long numCourse);

    List<Skieur> retrieveSkiersBySubscriptionType(TypeAbonnement typeAbonnement);
}
