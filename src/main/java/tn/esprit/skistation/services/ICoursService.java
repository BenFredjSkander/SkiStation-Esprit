package tn.esprit.skistation.services;

import tn.esprit.skistation.domain.Cours;

import java.util.List;

/**
 * @author Skander Ben Fredj
 * @created 24-Oct-23
 * @project SkiStation
 */

public interface ICoursService {

    List<Cours> retrieveAllCourses();

    Cours addCours(Cours cours);

    Cours updateCours(Cours cours);

    Cours retrieveCours(Long numCours);
}
