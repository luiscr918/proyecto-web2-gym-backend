package com.itsqmet.app_gym_web2.controller;

import com.itsqmet.app_gym_web2.entity.Suscripcion;
import com.itsqmet.app_gym_web2.entity.Suscripcion;
import com.itsqmet.app_gym_web2.service.SuscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/suscripciones")
public class SuscripcionController {
    @Autowired
    private SuscripcionService suscripcionService;

    //leer todos las suscripciones
    @GetMapping("/leer")
    public List<Suscripcion> mostrarSuscripcion() {
        return suscripcionService.allSuscripciones();
    }

    //guardar nuevo suscripcion
    @PostMapping("/guardar")
    public Suscripcion guardarSuscripcion(@RequestBody Suscripcion suscripcion) {
        return suscripcionService.guardarSuscripcion(suscripcion);
    }
    //Buscar Suscripcion por id
    @PostMapping("buscar/{id}")
    public Optional<Suscripcion> buscarSuscripcionId(@PathVariable Long id){
        return suscripcionService.buscarSuscripcionId(id);
    }
    //actualizar suscripcion
    @PutMapping("/actualizar/{id}")
    public Suscripcion actualizarSuscripcion(@PathVariable Long id, @RequestBody Suscripcion suscripcion) {
        Optional<Suscripcion> suscripcionOptional = suscripcionService.buscarSuscripcionId(id);
        if (suscripcionOptional.isPresent()) {
            Suscripcion suscripcionExistente = suscripcionOptional.get();
            suscripcionExistente.setPlan(suscripcion.getPlan());
            suscripcionExistente.setFechaInicio(suscripcion.getFechaInicio());
            suscripcionExistente.setFechaFin(suscripcion.getFechaFin());
            return suscripcionService.guardarSuscripcion(suscripcionExistente);
        }
        return null;
    }

    //eliminar suscripcion
    @DeleteMapping("/eliminar/{id}")
    public void eliminarSuscripcion(@PathVariable Long id) {
        suscripcionService.eliminarSuscripcion(id);
    }
}
