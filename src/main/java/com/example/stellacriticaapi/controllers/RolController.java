package com.example.stellacriticaapi.controllers;

import com.example.stellacriticaapi.dtos.RolDTO;
import org.modelmapper.ModelMapper;
import com.example.stellacriticaapi.entities.Rol;
import com.example.stellacriticaapi.serviceinterfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private IRolService rolService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping
    public List<RolDTO> listar() {
        return rolService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping
    public void registrar(@RequestBody RolDTO rolDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Rol rol = modelMapper.map(rolDTO, Rol.class);
        rolService.insert(rol);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PatchMapping
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Rol ro = modelMapper.map(dto, Rol.class);
        rolService.update(ro);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rolService.delete(id);
    }
}
