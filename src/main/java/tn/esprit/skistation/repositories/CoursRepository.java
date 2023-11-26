package tn.esprit.skistation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.skistation.domain.Cours;
import tn.esprit.skistation.domain.enums.Support;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours, Long> {

    //    @Query("select i.numSemaine from Inscription i join Cours c on i.cours = c join Moniteur m on c member of m.courses where i.cours.support =:support and m.numMoniteur=:numInstructor ")
    //correcte
    @Query("select i.numSemaine from Inscription  i join Moniteur m on i.cours member of m.courses where i.cours.support=:support and m.numMoniteur=:numInstructor")
    List<Integer> numWeeksCourseOfInstructorBySupport(@Param("numInstructor") Long numInstructor, @Param("support") Support support);


}