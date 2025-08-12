package com.itsqmet.app_gym_web2.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//esto es para que las tablas de los hijos de esta clase hereden los campos de la tabla padre osea esta
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
public class Usuario {
    //id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    //nombre
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    //email
    @NotBlank(message = "El correo es obligatorio")
    @Column(unique = true)
    @Email(message = "Ingrese un correo valido")
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "El correo es invalido")
    private String email;
    //password
    @NotBlank(message = "La contraseña es obligatoria")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
            message = "Contraseña no  válida")
    private String password;
    //rol
    private String rol;
}
