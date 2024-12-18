package com.example.stellacriticaapi.serviceinterfaces;

import com.example.stellacriticaapi.entities.Rol;

import java.util.List;

public interface IRolService {
    List<Rol> list();
    public void insert(Rol rol);
    public void delete(int id);
    public void update(Rol rol);
}
