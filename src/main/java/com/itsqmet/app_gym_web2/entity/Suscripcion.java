package com.itsqmet.app_gym_web2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Suscripcion {
    //Relacion
    //relacion con cliente
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //plan
    @NotNull
    private String plan;
    //fecha de inicio
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;
    //fecha de fin
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaFin;
}
