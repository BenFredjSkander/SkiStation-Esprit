package tn.esprit.skistation.services.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.domain.Cours;
import tn.esprit.skistation.domain.Moniteur;
import tn.esprit.skistation.repositories.CoursRepository;
import tn.esprit.skistation.repositories.MoniteurRepository;
import tn.esprit.skistation.services.IMoniteurService;

import java.util.List;

/**
 * @author Skander Ben Fredj
 * @created 24-Oct-23
 * @project SkiStation
 */

@Service
@RequiredArgsConstructor
public class MoniteurService implements IMoniteurService {

    private final MoniteurRepository moniteurRepository;
    private final CoursRepository coursRepository;

    @Override
    public List<Moniteur> retrieveAllMoniteurs() {
        return moniteurRepository.findAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepository.save(moniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepository.findById(numMoniteur).orElseThrow(() -> new NullPointerException("moniteur not found"));
    }

    @Override
    public Moniteur addInstructorAndAssignToCourse(Moniteur moniteur, Long numCourse) {
        Cours cours = coursRepository.findById(numCourse).orElseThrow(NullPointerException::new);
        moniteur.getCourses().add(cours);


        return moniteurRepository.save(moniteur);
    }
}
