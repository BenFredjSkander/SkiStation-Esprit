package tn.esprit.skistation.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.domain.Cours;
import tn.esprit.skistation.domain.Inscription;
import tn.esprit.skistation.domain.Skieur;
import tn.esprit.skistation.repositories.CoursRepository;
import tn.esprit.skistation.repositories.InscriptionRepository;
import tn.esprit.skistation.repositories.SkieurRepository;
import tn.esprit.skistation.services.IInscriptionService;

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
    private final CoursService coursService;
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
}
