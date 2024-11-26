package com.equipo10.proyectotech.servicios;
import com.equipo10.proyectotech.entidades.Usuario;
import com.equipo10.proyectotech.repositorios.IUsuarioRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioServicio {

    private final IUsuarioRepositorio usuarioRepositorio;

    public void save(Usuario usuario) {
        usuarioRepositorio.save(usuario);
    }

    public Usuario findById(Long id) {
        return this.usuarioRepositorio.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Usuario no encontrado"));
    }

    public void delete(Long id) {
        usuarioRepositorio.deleteById(id);
    }

    public void update(Usuario usuario) {
        var optionalUsuario= this.usuarioRepositorio.findById(usuario.getId())
                .orElseThrow(()-> new IllegalArgumentException("Usuario no encontrado"));
        optionalUsuario.setNombre(usuario.getNombre());
        optionalUsuario.setApellido(usuario.getApellido());
        optionalUsuario.setEmail(usuario.getEmail());
        this.usuarioRepositorio.save(optionalUsuario);
    }

    public void updatePassword(Long id, String password) {
       var optionalUsuario= this.usuarioRepositorio.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("Usuario no encontrado"));
        optionalUsuario.setPassword(password);
        this.usuarioRepositorio.save(optionalUsuario);
    }

}
