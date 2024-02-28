package org.example.veterinaria.controller;

import lombok.AllArgsConstructor;
import org.example.veterinaria.model.Veterinario;
import org.example.veterinaria.service.VeterinarioService;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
@AllArgsConstructor
public class VeterinarioViewController {

    private final VeterinarioService veterinarioService;

     @GetMapping("/veterinario")
    public String listarVeterinarios(Model model){
         List<Veterinario> veterinarioList = veterinarioService.lisarVeterinario();
         model.addAttribute("veterinario",veterinarioList);

         return "veterinarios";
     }
     @GetMapping("/agregarVeterinario")
     public  String mostrarFormularioAgregarVeterinario(Model model) {
         model.addAttribute("veterinario", new Veterinario());
         return "agregarVeterinario";
     }

     @PostMapping("/guardarVeterinario")
     public String guardarVeterinario(@ModelAttribute Veterinario veterinario){

         veterinarioService.guardarVeterinario(veterinario);


         return "redirect:/veterinarios";
     }
}
