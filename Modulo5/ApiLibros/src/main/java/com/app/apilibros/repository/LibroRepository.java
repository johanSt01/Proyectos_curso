package com.app.apilibros.repository;

import com.app.apilibros.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libro,Long> {
    java.util.List<Libro> findByAutor(String autor);
    java.util.List<Libro> findByTituloContaining(String titulo);
}
