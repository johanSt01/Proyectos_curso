package com.app.shopsystem.service.interfaces;

import com.app.shopsystem.model.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> listarTodos();
    Optional<Cliente> buscarPorId(Long id);
    Cliente guardar(Cliente cliente);
    Optional<Cliente> actualizar(Long id, Cliente datosNuevos);
    boolean eliminar(Long id);
}
