package com.example.stellacriticaapi.dtos;

import com.example.stellacriticaapi.entities.Rol;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private int idUsuario;
    private String username;
    private String password;
    private String nombres;
    private String apellidos;
    private List<Rol> roles;
    private String correo;
    private int telefono;
}
