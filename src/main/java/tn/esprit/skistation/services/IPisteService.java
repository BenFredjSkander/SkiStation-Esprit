package tn.esprit.skistation.services;

import tn.esprit.skistation.domain.Piste;

import java.util.List;

/**
 * @author Skander Ben Fredj
 * @created 16-Nov-23
 * @project SkiStation
 */

public interface IPisteService {

    List<Piste> retrieveAllPistes();

    Piste addPiste(Piste piste);

    Piste updatePiste(Piste piste);

    Piste retrievePiste(Long numPiste);

}
