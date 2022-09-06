package io.github.jaconunes.vendas.service;

import io.github.jaconunes.vendas.domain.entities.Pedido;
import io.github.jaconunes.vendas.rest.dto.PedidoDTO;

public interface PedidoService {
    Pedido salvar(PedidoDTO dto );
}
