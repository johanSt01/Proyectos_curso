package org.example.Model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Cita {
    private int id;
    private String nombrePaciente;
    private String telefono;
    private LocalDateTime fechaHora;
    private boolean estado;

    public Cita() {}

    public Cita(int id, String nombrePaciente, String telefono, LocalDateTime fechaHora) {
        this.nombrePaciente = nombrePaciente;
        this.id = id;
        this.telefono = telefono;
        this.fechaHora = fechaHora;
        this.estado = true;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", nombrePaciente='" + nombrePaciente + '\'' +
                ", telefono='" + telefono + '\'' +
                ", fechaHora=" + fechaHora +
                ", estado=" + estado +
                '}';
    }
}
