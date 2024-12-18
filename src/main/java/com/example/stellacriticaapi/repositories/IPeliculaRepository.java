package com.example.stellacriticaapi.repositories;

import com.example.stellacriticaapi.entities.Pelicula;
import org.springframework.data.repository.CrudRepository;

public interface IPeliculaRepository extends CrudRepository<Pelicula, Integer> {
}
