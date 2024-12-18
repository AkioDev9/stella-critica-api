package com.example.stellacriticaapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PeliculaDTO {
    private int idPelicula;
    private String titulo;
    private String descripcion;
    private String genero;
    private String popularidad;
    private int anho;
}