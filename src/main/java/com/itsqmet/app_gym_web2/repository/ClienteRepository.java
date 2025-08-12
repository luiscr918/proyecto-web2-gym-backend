package com.itsqmet.app_gym_web2.repository;

import com.itsqmet.app_gym_web2.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {
    //validar si ya existe un cliente por cedula
    List<Cliente> findByCedula(String cedula);
}
