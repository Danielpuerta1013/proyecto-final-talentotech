package com.equipo10.proyectotech.repositorios;

import com.equipo10.proyectotech.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
