package com.example.stellacriticaapi.controllers;

import com.example.stellacriticaapi.dtos.RolDTO;
import org.modelmapper.ModelMapper;
import com.example.stellacriticaapi.entities.Rol;
import com.example.stellacriticaapi.serviceinterfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    private IRolService rolService;

    @GetMapping
    public List<RolDTO> listar() {
        return rolService.list().stream().map(x -> {
            ModelMapper modelMapper = new ModelMapper();
            return modelMapper.map(x, RolDTO.class);
        }).collect(Collectors.toList());
    }

    @PostMapping
    public void registrar(@RequestBody RolDTO rolDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Rol rol = modelMapper.map(rolDTO, Rol.class);
        rolService.insert(rol);
    }

    @PatchMapping
    public void modificar(@RequestBody RolDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Rol ro = modelMapper.map(dto, Rol.class);
        rolService.update(ro);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable("id") Integer id) {
        rolService.delete(id);
    }
}
