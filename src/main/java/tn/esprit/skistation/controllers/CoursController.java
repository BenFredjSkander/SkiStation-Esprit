package tn.esprit.skistation.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.domain.Cours;
import tn.esprit.skistation.services.ICoursService;

import java.util.List;

/**
 * @author Skander Ben Fredj
 * @created 16-Nov-23
 * @project SkiStation
 */

@RestController
@RequestMapping(value = "/cours", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
@Tag(name = "Cours",
        description = "Manage cours")
public class CoursController {
    private final ICoursService coursService;

    @GetMapping
    @Operation(summary = "Get all cours")
    public List<Cours> getAll() {
        return coursService.retrieveAllCourses();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get cours by id")
    public Cours getById(@PathVariable long id) {
        return coursService.retrieveCours(id);
    }

    @PostMapping
    @Operation(summary = "Create new cours")
    public Cours createCours(@RequestBody Cours cours) {
        return coursService.addCours(cours);
    }

    @PutMapping
    @Operation(summary = "Update given cours")
    public Cours updateCours(@RequestBody Cours cours) {
        return coursService.updateCours(cours);
    }
}
