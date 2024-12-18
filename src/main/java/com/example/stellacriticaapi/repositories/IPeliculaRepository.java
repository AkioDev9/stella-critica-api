package com.example.stellacriticaapi.repositories;

import com.example.stellacriticaapi.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPeliculaRepository extends JpaRepository<Pelicula, Integer> {
}
