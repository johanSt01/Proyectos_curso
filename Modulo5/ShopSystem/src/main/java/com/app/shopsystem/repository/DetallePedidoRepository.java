package com.app.shopsystem.repository;

import com.app.shopsystem.model.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetallePedidoRepository extends JpaRepository<DetallePedido, Long> {
    List<DetallePedido> findByPedidoId(Long id);

    @Query("SELECT d.producto, SUM(d.cantidad) " +
            "FROM DetallePedido d " +
            "GROUP BY d.producto " +
            "ORDER BY SUM(d.cantidad) DESC")
    List<Object[]> findProductosMasVendidos();
}
