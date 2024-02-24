package org.example.veterinaria.repository;

import org.example.veterinaria.model.Vacuna;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VacunaRepository extends JpaRepository <Vacuna,Long> {
}
