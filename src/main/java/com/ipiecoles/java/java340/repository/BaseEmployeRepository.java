package com.ipiecoles.java.java340.repository;

import com.ipiecoles.java.java340.model.Employe;
import org.joda.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BaseEmployeRepository<T extends Employe> extends PagingAndSortingRepository<T, Long> {
    T findByMatricule(String matricule);

    List<T> findByNomAndPrenom(String nom, String prenom);

    @Query("select e from #{#entityName} e where lower(e.prenom) = lower(:nomOuPrenom) or lower(e.nom) = lower(:nomOuPrenom)")
    List<T> findByNomOrPrenomAllIgnoreCase(@Param("nomOuPrenom") String nomOuPrenom);

    List<T> findByNomIgnoreCase(String nom);

    Page<T> findByNomIgnoreCase(String nom, Pageable pageable);

    List<T> findByDateEmbaucheBefore(LocalDate date);

    List<T> findByDateEmbaucheAfter(LocalDate date);

    List<T> findBySalaireGreaterThanOrderBySalaireDesc(Double salaire);

    @Query(value = "SELECT * FROM Employe WHERE salaire > (SELECT avg(e2.salaire) FROM Employe e2)", nativeQuery = true)
    List<T> findEmployePlusRiches();
}
