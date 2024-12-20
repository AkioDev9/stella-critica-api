package com.example.stellacriticaapi.controllers;

import com.example.stellacriticaapi.entities.Pelicula;
import org.modelmapper.ModelMapper;
import com.example.stellacriticaapi.dtos.PeliculaDTO;
import com.example.stellacriticaapi.serviceinterfaces.IPeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/peliculas")
public class PeliculaController {
    @Autowired
    private IPeliculaService peliculaService;

    @PreAuthorize("hasAnyAuthority('EDITOR', 'CLIENTE', 'ADMIN')")
    @GetMapping
    public List<PeliculaDTO> listar() {
        return peliculaService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, PeliculaDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void registrar(@RequestBody PeliculaDTO peliculaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Pelicula pelicula = modelMapper.map(peliculaDTO, Pelicula.class);
        peliculaService.insert(pelicula);
    }

    @PreAuthorize("hasAnyAuthority('EDITOR', 'CLIENTE', 'ADMIN')")
    @GetMapping("/{id}")
    public PeliculaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        PeliculaDTO dto = modelMapper.map(peliculaService.listId(id), PeliculaDTO.class);
        return dto;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'EDITOR')")
    @PatchMapping
    public void modificar(@RequestBody PeliculaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Pelicula pelicula = modelMapper.map(dto, Pelicula.class);
        peliculaService.update(pelicula);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        peliculaService.delete(id);
    }
}
