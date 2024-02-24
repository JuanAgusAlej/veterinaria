package org.example.veterinaria.repository;

import org.example.veterinaria.model.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VeterinarioRepository extends JpaRepository <Veterinario, Long> {


    Optional<Veterinario> findByMatricula(String matricula);

}
