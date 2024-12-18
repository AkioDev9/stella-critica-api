package com.example.stellacriticaapi.serviceimplements;

import com.example.stellacriticaapi.entities.Usuario;
import com.example.stellacriticaapi.repositories.IUsuarioRepository;
import com.example.stellacriticaapi.serviceinterfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> list() {
        return usuarioRepository.findAll();
    }

    @Override
    public void insert(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void update(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public void delete(int id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public Usuario listId(int id) {
        return usuarioRepository.findById(id).orElse(new Usuario());
    }

    @Override
    public Usuario findOneByUsername(String username) {
        return usuarioRepository.findOneByUsername(username);
    }
}
