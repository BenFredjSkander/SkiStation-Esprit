package tn.esprit.skistation.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.domain.Skieur;
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
    private List<Skieur> getAllSkieur() {
        return skieurService.retrieveAllSkieurs();
    }

    @PostMapping
    private Skieur createSkieur(@RequestBody Skieur skieur) {
        return skieurService.addSkieur(skieur);
    }

    @DeleteMapping("/{id}")
    private void deleteSkieur(@RequestParam Long id) {
        skieurService.removeSkieur(id);
    }

    @GetMapping("/{id}")
    private Skieur getSkieur(@RequestParam Long id) {
        return skieurService.retrieveSkieur(id);
    }
}
