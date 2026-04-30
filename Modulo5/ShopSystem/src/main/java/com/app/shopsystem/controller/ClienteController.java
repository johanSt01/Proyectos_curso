package com.app.shopsystem.controller;

import com.app.shopsystem.model.Cliente;
import com.app.shopsystem.service.interfaces.ClienteService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerClientes() {
        try {
            List<Cliente> clientes = clienteService.listarTodos();
            if (clientes.isEmpty()) {
                return ResponseEntity.noContent().build(); // 204 — exito pero sin contenido
            }
            return ResponseEntity.ok().body(clientes); //200 - exito con la lista
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // 500
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientesPorId(@PathVariable Long id) {
        try {
            return clienteService.buscarPorId(id).map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<String> guardar(@Valid @RequestBody Cliente cliente) {
        try {
            clienteService.guardar(cliente);
            return ResponseEntity.status(HttpStatus.CREATED).body("Cliente guardado con exito");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> actualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        try {
            return clienteService.actualizar(id, cliente)
                    .map(c -> ResponseEntity.ok("Cliente actualizado con exito")) // 200
                    .orElse(ResponseEntity.notFound().build()); // 404
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage()); // 400
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en el servidor"); // 500
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        try {
            return clienteService.eliminar(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
