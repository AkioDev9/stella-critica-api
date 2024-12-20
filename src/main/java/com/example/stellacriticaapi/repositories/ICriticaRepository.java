package com.example.stellacriticaapi.repositories;

import com.example.stellacriticaapi.entities.Critica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICriticaRepository extends JpaRepository<Critica, Integer> {
    @Query(value = "SELECT p.titulo, c.contenido, c.puntuacion " +
            "FROM critica c " +
            "JOIN pelicula p ON c.pelicula_id = p.id_pelicula " +
            "WHERE p.titulo = :titulo", nativeQuery = true)
    List<String[]> buscarCriticasPorTitulo(@Param("titulo") String titulo);
}
