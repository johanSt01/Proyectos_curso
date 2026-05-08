package com.app.shopsystem.repository;

import com.app.shopsystem.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    List<Producto>findByNombre(String nombre);

    List<Producto> findByStockGreaterThan(Integer stockIsGreaterThan);
    Optional<Producto> findByPrecioLessThan(Double precioIsLessThan);
}
