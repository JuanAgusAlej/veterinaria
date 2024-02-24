package org.example.veterinaria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String name;
    private String especie;
    private String sexo;
    private LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    private Veterinario veterinario;

    @ManyToMany
    @JoinTable(name = "Mascota_Vacuna",
            joinColumns = @JoinColumn(name = "mascota_id"),
            inverseJoinColumns =@JoinColumn(name="vacuna_id"))
    private List<Vacuna> vacunasAplicadas = new ArrayList<>();
}
