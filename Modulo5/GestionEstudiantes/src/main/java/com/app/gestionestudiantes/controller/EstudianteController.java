package com.app.gestionestudiantes.controller;

import com.app.gestionestudiantes.model.Estudiante;
import com.app.gestionestudiantes.service.EstudianteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private final EstudianteService estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<Estudiante> listarEstudiantes(){
        return estudianteService.listarEstudiantes();
    }

    @GetMapping("/buscar")
    public ResponseEntity<Estudiante> buscarPorEmail(@RequestParam String email){
        return estudianteService.buscarPorEmail(email).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Estudiante> createEstudiante(@RequestBody Estudiante estudiante){
        Estudiante nuevoEstudiante = estudianteService.inscribirEstudiante(estudiante);
        return ResponseEntity.ok().body(nuevoEstudiante);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstudiante(@PathVariable Long id){
        return estudianteService.darDeBaja(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
