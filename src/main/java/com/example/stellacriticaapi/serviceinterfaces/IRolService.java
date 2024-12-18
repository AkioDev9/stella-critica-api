package com.example.stellacriticaapi.serviceinterfaces;

import com.example.stellacriticaapi.entities.Rol;

public interface IRolService {
    public void insert(Rol rol);
    public void delete(int id);
    public void update(Rol rol);
}
