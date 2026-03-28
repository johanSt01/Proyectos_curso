package com.app.apilibros.service;

import com.app.apilibros.model.Libro;
import com.app.apilibros.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository libroRepository;

    //Inyeccion por constructor
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> obtenerLibros(){
        return libroRepository.findAll();
    }

    public Optional<Libro> ObtenerLibroId(Long id){
        return libroRepository.findById(id);
    }

    public Libro CrearLibro(Libro libro){
        if(libro.getISBN() != null && !libro.getISBN().isEmpty()){
            libro.setISBN(libro.getISBN().trim().replaceAll(" ", ""));
        }
        return libroRepository.save(libro);
    }

}
