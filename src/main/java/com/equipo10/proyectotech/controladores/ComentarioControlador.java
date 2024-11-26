package com.equipo10.proyectotech.controladores;

import com.equipo10.proyectotech.entidades.Comentario;
import com.equipo10.proyectotech.servicios.ComentarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comentario")
@RequiredArgsConstructor
public class ComentarioControlador {

    private final ComentarioServicio comentarioServicio;


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Comentario comentario) {
       comentarioServicio.save(comentario);
       return ResponseEntity.status(HttpStatus.OK).body("Comentario guardado correctamente");
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            var comentario = comentarioServicio.findById(id);
            return ResponseEntity.ok(comentario);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Comentario no encontrado");
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id) {
        try {
            comentarioServicio.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Comentario eliminado correctamente");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Comentario no eliminado");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Comentario comentario) {
        try {
            comentarioServicio.update(comentario);
            return ResponseEntity.status(HttpStatus.OK).body("Comentario actualizado correctamente");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Comentario no actualizado");
        }
    }
}
