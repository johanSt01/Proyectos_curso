package com.app.gestionestudiantes.model;

public class Estudiante {

    private Long id;
    private String nombre;
    private String email;
    private String carrera;

    public Estudiante() {}

    public Estudiante(Long id, String nombre, String email, String carrera) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.carrera = carrera;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
