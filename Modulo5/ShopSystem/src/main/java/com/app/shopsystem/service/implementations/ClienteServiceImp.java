package com.app.shopsystem.service.implementations;

import com.app.shopsystem.model.Cliente;
import com.app.shopsystem.repository.ClienteRepository;
import com.app.shopsystem.service.interfaces.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClienteServiceImp implements ClienteService {

    private final ClienteRepository clienteRepository;

    @Override
    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente guardar(Cliente cliente) {
        Optional<Cliente> existe = clienteRepository.findByEmail(cliente.getEmail());
        if(existe.isPresent()) {
            throw new RuntimeException("Ya existe un cliente con el email " + cliente.getEmail());
        }
        return clienteRepository.save(cliente);
    }

    @Override
    public Optional<Cliente> actualizar(Long id, Cliente datosNuevos) {
        return clienteRepository.findById(id).map(clienteExistente -> {
            clienteExistente.setNombre(datosNuevos.getNombre());
            clienteExistente.setEmail(datosNuevos.getEmail());
            return clienteRepository.save(clienteExistente);
        });
    }

    @Override
    public boolean eliminar(Long id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
