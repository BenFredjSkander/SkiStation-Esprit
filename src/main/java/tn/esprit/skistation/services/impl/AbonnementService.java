package tn.esprit.skistation.services.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.skistation.domain.Abonnement;
import tn.esprit.skistation.domain.enums.TypeAbonnement;
import tn.esprit.skistation.repositories.AbonnementRepository;
import tn.esprit.skistation.services.IAbonnementService;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * @author Skander Ben Fredj
 * @created 16-Nov-23
 * @project SkiStation
 */

@Service
@AllArgsConstructor
public class AbonnementService implements IAbonnementService {

    private final AbonnementRepository abonnementRepository;

    @Override
    public Set<Abonnement> getSubscriptionByType(TypeAbonnement type) {
        return abonnementRepository.findAllByTypeAbonnementOrderByDateDebut(type);
    }

    @Override
    public List<Abonnement> retrieveSubscriptionsByDates(LocalDate startDate, LocalDate endDate) {
        return abonnementRepository.findAllByDateDebutBetween(startDate, endDate);
    }
}
