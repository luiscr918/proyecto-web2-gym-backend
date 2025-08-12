package com.itsqmet.app_gym_web2.service;

import com.itsqmet.app_gym_web2.entity.Suscripcion;
import com.itsqmet.app_gym_web2.repository.SuscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SuscripcionService {
    @Autowired
    private SuscripcionRepository suscripcionRepository;

    //Lista de suscripciones
    public List<Suscripcion> allSuscripciones() {
        return suscripcionRepository.findAll();
    }

    //buscar por id(para actualizar y eliminar)
    public Optional<Suscripcion> buscarSuscripcionId(Long id) {
        return suscripcionRepository.findById(id);
    }

    //Guardar Suscripcion
    public Suscripcion guardarSuscripcion(Suscripcion suscripcion) {
        return suscripcionRepository.save(suscripcion);
    }

    //Eliminar Suscripcion
    public void eliminarSuscripcion(Long id) {
        suscripcionRepository.deleteById(id);
    }
}
