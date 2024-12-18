package com.example.stellacriticaapi.serviceimplements;

import com.example.stellacriticaapi.entities.Critica;
import com.example.stellacriticaapi.repositories.ICriticaRepository;
import com.example.stellacriticaapi.serviceinterfaces.ICriticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CriticaServiceImplement implements ICriticaService {

    @Autowired
    private ICriticaRepository criticaRepository;

    @Override
    public List<Critica> list() {
        return criticaRepository.findAll();
    }

    @Override
    public void insert(Critica critica) {
        criticaRepository.save(critica);
    }

    @Override
    public void delete(int id) {
        criticaRepository.deleteById(id);
    }

    @Override
    public void update(Critica critica) {
        criticaRepository.save(critica);
    }

}
