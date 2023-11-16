package tn.esprit.skistation.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.domain.Skieur;
import tn.esprit.skistation.domain.enums.TypeAbonnement;
import tn.esprit.skistation.services.ISkieurService;

import java.util.List;

/**
 * @author Skander Ben Fredj
 * @created 24-Oct-23
 * @project SkiStation
 */

@RestController
@RequestMapping(value = "/skieur", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "Skieur")
public class SkieurController {
    private final ISkieurService skieurService;

    @GetMapping
    @Operation(summary = "Get all skieurs")
    private List<Skieur> getAllSkieur() {
        return skieurService.retrieveAllSkieurs();
    }

    @PostMapping
    @Operation(summary = "Create new skieur")
    private Skieur createSkieur(@RequestBody Skieur skieur) {
        return skieurService.addSkieur(skieur);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete skieur")
    private void deleteSkieur(@PathVariable Long id) {
        skieurService.removeSkieur(id);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get skieur by id")
    private Skieur getSkieur(@PathVariable Long id) {
        return skieurService.retrieveSkieur(id);
    }


    @PutMapping("/{numSkieur}/piste/{numCours}")
    @Operation(summary = "Assign skieur to piste")
    private Skieur assignSkierToPiste(@PathVariable long numCours, @PathVariable long numSkieur) {
        return skieurService.assignSkierToPiste(numSkieur, numCours);
    }

    @PutMapping("/cours/{numCourse}")
    @Operation(summary = "Add skieur and assign to course")
    private Skieur addSkierAndAssignToCourse(@RequestBody Skieur skieur, @PathVariable long numCourse) {
        return skieurService.addSkierAndAssignToCourse(skieur, numCourse);
    }

    @GetMapping("/subscription")
    @Operation(summary = "Get skieurs by subscription type")
    private List<Skieur> retrieveSkiersBySubscriptionType(@RequestParam(name = "type") TypeAbonnement type) {
        return skieurService.retrieveSkiersBySubscriptionType(type);
    }
}
