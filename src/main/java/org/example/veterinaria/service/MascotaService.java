package org.example.veterinaria.service;

import lombok.AllArgsConstructor;
import org.example.veterinaria.model.Mascota;
import org.example.veterinaria.model.Veterinario;
import org.example.veterinaria.repository.MascotaRepository;
import org.example.veterinaria.repository.VacunaRepository;
import org.example.veterinaria.repository.VeterinarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MascotaService {

    private MascotaRepository mascotaRepository;
    private VeterinarioRepository veterinarioRepository;
    private VacunaRepository vacunaRepository;

    public Mascota obtenerMascotaPorId ( Long id){
        return mascotaRepository.findById(id).orElseThrow(()-> new RuntimeException("No se encontro la mascota Id: "+id));
    }

    public List<Mascota> listarMascotas (){
        return  mascotaRepository.findAllByOrderByNameIgnoreCaseAsc();
    }

    public Mascota guardarMascota( Mascota mascota, Long veterinario_id, List<Long> idVacunas){
        Veterinario veterinario = veterinarioRepository.findById(veterinario_id).orElseThrow(()-> new RuntimeException("no se encontro veterinario Id: "+ veterinario_id));
        mascota.setVeterinario(veterinario);
        if(idVacunas!=null){
            mascota.setVacunasAplicadas(vacunaRepository.findAllById(idVacunas));
        }
        return mascotaRepository.save(mascota);
    }

}
