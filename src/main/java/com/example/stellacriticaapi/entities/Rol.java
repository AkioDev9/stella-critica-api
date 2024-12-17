package com.example.stellacriticaapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Rol", uniqueConstraints = {@UniqueConstraint(columnNames = {"user_id", "nombreRol"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;

    @Column(name = "nombreRol", nullable = false)
    private String nombreRol;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario user;
}
