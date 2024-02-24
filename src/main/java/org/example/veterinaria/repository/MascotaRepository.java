package org.example.veterinaria.repository;

import org.example.veterinaria.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota,Long> {

    Optional<Mascota> findByName(String nombre);

    @Query("select m from Mascota m order by lower(m.name) asc ")
    List<Mascota> findAllByOrderByNameIgnoreCaseAsc();
}
