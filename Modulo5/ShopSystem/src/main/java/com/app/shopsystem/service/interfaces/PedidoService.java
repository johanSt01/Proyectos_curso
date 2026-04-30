package com.app.shopsystem.service.interfaces;

import com.app.shopsystem.model.Pedido;

import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> listarTodos();
    Optional<Pedido> buscarPorId(Long id);
    List<Pedido> pedidosPorCliente(Long clienteId);
    Pedido crearPedido(Long clienteId);
    Optional<Pedido> actualizarEstado(Long id, String nuevoEstado);
    boolean eliminar(Long id);
}
