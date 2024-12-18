package com.example.stellacriticaapi.repositories;

import com.example.stellacriticaapi.entities.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findOneByUsername(String username);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO Rol (nombreRol, idUsuario) VALUES (:nombreRol, :idUsuario)", nativeQuery = true)
    public void insertarRol(@Param("nombreRol") String nombreRol, @Param("idUsuario") int idUsuario);
}
