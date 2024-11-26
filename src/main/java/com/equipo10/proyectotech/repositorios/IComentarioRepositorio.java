package com.equipo10.proyectotech.repositorios;

import com.equipo10.proyectotech.entidades.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IComentarioRepositorio extends JpaRepository<Comentario, Long> {

}
