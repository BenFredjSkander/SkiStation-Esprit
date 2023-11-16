package tn.esprit.skistation.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.skistation.domain.Piste;
import tn.esprit.skistation.services.IPisteService;

import java.util.List;

/**
 * @author Skander Ben Fredj
 * @created 16-Nov-23
 * @project SkiStation
 */

@RequestMapping("/piste")
@RestController
@AllArgsConstructor
@Tag(name = "Piste",
        description = "Manage pistes")
public class PisteController {
    private final IPisteService pisteService;


    @GetMapping
    @Operation(summary = "Get All pistes")
    public List<Piste> getAll() {
        return pisteService.retrieveAllPistes();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get piste by id")
    public Piste findById(@PathVariable(name = "id") long id) {
        return pisteService.retrievePiste(id);
    }

    @PostMapping
    @Operation(summary = "Create new piste")
    public Piste createPiste(@RequestBody Piste piste) {
        return pisteService.addPiste(piste);
    }

    @PutMapping
    @Operation(summary = "Update given piste")
    public Piste updatePiste(@RequestBody Piste piste) {
        return pisteService.updatePiste(piste);
    }

}
