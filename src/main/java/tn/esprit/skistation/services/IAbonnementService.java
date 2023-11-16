package tn.esprit.skistation.services;

import tn.esprit.skistation.domain.Abonnement;
import tn.esprit.skistation.domain.enums.TypeAbonnement;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * @author Skander Ben Fredj
 * @created 16-Nov-23
 * @project SkiStation
 */

public interface IAbonnementService {
    Set<Abonnement> getSubscriptionByType(TypeAbonnement type);

    List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate);
}
