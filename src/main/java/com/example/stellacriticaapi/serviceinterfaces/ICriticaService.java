package com.example.stellacriticaapi.serviceinterfaces;

import com.example.stellacriticaapi.entities.Critica;

import java.util.List;

public interface ICriticaService {
    List<Critica> list();
    public void insert(Critica critica);
    public void update(Critica critica);
    public void delete(int id);
    public Critica listId(int id);
}
