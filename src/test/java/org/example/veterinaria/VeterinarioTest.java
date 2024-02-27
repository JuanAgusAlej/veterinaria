package org.example.veterinaria;

import lombok.AllArgsConstructor;
import org.example.veterinaria.model.Veterinario;
import org.example.veterinaria.service.VeterinarioService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class VeterinarioTest {

    @Autowired
    private VeterinarioService veterinarioService;

    private Veterinario veterinarioGuardado;

    @BeforeEach
    void setup(){
        Veterinario veterinario = new Veterinario();
        veterinario.setEmail("juan@gmail.com");
        veterinario.setName("Juan");
        veterinario.setMatricula("1234");
        veterinarioGuardado = veterinarioService.guardarVeterinario(veterinario);
    }

    @Test
    void testGuardarVeterianario(){
        assertNotNull(veterinarioGuardado.getId());
        assertEquals("Juan",veterinarioGuardado.getName());
        assertEquals("juan@gmail.com",veterinarioGuardado.getEmail());
        assertEquals("1234",veterinarioGuardado.getMatricula());
    };

    @Test
    void testListarVeterianario(){
        List<Veterinario> veterinarioList = veterinarioService.lisarVeterinario();
        assertFalse(veterinarioList.isEmpty());
    }

    @Test
    void testObtenerVeterinarioPorId(){
        Veterinario veterinario = veterinarioService.obtenerVeterinarioPorId(veterinarioGuardado.getId());
        assertNotNull(veterinario);
        assertEquals(veterinarioGuardado.getId(),veterinario.getId());
    }


}


