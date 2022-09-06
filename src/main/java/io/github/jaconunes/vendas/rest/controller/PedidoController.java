package io.github.jaconunes.vendas.rest.controller;

import io.github.jaconunes.vendas.domain.entities.Pedido;
import io.github.jaconunes.vendas.domain.repository.PedidosRepository;
import io.github.jaconunes.vendas.rest.dto.PedidoDTO;
import io.github.jaconunes.vendas.service.PedidoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody PedidoDTO dto){
        Pedido pedido = pedidoService.salvar(dto);
        return pedido.getId();
    }


}
