package io.github.jaconunes.vendas.service;

import io.github.jaconunes.vendas.domain.entities.Pedido;
import io.github.jaconunes.vendas.domain.enums.StatusPedido;
import io.github.jaconunes.vendas.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto );
    Optional<Pedido> obterPedidoCompleto(Integer id);
    void atualizaStatus(Integer id, StatusPedido statusPedido);
}
