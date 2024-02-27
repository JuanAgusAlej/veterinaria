package org.example.veterinaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vacuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "El nombre no puede estar vacio")
    private String name;
    @NotNull(message = "La fecha de nacimiento no puede ser null")

    private LocalDate fechaVencimiento;

    @ManyToMany(mappedBy = "vacunasAplicadas", fetch = FetchType.EAGER)
    private List<Mascota> mascotas = new ArrayList<>();

}
