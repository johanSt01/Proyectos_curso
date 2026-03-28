package com.app.apilibros;

import com.app.apilibros.model.Libro;
import com.app.apilibros.repository.LibroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {
    @Bean
    CommandLineRunner initData(LibroRepository repository) {
        return args -> {
            repository.save(new Libro("Cien años de soledad", "Gabriel García Márquez", "9780307474728", 1967));
            repository.save(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "9788491050291", 1605));
            repository.save(new Libro("La sombra del viento", "Carlos Ruiz Zafón", "9788408172173", 2001));
            repository.save(new Libro("El principito", "Antoine de Saint-Exupéry", "9780156013987", 1943));
            repository.save(new Libro("1984", "George Orwell", "9780451524935", 1949));
        };
    }
}
