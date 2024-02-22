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
@NoArgsConstructor
@AllArgsConstructor
public class Vacuna {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate fechaVencimiento;

    @ManyToMany(mappedBy = "vacunasAplicadas", fetch = FetchType.EAGER)
    private List<Mascota> mascotas = new ArrayList<>();

}
