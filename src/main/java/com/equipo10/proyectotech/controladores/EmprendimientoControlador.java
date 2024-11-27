package com.equipo10.proyectotech.controladores;
import com.equipo10.proyectotech.entidades.Comentario;
import com.equipo10.proyectotech.servicios.EmprendimientoServicio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import com.equipo10.proyectotech.entidades.Emprendimiento;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprendimiento")
@RequiredArgsConstructor
public class EmprendimientoControlador {

    private  final EmprendimientoServicio emprendimientoServicio;


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody Emprendimiento emprendimiento) {
        emprendimientoServicio.save(emprendimiento);
        return ResponseEntity.status(HttpStatus.OK).body("emprendimiento guardado correctamente");
    }



    @GetMapping("/id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        try {
            var emprendimiento = emprendimientoServicio.findById(id);
            return ResponseEntity.ok(emprendimiento);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("emprendmiento no encontrado");
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(Long id) {
        try {
            emprendimientoServicio.delete(id);
            return ResponseEntity.status(HttpStatus.OK).body("emprendimiento eliminado correctamente");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("emprendimiento no eliminado");
        }
    }


    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Emprendimiento emprendimiento) {
        try {
            emprendimientoServicio.update(emprendimiento);
            return ResponseEntity.status(HttpStatus.OK).body("Emprendimiento actualizado correctamente");
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("emprendimiento no actualizado");
        }
    }
}
