package com.example.stellacriticaapi.repositories;

import com.example.stellacriticaapi.entities.Critica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICriticaRepository extends JpaRepository<Critica, Integer> {
}
