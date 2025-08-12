package com.itsqmet.app_gym_web2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Servicios {

    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //nombre
    @NotBlank
    private String nombre;
    //descripción
    @NotBlank
    private String descripción;
    //urlImagen
    @NotBlank
    private String imagenURL;
}
