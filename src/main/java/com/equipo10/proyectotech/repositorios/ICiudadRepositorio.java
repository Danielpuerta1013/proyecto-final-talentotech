package com.equipo10.proyectotech.repositorios;

import com.equipo10.proyectotech.entidades.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICiudadRepositorio extends JpaRepository<Ciudad, Long> {
}
