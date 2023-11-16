package tn.esprit.skistation.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.domain.Cours;
import tn.esprit.skistation.repositories.CoursRepository;
import tn.esprit.skistation.services.ICoursService;

import java.util.List;

/**
 * @author Skander Ben Fredj
 * @created 24-Oct-23
 * @project SkiStation
 */

@Service
@AllArgsConstructor
public class CoursService implements ICoursService {
    private final CoursRepository coursRepository;

    @Override
    public List<Cours> retrieveAllCourses() {
        return coursRepository.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {

        return coursRepository.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepository.save(cours);
    }

    @Override
    public Cours retrieveCours(Long numCours) {
        return coursRepository.findById(numCours).orElseThrow(NullPointerException::new);
    }
}
