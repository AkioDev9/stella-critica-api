package com.example.stellacriticaapi.controllers;

import com.example.stellacriticaapi.dtos.CriticaPorTituloDTO;
import com.example.stellacriticaapi.entities.Critica;
import com.example.stellacriticaapi.entities.Usuario;
import org.modelmapper.ModelMapper;
import com.example.stellacriticaapi.dtos.CriticaDTO;
import com.example.stellacriticaapi.serviceinterfaces.ICriticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String usuarioLogeado = authentication.getName();

        ModelMapper modelMapper = new ModelMapper();
        Critica critica = modelMapper.map(criticaDTO, Critica.class);

        // Asignar el usuario logeado como autor de la crítica
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioLogeado);
        critica.setUsuario(usuario);

        criticaService.insert(critica);
    }

    @PreAuthorize("hasAnyAuthority('EDITOR', 'CLIENTE', 'ADMIN')")
    @PatchMapping
    public void modificar(@RequestBody CriticaDTO dto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String usuarioLogeado = authentication.getName();

        // Obtener la crítica existente
        Critica criticaExistente = criticaService.listId(dto.getIdCritica());
        String usuarioDeCritica = criticaExistente.getUsuario().getUsername();

        // Validar si el usuario logeado es el creador
        if (!usuarioDeCritica.equalsIgnoreCase(usuarioLogeado)) {
            throw new RuntimeException("No tienes permiso para modificar esta crítica.");
        }

        // Mapear y actualizar la crítica
        ModelMapper modelMapper = new ModelMapper();
        Critica critica = modelMapper.map(dto, Critica.class);
        critica.setUsuario(criticaExistente.getUsuario()); // Mantener el usuario existente
        criticaService.update(critica);
    }

    @PreAuthorize("hasAnyAuthority('EDITOR', 'CLIENTE', 'ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String usuarioLogeado = authentication.getName();

        // Validar si el usuario logeado es el creador
        Critica criticaExistente = criticaService.listId(id);
        if (!criticaExistente.getUsuario().getUsername().equalsIgnoreCase(usuarioLogeado)) {
            throw new RuntimeException("No tienes permiso para eliminar esta crítica.");
        }

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
