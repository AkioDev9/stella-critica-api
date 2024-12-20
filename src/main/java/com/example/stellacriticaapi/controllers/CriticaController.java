package com.example.stellacriticaapi.controllers;

import com.example.stellacriticaapi.dtos.CriticaPorTituloDTO;
import com.example.stellacriticaapi.entities.Critica;
import org.modelmapper.ModelMapper;
import com.example.stellacriticaapi.dtos.CriticaDTO;
import com.example.stellacriticaapi.serviceinterfaces.ICriticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/criticas")
public class CriticaController {
    @Autowired
    private ICriticaService criticaService;

    @PreAuthorize("hasAnyAuthority('EDITOR', 'CLIENTE', 'ADMIN')")
    @GetMapping
    public List<CriticaDTO> listar() {
        return criticaService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, CriticaDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAnyAuthority('EDITOR', 'CLIENTE', 'ADMIN')")
    @PostMapping
    public void registrar(@RequestBody CriticaDTO criticaDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Critica critica = modelMapper.map(criticaDTO, Critica.class);
        criticaService.insert(critica);
    }

    @PreAuthorize("hasAnyAuthority('EDITOR', 'ADMIN')")
    @GetMapping("/{id}")
    public CriticaDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        CriticaDTO dto = modelMapper.map(criticaService.listId(id), CriticaDTO.class);
        return dto;
    }

    @PreAuthorize("hasAnyAuthority('EDITOR', 'CLIENTE', 'ADMIN')")
    @PatchMapping
    public void modificar(@RequestBody CriticaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Critica critica = modelMapper.map(dto, Critica.class);
        criticaService.update(critica);
    }

    @PreAuthorize("hasAnyAuthority('EDITOR', 'CLIENTE', 'ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        criticaService.delete(id);
    }

    @PreAuthorize("hasAnyAuthority('EDITOR', 'CLIENTE', 'ADMIN')")
    @GetMapping("/titulo/{titulo}")
    public List<CriticaPorTituloDTO> criticasPorTitulo(@PathVariable("titulo") String titulo) {
        List<String[]> lista = criticaService.buscarCriticasPorTitulo(titulo);
        List<CriticaPorTituloDTO> listaDTO = new ArrayList<>();
        for (String[] x : lista) {
            CriticaPorTituloDTO dto = new CriticaPorTituloDTO();
            dto.setTitulo(x[0]);
            dto.setContenido(x[1]);
            dto.setPuntuacion(Integer.parseInt(x[2]));
            listaDTO.add(dto);
        }
        return listaDTO;
    }
}
