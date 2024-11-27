package com.equipo10.proyectotech.servicios;

import com.equipo10.proyectotech.repositorios.IComentarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.equipo10.proyectotech.entidades.Comentario;

@Service
@RequiredArgsConstructor
public class ComentarioServicio {

    private final IComentarioRepositorio comentarioRepositorio;

    public void save(Comentario comentario) {
        comentarioRepositorio.save(comentario);
    }

    public Comentario findById(Long id) {
        return comentarioRepositorio.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Comentario no encontrado"));
    }

    public void delete(Long id) {
        var optionalComentario= comentarioRepositorio.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Comentario no encontrado"));
        comentarioRepositorio.delete(optionalComentario);
    }



    public void update(Comentario comentario) {
        if (comentario == null || comentario.getId() == null) {
            throw new IllegalArgumentException("El comentario o su ID no puede ser nulo");
        }
        Comentario comentarioExistente = comentarioRepositorio.findById(comentario.getId())
                .orElseThrow(() -> new IllegalArgumentException("Comentario no encontrado"));
        comentarioExistente.setComentario(comentario.getComentario());
        comentarioRepositorio.save(comentarioExistente);
    }
}
