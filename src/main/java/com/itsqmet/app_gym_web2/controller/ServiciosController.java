package com.itsqmet.app_gym_web2.controller;

import com.itsqmet.app_gym_web2.entity.Servicios;
import com.itsqmet.app_gym_web2.service.ServiciosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servicios")
public class ServiciosController {
    @Autowired
    private ServiciosService serviciosService;

    //leer todos los servicios
    @GetMapping("/leer")
    public List<Servicios> mostrarServicios() {
        return serviciosService.allServicios();
    }

    //guardar nuevo servicio
    @PostMapping("/guardar")
    public Servicios guardarServicio(@RequestBody Servicios servicio) {
        return serviciosService.guardarServicio(servicio);
    }

    //buscar por servicio con id
    @GetMapping("/buscar/{id}")
    public Optional<Servicios> buscarServicioId(@PathVariable Long id) {
        return serviciosService.buscarServicioId(id);
    }

    //actualizar servicio
    @PutMapping("/actualizar/{id}")
    public Servicios actualizarServicio(@PathVariable Long id, @RequestBody Servicios servicio) {
        Optional<Servicios> serviciosOptional = serviciosService.buscarServicioId(id);
        if (serviciosOptional.isPresent()) {
            Servicios servicioExistente = serviciosOptional.get();
            servicioExistente.setNombre(servicio.getNombre());
            servicioExistente.setDescripcion(servicio.getDescripcion());
            servicioExistente.setImagenURL(servicio.getImagenURL());
            return serviciosService.guardarServicio(servicioExistente);

        }
        return null;
    }

    //eliminar servicio
    @DeleteMapping("/eliminar/{id}")
    public void eliminarServicio(@PathVariable Long id) {
        serviciosService.eliminarServicio(id);
    }

}
