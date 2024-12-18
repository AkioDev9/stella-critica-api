package com.example.stellacriticaapi.serviceimplements;

import com.example.stellacriticaapi.entities.Pelicula;
import com.example.stellacriticaapi.repositories.IPeliculaRepository;
import com.example.stellacriticaapi.serviceinterfaces.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaServiceImplement implements IPeliculaService {
    @Autowired
    private IPeliculaRepository peliculaRepository;


    @Override
    public List<Pelicula> list() {
        return peliculaRepository.findAll();
    }

    @Override
    public void insert(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }

    @Override
    public void delete(int id) {
        peliculaRepository.deleteById(id);
    }

    @Override
    public void update(Pelicula pelicula) {
        peliculaRepository.save(pelicula);
    }
}
