package io.github.jaconunes.vendas.service.impl;

import io.github.jaconunes.vendas.domain.repository.PedidosRepository;
import io.github.jaconunes.vendas.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private PedidosRepository pedidosRepository;

    public PedidoServiceImpl(PedidosRepository pedidosRepository) {
        this.pedidosRepository = pedidosRepository;
    }


}
