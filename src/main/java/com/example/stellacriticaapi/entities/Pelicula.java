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

    @Column(name = "descripcion", nullable = false, length = 500)
    private String descripcion;

    @Column(name = "genero", nullable = false, length = 35)
    private String genero;

    @Column(name = "popularidad", nullable = false, length = 20)
    private String popularidad;

    @Column(name = "anho", nullable = false)
    private int anho;

    public Pelicula() {
    }

    public Pelicula(int idPelicula, String titulo, String descripcion, String genero, String popularidad, int anho) {
        this.idPelicula = idPelicula;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.genero = genero;
        this.popularidad = popularidad;
        this.anho = anho;
    }

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(String popularidad) {
        this.popularidad = popularidad;
    }

    public int getAnho() {
        return anho;
    }

    public void setAnho(int anho) {
        this.anho = anho;
    }
}