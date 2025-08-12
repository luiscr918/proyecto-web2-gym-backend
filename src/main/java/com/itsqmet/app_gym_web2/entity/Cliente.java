package com.itsqmet.app_gym_web2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Cliente extends Usuario {
    //relaciones
    //relacion con la suscripción
    @OneToMany(mappedBy = "cliente",fetch = FetchType.LAZY)
    private List<Suscripcion> suscripciones;
    //atributos
    //fechaNacimiento
    @NotNull
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date fechaNacimiento;
    //genero
    @NotBlank
    private String genero;
    //cedula
    @NotBlank
    @Column(unique = true)
    @Size(min = 10)
    private String cedula;
    //telefono
    @NotBlank
    @Size(min = 10)
    private String telefono;
    //direccion
    @NotBlank
    private String direccion;
    //peso
    @Positive
    private Double peso;
    //altura
    @Positive
    private Double altura;
    //IMC
    @PositiveOrZero
    private Double imc;
}
