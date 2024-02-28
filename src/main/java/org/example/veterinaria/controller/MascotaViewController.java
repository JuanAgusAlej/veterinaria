package org.example.veterinaria.controller;

import lombok.AllArgsConstructor;
import org.example.veterinaria.model.Mascota;
import org.example.veterinaria.model.Veterinario;
import org.example.veterinaria.service.MascotaService;
import org.example.veterinaria.service.VacunaService;
import org.example.veterinaria.service.VeterinarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
public class MascotaViewController {

    private final MascotaService mascotaService;
    private final VeterinarioService veterinarioService;
    private final VacunaService vacunaService;

    @GetMapping("/mascotas")
    public String listarMascotas(Model model){
        List<Mascota> mascotas = mascotaService.listarMascotas();
        model.addAttribute("mascota", mascotas);
        return "listaMascotas";
    }

    @GetMapping("/agregarMascota")
    public String mostrarFormularioAgregarMascota(Model model){
        model.addAttribute("veterinarios",veterinarioService.lisarVeterinario());
        model.addAttribute("vacunas",vacunaService.listarVacunas());
        model.addAttribute("mascota", new Mascota());
        return "agregarMascota";
    }

    @PostMapping("/guardarMascota")
    public String guardarMascota(@ModelAttribute Mascota mascota, @RequestParam Long idVeterinario, @RequestParam List<Long> idVacunas){
        mascotaService.guardarMascota(mascota,idVeterinario,idVacunas);
        return "redirect:/mascotas";
    }

    @GetMapping("/actualizaMascota/{id}")
    public String mostrarFormularioActualizarMascota(@PathVariable Long id,Model model){
        Mascota mascota = mascotaService.obtenerMascotaPorId(id);
        model.addAttribute("mascota",mascota);
        model.addAttribute("veterinarios",veterinarioService.lisarVeterinario());
        model.addAttribute("vacunas",vacunaService.listarVacunas());

        return "actualizarMascota";
    }

    @PostMapping("/actualizaMascota/{id}")
    public String actualizarMascota(@PathVariable Long id, @ModelAttribute Mascota mascotaActualizada, @RequestParam Long idVeterinario, @RequestParam List<Long> idVacunas){
        mascotaService.actualizarMascota(id,mascotaActualizada,idVeterinario,idVacunas);
        return "redirect:/mascotas";
    }


}
