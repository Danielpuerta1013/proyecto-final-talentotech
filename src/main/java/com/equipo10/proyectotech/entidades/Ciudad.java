package com.equipo10.proyectotech.entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "ciudades")
public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ciudad")
    private Long id;

    @Column(name = "nombre_ciudad", nullable = false, length = 100)
    private String nombre;

    @Column(name = "departamento", nullable = false, length = 100)
    private String departamento;

    @OneToMany(mappedBy = "ciudad", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Emprendimiento> emprendimientos;


}