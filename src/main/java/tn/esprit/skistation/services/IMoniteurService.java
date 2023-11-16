package tn.esprit.skistation.services;

import tn.esprit.skistation.domain.Moniteur;
import tn.esprit.skistation.domain.enums.TypeCours;

import java.util.List;

/**
 * @author Skander Ben Fredj
 * @created 24-Oct-23
 * @project SkiStation
 */

public interface IMoniteurService {

    List<Moniteur> retrieveAllMoniteurs();

    Moniteur addMoniteur(Moniteur moniteur);

    Moniteur updateMoniteur(Moniteur moniteur);

    Moniteur retrieveMoniteur(Long numMoniteur);

    Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse);

    List<Integer> numWeeksCourseOfInstructorBySupport(Long numInstructor, TypeCours typeCours);
}
