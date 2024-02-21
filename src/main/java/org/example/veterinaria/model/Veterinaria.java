package org.example.veterinaria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data //agrega todos los getter, setter, toString, equals, hascode
@NoArgsConstructor // constructor sin argumento
@AllArgsConstructor //contructor con todos los argumentos
public class Veterinaria {


    private String name;
    private String matricula;
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany (mappedBy = "veterinario")
    private List<Mascota> mascotasAtendidas;

}
