package com.example.stellacriticaapi.controllers;

import com.example.stellacriticaapi.entities.Pelicula;
import org.modelmapper.ModelMapper;
import com.example.stellacriticaapi.dtos.PeliculaDTO;
import com.example.stellacriticaapi.serviceinterfaces.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private IPeliculaService peliculaService;

    @GetMapping
    public List<PeliculaDTO> listar() {
        return peliculaService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, PeliculaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody PeliculaDTO peliculaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Pelicula pelicula = modelMapper.map(peliculaDTO, Pelicula.class);
        peliculaService.insert(pelicula);
    }

    @GetMapping("/{id}")
    public PeliculaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        PeliculaDTO dto = modelMapper.map(peliculaService.listId(id), PeliculaDTO.class);
        return dto;
    }

    @PatchMapping
    public void modificar(@RequestBody PeliculaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Pelicula pelicula = modelMapper.map(dto, Pelicula.class);
        peliculaService.update(pelicula);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        peliculaService.delete(id);
    }
}
