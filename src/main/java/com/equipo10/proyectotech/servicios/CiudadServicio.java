package com.equipo10.proyectotech.servicios;

import com.equipo10.proyectotech.entidades.Ciudad;
import com.equipo10.proyectotech.repositorios.ICiudadRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CiudadServicio {
    private final ICiudadRepositorio ciudadRepositorio;

    public List<Ciudad> getAll() {
        return ciudadRepositorio.findAll();
    }

    public Ciudad getById(Long id) {
        var ciudad = ciudadRepositorio.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Ciudad no encontrada"));
        return ciudad;
    }

    public void create(Ciudad ciudad) {
        ciudadRepositorio.save(ciudad);
    }


}
