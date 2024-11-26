package com.equipo10.proyectotech.servicios;
import com.equipo10.proyectotech.repositorios.IEmprendimientoRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.equipo10.proyectotech.entidades.Emprendimiento;

@Service
@RequiredArgsConstructor
public class EmprendimientoServicio {

    private final IEmprendimientoRepositorio emprendimientoRepositorio;



    public void save(Emprendimiento emprendimiento) {
        emprendimientoRepositorio.save(emprendimiento);
    }

    public Emprendimiento findById(Long id) {
        return this.emprendimientoRepositorio.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Emprendimiento no encontrado"));
    }

    public void delete(Long id) {
        var optionalEmprendimiento= this.emprendimientoRepositorio.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Emprendimiento no encontrado"));
        this.emprendimientoRepositorio.delete(optionalEmprendimiento);
    }

    public void update(Emprendimiento emprendimiento) {
        var optionalEmprendimiento= this.emprendimientoRepositorio.findById(emprendimiento.getId())
                .orElseThrow(()-> new IllegalArgumentException("Emprendimiento no encontrado"));
        optionalEmprendimiento.setNombre(emprendimiento.getNombre());
        optionalEmprendimiento.setDescripcion(emprendimiento.getDescripcion());
        this.emprendimientoRepositorio.save(optionalEmprendimiento);
    }
}
