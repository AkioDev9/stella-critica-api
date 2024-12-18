package com.example.stellacriticaapi.serviceimplements;

import com.example.stellacriticaapi.entities.Rol;
import com.example.stellacriticaapi.repositories.IRolRepository;
import com.example.stellacriticaapi.serviceinterfaces.IRolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImplement implements IRolService {
    @Autowired
    private IRolRepository rolRepository;

    @Override
    public void insert(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void delete(int id) {
        rolRepository.deleteById(id);
    }

    @Override
    public void update(Rol rol) {
        rolRepository.save(rol);
    }
}
