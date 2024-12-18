package com.example.stellacriticaapi.repositories;

import com.example.stellacriticaapi.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
}
