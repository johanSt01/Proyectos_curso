package com.app.shopsystem.service.implementations;

import com.app.shopsystem.model.Producto;
import com.app.shopsystem.repository.ProductoRepository;
import com.app.shopsystem.service.interfaces.ProductoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServiceImp implements ProductoService {

    private final ProductoRepository productoRepository;

    @Override
    public List<Producto> listarTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Optional<Producto> buscarPorId(Long id) {
        return productoRepository.findById(id);
    }

    @Override
    public List<Producto> listarDisponibles() {
        return productoRepository.findByStockGreaterThan(0);
    }

    @Override
    public Producto guardar(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Optional<Producto> actualizar(Long id, Producto datosNuevos) {
        return productoRepository.findById(id).map(existe -> {
            existe.setNombre(datosNuevos.getNombre());
            existe.setPrecio(datosNuevos.getPrecio());
            existe.setStock(datosNuevos.getStock());
            return productoRepository.save(existe);
        });
    }

    @Override
    public boolean eliminar(Long id) {
        if(productoRepository.existsById(id)) {
            productoRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
