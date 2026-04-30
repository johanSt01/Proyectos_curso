package com.app.shopsystem.service.interfaces;

import com.app.shopsystem.model.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listarTodos();
    Optional<Producto> buscarPorId(Long id);
    List<Producto> listarDisponibles();
    Producto guardar(Producto producto);
    Optional<Producto> actualizar(Long id, Producto datosNuevos);
    boolean eliminar(Long id);
}
