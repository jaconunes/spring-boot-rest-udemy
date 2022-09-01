package io.github.jaconunes.vendas.domain.repository;

import io.github.jaconunes.vendas.domain.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedido, Integer> {

}
