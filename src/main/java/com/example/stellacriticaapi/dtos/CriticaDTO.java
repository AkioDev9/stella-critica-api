package com.example.stellacriticaapi.dtos;

import com.example.stellacriticaapi.entities.Pelicula;
import com.example.stellacriticaapi.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriticaDTO {
    private int idCritica;
    private String contenido;
    private int puntuacion;
    private Usuario usuario;
    private Pelicula pelicula;
}
