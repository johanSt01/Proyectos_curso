package com.app.apilibros.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Libros")
@Getter
@Setter
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String autor;

    @Column(unique = true)
    private String ISBN;

    private Integer anioPublicacion;

    public Libro() {}

    public Libro(String titulo, String autor, String ISBN, Integer anioPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.anioPublicacion = anioPublicacion;
    }
}
