package com.app.shopsystem.service.implementations;

import com.app.shopsystem.model.Cliente;
import com.app.shopsystem.model.Pedido;
import com.app.shopsystem.repository.ClienteRepository;
import com.app.shopsystem.repository.PedidoRepository;
import com.app.shopsystem.service.interfaces.PedidoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PedidoServiceImp implements PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;

    @Override
    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    @Override
    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    @Override
    public List<Pedido> pedidosPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    @Override
    public Pedido crearPedido(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new RuntimeException("Cliente no encontrado con id: " + clienteId));
        Pedido pedido = new Pedido(LocalDateTime.now(), "PENDIENTE", cliente);
        return pedidoRepository.save(pedido);
    }

    @Override
    public Optional<Pedido> actualizarEstado(Long id, String nuevoEstado) {
        return pedidoRepository.findById(id).map(pedido -> {
            pedido.setEstado(nuevoEstado);
            return pedidoRepository.save(pedido);
        });
    }

    @Override
    public boolean eliminar(Long id) {
        if(pedidoRepository.existsById(id)) {
            pedidoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
