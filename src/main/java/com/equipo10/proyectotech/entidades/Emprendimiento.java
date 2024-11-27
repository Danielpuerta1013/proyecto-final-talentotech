package com.equipo10.proyectotech.entidades;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "emprendimientos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Emprendimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emprendimiento")
    private Long id;

    @Column(name = "nombre_emprendimiento", nullable = false, length = 100)
    private String nombre;

    @Column(name = "descripcion_emprendimiento", length = 500)
    private String descripcion;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_categoria", nullable = false)
    private TipoCategoria tipoCategoria;

    @ManyToOne
    @JoinColumn(name = "id_ciudad", nullable = false)
    private Ciudad ciudad;
}
