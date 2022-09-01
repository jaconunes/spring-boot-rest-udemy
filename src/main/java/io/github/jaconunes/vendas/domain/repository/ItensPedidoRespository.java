package io.github.jaconunes.vendas.domain.repository;

import io.github.jaconunes.vendas.domain.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidoRespository extends JpaRepository<ItemPedido, Integer> {

}
