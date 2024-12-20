package com.example.stellacriticaapi.serviceimplements;

import com.example.stellacriticaapi.entities.Usuario;
import com.example.stellacriticaapi.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JWTUserDetailService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findOneByUsername(username);

        if (usuario == null) {
            throw new UsernameNotFoundException(String.format("User not exists", username));
        }

        List<GrantedAuthority> roles = new ArrayList<>();

        usuario.getRoles().forEach(rol -> {
            roles.add(new SimpleGrantedAuthority(rol.getNombreRol()));
        });

        UserDetails ud = new org.springframework.security.core.userdetails.User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true, roles);

        return ud;
    }
}