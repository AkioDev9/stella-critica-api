package com.example.stellacriticaapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Critica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Critica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCritica;

    @Column(name = "contenido", nullable = false, length = 50)
    private String contenido;

    @Column(name = "puntuacion", nullable = false)
    private int puntuacion;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "pelicula_id", nullable = false)
    private Pelicula pelicula;
}
