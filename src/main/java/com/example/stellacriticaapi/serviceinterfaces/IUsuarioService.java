package com.example.stellacriticaapi.serviceinterfaces;

import com.example.stellacriticaapi.entities.Usuario;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> list();
    public void insert(Usuario usuario);
    public void update(Usuario usuario);
    public void delete(int id);
    public Usuario findOneByUsername(String username);
}
