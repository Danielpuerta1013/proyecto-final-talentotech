package com.equipo10.proyectotech.controladores;
import com.equipo10.proyectotech.servicios.EmprendimientoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import com.equipo10.proyectotech.entidades.Emprendimiento;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/emprendimiento")
public class EmprendimientoControlador {


    @Autowired
    private EmprendimientoServicio emprendimientoServicio;
    public EmprendimientoControlador(EmprendimientoServicio emprendimientoServicio) {
        this.emprendimientoServicio = emprendimientoServicio;
    }
    @PostMapping("/save")
    public void save(@RequestBody Emprendimiento emprendimiento) {
        this.emprendimientoServicio.save(emprendimiento);
    }
    @GetMapping("/{id}")
    public Emprendimiento findById(@PathVariable Long id) {
        return this.emprendimientoServicio.findById(id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.emprendimientoServicio.delete(id);
    }
    @PutMapping("/update")
    public void update(@RequestBody Emprendimiento emprendimiento) {
        this.emprendimientoServicio.update(emprendimiento);
    }

}
