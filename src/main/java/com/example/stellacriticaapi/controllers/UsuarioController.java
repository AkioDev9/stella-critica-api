package com.example.stellacriticaapi.controllers;

import com.example.stellacriticaapi.entities.Usuario;
import org.modelmapper.ModelMapper;
import com.example.stellacriticaapi.dtos.UsuarioDTO;
import com.example.stellacriticaapi.serviceinterfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private IUsuarioService usuarioService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<UsuarioDTO> listar() {
        return usuarioService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, UsuarioDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void registrar(@RequestBody UsuarioDTO usuarioDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario user = modelMapper.map(usuarioDTO, Usuario.class);
        usuarioService.insert(user);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/{id}")
    public UsuarioDTO listarId(@PathVariable("id") Integer id) {
        ModelMapper modelMapper = new ModelMapper();
        UsuarioDTO dto = modelMapper.map(usuarioService.listId(id), UsuarioDTO.class);
        return dto;
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping
    public void modificar(@RequestBody UsuarioDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Usuario usuario = modelMapper.map(dto, Usuario.class);
        usuarioService.update(usuario);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        usuarioService.delete(id);
    }

}
