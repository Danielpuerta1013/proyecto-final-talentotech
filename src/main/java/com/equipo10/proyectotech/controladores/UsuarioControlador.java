package com.equipo10.proyectotech.controladores;

import com.equipo10.proyectotech.entidades.Usuario;
import com.equipo10.proyectotech.servicios.UsuarioServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
@RequiredArgsConstructor
public class UsuarioControlador {

    private final UsuarioServicio usuarioServicio;


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Usuario usuario) {
        usuarioServicio.save(usuario);
        return ResponseEntity.status(HttpStatus.OK).body("Usuario guardado correctamente");
    }

    @RequestMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        var usuario=usuarioServicio.findById(id);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            usuarioServicio.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario eliminado correctamente");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario no eliminado");
        }

    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Usuario usuario) {
        try {
            usuarioServicio.update(usuario);
            return ResponseEntity.status(HttpStatus.OK).body("Usuario Actualizado correctamente");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuario no actualizado");
        }
    }

    @PutMapping("/updatePassword")
    public ResponseEntity<?> updatePassword(@RequestParam Long id, @RequestParam String password) {
        try {
            usuarioServicio.updatePassword(id,password);
            return ResponseEntity.status(HttpStatus.OK).body("Contraseña actualizada correctamente");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Contraseña no actualizado");
        }
    }


}
