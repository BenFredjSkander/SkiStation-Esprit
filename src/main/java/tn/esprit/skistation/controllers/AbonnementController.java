package tn.esprit.skistation.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.skistation.domain.Abonnement;
import tn.esprit.skistation.domain.enums.TypeAbonnement;
import tn.esprit.skistation.services.IAbonnementService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * @author Skander Ben Fredj
 * @created 16-Nov-23
 * @project SkiStation
 */

@RequestMapping("/abonnement")
@RestController
@AllArgsConstructor
@Tag(name = "Abonnement",
        description = "Manage abonnements")
public class AbonnementController {
    private final IAbonnementService abonnementService;

    @GetMapping
    @Operation(summary = "Get subscriptions by type")
    public Set<Abonnement> getSubscriptionByType(@RequestParam(name = "type") TypeAbonnement typeAbonnement) {
        return abonnementService.getSubscriptionByType(typeAbonnement);
    }

    @GetMapping("/date")
    @Operation(summary = "Get subscriptions by start date in range")
    public List<Abonnement> retrieveSubscriptionsByDates(@RequestParam(name = "start") LocalDate startDate, @RequestParam(name = "end") LocalDate endDate) {
        return abonnementService.retrieveSubscriptionsByDates(startDate, endDate);
    }

}
