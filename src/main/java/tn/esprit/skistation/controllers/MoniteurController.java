package tn.esprit.skistation.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.domain.Moniteur;
import tn.esprit.skistation.services.impl.MoniteurService;

import java.util.List;

/**
 * @author Skander Ben Fredj
 * @created 16-Nov-23
 * @project SkiStation
 */

@RestController
@RequestMapping(value = "/moniteur", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "Moniteur", description = "Manage moniteur")
public class MoniteurController {
    private final MoniteurService moniteurService;

    @GetMapping
    @Operation(summary = "Get all Moniteur")
    private List<Moniteur> getAllMoniteurs() {
        return moniteurService.retrieveAllMoniteurs();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get moniteur by id")
    private Moniteur getMoniteurById(@PathVariable long id) {
        return moniteurService.retrieveMoniteur(id);
    }

    @PostMapping
    @Operation(summary = "Create new moniteur")
    private Moniteur createMoniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.addMoniteur(moniteur);
    }

    @PutMapping
    @Operation(summary = "Update given moniteur")
    private Moniteur updateMOniteur(@RequestBody Moniteur moniteur) {
        return moniteurService.updateMoniteur(moniteur);
    }

}
