package com.itsqmet.app_gym_web2.service;

import com.itsqmet.app_gym_web2.entity.Cliente;
import com.itsqmet.app_gym_web2.entity.Servicios;
import com.itsqmet.app_gym_web2.repository.ServicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiciosService {
@Autowired
private ServicioRepository servicioRepository;
    //Lista de servicios
    public List<Servicios> allServicios(){
        return servicioRepository.findAll();
    }

    //buscar por id(para actualizar y eliminar)
    public Optional<Servicios> buscarServicioId(Long id){
        return servicioRepository.findById(id);
    }
    //Guardar Servicio
    public Servicios guardarServicio(Servicios servicio){
        return servicioRepository.save(servicio);
    }
    //Eliminar Servicio
    public void eliminarServicio(Long id){
        servicioRepository.deleteById(id);
    }
}
