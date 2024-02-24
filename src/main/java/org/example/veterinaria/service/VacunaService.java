package org.example.veterinaria.service;

import lombok.AllArgsConstructor;
import org.example.veterinaria.model.Vacuna;
import org.example.veterinaria.repository.VacunaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VacunaService {

    private VacunaRepository vacunaRepository;

    public List<Vacuna> listarVacunas (){
        return vacunaRepository.findAll();
    }

    public Vacuna guardarVacuna (Vacuna vacuna){
      return vacunaRepository.save(vacuna);
    };

    public Vacuna obtenerVacunaPorId (Long id){
        return vacunaRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro Vacuna Id:"+id) );
    }

    public  void eliminarVacuna (Long id){
        vacunaRepository.deleteById(id);
    }

}
