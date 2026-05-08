package com.app.shopsystem.repository;

import com.app.shopsystem.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByClienteId(Long clienteId);
    List<Pedido> findByEstado(String estado);

    @Query("SELECT p FROM Pedido p WHERE p.fechaPedido >= :fechaLimite " +
            "ORDER BY p.fechaPedido DESC")
    List<Pedido> findPedidosDesde(@Param("fechaLimite") LocalDateTime fechaLimite);
}
