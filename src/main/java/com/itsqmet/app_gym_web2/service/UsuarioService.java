package com.itsqmet.app_gym_web2.service;

import com.itsqmet.app_gym_web2.entity.Usuario;
import com.itsqmet.app_gym_web2.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    //validar si ya existe el usuario por correo
    public Optional<Usuario> obtenerporEmailExaxto(String email){
        return usuarioRepository.findByEmail(email);
    }
}
