package com.example.stellacriticaapi.repositories;

import com.example.stellacriticaapi.entities.Critica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICriticaRepository extends JpaRepository<Critica, Integer> {
}
