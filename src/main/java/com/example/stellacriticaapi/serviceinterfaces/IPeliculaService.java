package com.example.stellacriticaapi.serviceinterfaces;

import com.example.stellacriticaapi.entities.Pelicula;

import java.util.List;

public interface IPeliculaService {
    List<Pelicula> list();
    public void insert(Pelicula pelicula);
    public void update(Pelicula pelicula);
    public void delete(int id);
    public Pelicula listId(int id);
}
