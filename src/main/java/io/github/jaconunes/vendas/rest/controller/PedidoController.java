package io.github.jaconunes.vendas.rest.controller;

import io.github.jaconunes.vendas.domain.repository.PedidosRepository;
import io.github.jaconunes.vendas.service.PedidoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }




}
