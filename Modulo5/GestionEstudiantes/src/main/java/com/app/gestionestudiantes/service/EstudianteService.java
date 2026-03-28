package com.app.gestionestudiantes.service;

import com.app.gestionestudiantes.model.Estudiante;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class EstudianteService {

    private final List<Estudiante> estudiantes = new ArrayList<>();
    private final AtomicLong id = new AtomicLong(1);

    public List<Estudiante> listarEstudiantes(){
        return estudiantes;
    }

    public Optional<Estudiante> buscarPorEmail(String email){
        return estudiantes.stream().filter(x -> email.equalsIgnoreCase(x.getEmail())).findFirst();
    }

    public Estudiante inscribirEstudiante(Estudiante estudiante){
        if(estudiante.getEmail() == null || estudiante.getEmail().isBlank()){
            throw new IllegalArgumentException("El email es obligatorio");
        }
        boolean emailExiste = estudiantes.stream().anyMatch(y -> y.getEmail().equalsIgnoreCase(estudiante.getEmail()));
        if(emailExiste){
            throw new IllegalArgumentException("El email ya existe");
        }
        estudiante.setId(id.getAndIncrement());
        estudiantes.add(estudiante);
        return estudiante;
    }

    public boolean darDeBaja(Long id){
        return estudiantes.removeIf(z -> z.getId().equals(id));
    }

}
