package tn.esprit.skistation.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.domain.Inscription;
import tn.esprit.skistation.services.IInscriptionService;

/**
 * @author Skander Ben Fredj
 * @created 16-Nov-23
 * @project SkiStation
 */

@RestController
@RequestMapping(value = "/inscriptions", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "Inscription")
public class InscriptionController {
    private final IInscriptionService inscriptionService;

    @PutMapping("skieurs/{numSkieur}")
    private Inscription addRegistrationAndAssignToSkier(@PathVariable long numSkieur, @RequestBody Inscription inscription) {
        return inscriptionService.addRegistrationAndAssignToSkier(inscription, numSkieur);
    }

    @PutMapping("/{numInscription}/course/{numCourse}")
    private Inscription assignRegistrationToCourse(@PathVariable long numCourse, @PathVariable long numInscription) {
        return inscriptionService.assignRegistrationToCourse(numInscription, numCourse);
    }

    @PutMapping("skieurs/{numSkieur}/course/{numCourse}")
    private Inscription addRegistrationAndAssignToSkierAndCourse(@RequestBody Inscription inscription, @PathVariable long numCourse, @PathVariable long numSkieur) {
        return inscriptionService.addRegistrationAndAssignToSkierAndCourse(inscription, numSkieur, numCourse);
    }
}