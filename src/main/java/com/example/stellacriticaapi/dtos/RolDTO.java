package com.example.stellacriticaapi.dtos;

import com.example.stellacriticaapi.entities.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RolDTO {
    private int idRol;
    private String nombreRol;
    private Usuario user;
}

