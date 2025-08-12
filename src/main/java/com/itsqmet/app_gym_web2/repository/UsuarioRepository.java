package com.itsqmet.app_gym_web2.repository;

import com.itsqmet.app_gym_web2.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    //validar si ya existe un usuario por correo o email
    Optional<Usuario> findByEmail(String email);
}
