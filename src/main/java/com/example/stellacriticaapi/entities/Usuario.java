package com.example.stellacriticaapi.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;

    @Column(length = 30, unique = true)
    private String username;

    @Column(length = 200, nullable = false)
    private String password;

    private Boolean enabled;

    @Column(name = "nombres", nullable = false, length = 30)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 30)
    private String apellidos;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Rol> roles;

    @Column(name = "correo", nullable = false, length = 30)
    private String correo;

    @Column(name = "telefono", nullable = false)
    private int telefono;

    public Usuario() {
    }

    public Usuario(int idUsuario, String username, String password, Boolean enabled, String nombres, String apellidos, List<Rol> roles, String correo, int telefono) {
        this.idUsuario = idUsuario;
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.roles = roles;
        this.correo = correo;
        this.telefono = telefono;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public List<Rol> getRoles() {
        return roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }
}
