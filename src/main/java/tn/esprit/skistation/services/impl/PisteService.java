package tn.esprit.skistation.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.domain.Piste;
import tn.esprit.skistation.repositories.PisteRepository;
import tn.esprit.skistation.services.IPisteService;

import java.util.List;

/**
 * @author Skander Ben Fredj
 * @created 16-Nov-23
 * @project SkiStation
 */

@Service
@AllArgsConstructor
public class PisteService implements IPisteService {

    private final PisteRepository pisteRepository;

    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepository.findAll();
    }

    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepository.save(piste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepository.findById(numPiste).orElseThrow(NullPointerException::new);
    }
}
