package com.equipo10.proyectotech.entidades;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity (name = "Usuario")
@Table(name = "Usuarios")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String password;

    private Rol rol;

}
