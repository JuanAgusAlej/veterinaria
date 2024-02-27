package org.example.veterinaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre no puede estar vacio")
    private  String name;
    @NotBlank(message = "La especie no puede estar vacio")
    private String especie;
    @NotBlank(message = "El sexo no puede estar vacio")
    private String sexo;

    @NotNull(message = "La fecha de nacimiento no puede ser null")
    private LocalDate fechaNacimiento;

    @ManyToOne
    @JoinColumn(name = "veterinario_id")
    @NotNull(message = "El veterinario no puede ser null")
    private Veterinario veterinario;

    @ManyToMany
    @JoinTable(name = "Mascota_Vacuna",
            joinColumns = @JoinColumn(name = "mascota_id"),
            inverseJoinColumns =@JoinColumn(name="vacuna_id"))
    private List<Vacuna> vacunasAplicadas = new ArrayList<>();
}
