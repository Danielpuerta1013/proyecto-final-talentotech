package com.equipo10.proyectotech.entidades;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long id;

    @Column(name = "nombre_usuario", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellido_usuario", nullable = false, length = 50)
    private String apellido;

    @Column(name = "email_usuario", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "password_usuario", nullable = false)
    private String password;

    @Enumerated(EnumType.STRING) // Usamos STRING para almacenar el nombre del enum como texto
    @Column(name = "rol_usuario", nullable = false)
    private Rol rol;


}
