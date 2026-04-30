package com.app.shopsystem.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min= 2, max = 100, message = "El nombre debe estar en 2 y 100 carácteres")
    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @NotBlank(message = "El email es necesario")
    @Email(message = "No tiene formato valido")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Pedido> pedidos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(Long id, String nombre, String email) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre es obligatorio") @Size(min = 2, max = 100, message = "El nombre debe estar en 2 y 100 carácteres") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre es obligatorio") @Size(min = 2, max = 100, message = "El nombre debe estar en 2 y 100 carácteres") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "El email es necesario") @Email(message = "No tiene formato valido") String getEmail() {
        return email;
    }

    public void setEmail(@NotBlank(message = "El email es necesario") @Email(message = "No tiene formato valido") String email) {
        this.email = email;
    }
}