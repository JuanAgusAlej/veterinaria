package org.example.veterinaria.controller;

import lombok.AllArgsConstructor;
import org.example.veterinaria.model.Vacuna;
import org.example.veterinaria.service.VacunaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class VacunaViewController {

    private final VacunaService vacunaService;

    @GetMapping("/")
    public String redirecionarPaginaPrincipal(){
        return "redirect:/mascotas";
    }
    @GetMapping("/vacunas")
    public String listarMascotas(Model model){

        List<Vacuna> vacunas = vacunaService.listarVacunas();
        model.addAttribute("vacunas",vacunas);
        return "vacunas";
    }

    @GetMapping("/agregarVacuna")
    public String formularioNuevaVacuna(Model model){
        model.addAttribute("vacuna", new Vacuna());
        return "agregarVacuna";

    }

    @PostMapping("/guardarVacuna")
    public String guardarVacuna(@ModelAttribute Vacuna vacuna){

        vacunaService.guardarVacuna(vacuna);
        return "redirect:/vacunas";
    }


}
