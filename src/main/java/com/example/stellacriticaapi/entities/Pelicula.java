package com.example.stellacriticaapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Pelicula")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPelicula;

    @Column(name = "titulo", nullable = false, length = 40)
    private String titulo;

    @Column(name = "descripcion", nullable = false, length = 100)
    private String descripcion;

    @Column(name = "genero", nullable = false, length = 20)
    private String genero;

    @Column(name = "popularidad", nullable = false, length = 20)
    private String popularidad;

    @Column(name = "anho", nullable = false)
    private int anho;
}