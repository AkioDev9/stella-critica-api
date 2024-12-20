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

    public Critica() {
    }

    public Critica(int idCritica, String contenido, int puntuacion, Usuario usuario, Pelicula pelicula) {
        this.idCritica = idCritica;
        this.contenido = contenido;
        this.puntuacion = puntuacion;
        this.usuario = usuario;
        this.pelicula = pelicula;
    }

    public int getIdCritica() {
        return idCritica;
    }

    public void setIdCritica(int idCritica) {
        this.idCritica = idCritica;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
}
