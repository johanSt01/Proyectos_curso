package com.app.apilibros.controller;

import com.app.apilibros.model.Libro;
import com.app.apilibros.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> obtenerTodos(){
        List<Libro> libros = libroService.obtenerLibros();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerLibroId(@PathVariable Long id){
        return libroService.ObtenerLibroId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro){
        Libro nuevoLibro = libroService.CrearLibro(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro);
    }
}
