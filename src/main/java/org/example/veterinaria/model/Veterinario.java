package org.example.veterinaria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data //agrega todos los getter, setter, toString, equals, hascode
@NoArgsConstructor // constructor sin argumento
@AllArgsConstructor //contructor con todos los argumentos
public class Veterinario {

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String name;
    @NotBlank(message = "La matricula no puede estar en blanco")
    private String matricula;
    @NotBlank(message = "El email no puede estar en blanco")
    @Pattern(regexp = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}", message = "El formato del email no es valido")
    private String email;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany (mappedBy = "veterinario", fetch = FetchType.EAGER)
    private List<Mascota> mascotasAtendidas;

}
