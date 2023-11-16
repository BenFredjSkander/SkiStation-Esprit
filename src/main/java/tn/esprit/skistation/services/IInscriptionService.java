package tn.esprit.skistation.services;

import tn.esprit.skistation.domain.Inscription;

/**
 * @author Skander Ben Fredj
 * @created 15-Nov-23
 * @project SkiStation
 */

public interface IInscriptionService {
    Inscription addRegistrationAndAssignToSkier(Inscription inscription, Long numSkier);

    Inscription assignRegistrationToCourse(Long numInscription, Long numCourse);

}
