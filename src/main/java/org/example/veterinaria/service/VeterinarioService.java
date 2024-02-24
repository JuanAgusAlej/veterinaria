package org.example.veterinaria.service;

import lombok.AllArgsConstructor;
import org.example.veterinaria.model.Veterinario;
import org.example.veterinaria.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VeterinarioService {

    private VeterinarioRepository veterinarioRepository;

    public Veterinario obtenerVeterinarioPorId (Long id){

        return veterinarioRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro el vete"));
    };
    public List<Veterinario> lisarVeterinario (){
      return veterinarioRepository.findAll();
    };

    public  Veterinario guardarVeterinario (Veterinario veterinario){
        return veterinarioRepository.save(veterinario);
    }
}
