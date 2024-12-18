package com.example.stellacriticaapi.controllers;

import com.example.stellacriticaapi.entities.Critica;
import org.modelmapper.ModelMapper;
import com.example.stellacriticaapi.dtos.CriticaDTO;
import com.example.stellacriticaapi.serviceinterfaces.ICriticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/criticas")
public class CriticaController {
    @Autowired
    private ICriticaService criticaService;

    @GetMapping
    public List<CriticaDTO> listar() {
        return criticaService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, CriticaDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody CriticaDTO criticaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Critica critica = modelMapper.map(criticaDTO, Critica.class);
        criticaService.insert(critica);
    }

    @GetMapping("/{id}")
    public CriticaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        CriticaDTO dto = modelMapper.map(criticaService.listId(id), CriticaDTO.class);
        return dto;
    }

    @PatchMapping
    public void modificar(@RequestBody CriticaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Critica critica = modelMapper.map(dto, Critica.class);
        criticaService.update(critica);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        criticaService.delete(id);
    }
}
