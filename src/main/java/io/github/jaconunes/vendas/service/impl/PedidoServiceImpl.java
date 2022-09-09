package io.github.jaconunes.vendas.service.impl;

import io.github.jaconunes.vendas.domain.entities.Cliente;
import io.github.jaconunes.vendas.domain.entities.ItemPedido;
import io.github.jaconunes.vendas.domain.entities.Pedido;
import io.github.jaconunes.vendas.domain.entities.Produto;
import io.github.jaconunes.vendas.domain.enums.StatusPedido;
import io.github.jaconunes.vendas.domain.repository.ClientesRepository;
import io.github.jaconunes.vendas.domain.repository.ItensPedidoRespository;
import io.github.jaconunes.vendas.domain.repository.PedidosRepository;
import io.github.jaconunes.vendas.domain.repository.ProdutosRepository;
import io.github.jaconunes.vendas.exception.RegraNegocioException;
import io.github.jaconunes.vendas.rest.dto.ItemPedidoDTO;
import io.github.jaconunes.vendas.rest.dto.PedidoDTO;
import io.github.jaconunes.vendas.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PedidoServiceImpl implements PedidoService {

    private final PedidosRepository pedidosRepository;
    private final ClientesRepository clientesRepository;
    private final ProdutosRepository produtosRepository;
    private final ItensPedidoRespository itensPedidoRespository;

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository.findById(idCliente).orElseThrow(
                () -> new RegraNegocioException("Código de cliente inválido!")
        );
        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);
        pedido.setStatus(StatusPedido.REALIZADO);

        List<ItemPedido> itemsPedido = converterItems(pedido, dto.getItems());
        pedidosRepository.save(pedido);
        itensPedidoRespository.saveAll(itemsPedido);
        pedido.setItens(itemsPedido);
        return pedido;
    }

    @Override
    public Optional<Pedido> obterPedidoCompleto(Integer id) {
        return pedidosRepository.findByIdFetchItens(id);
    }

    private List<ItemPedido> converterItems(Pedido pedido, List<ItemPedidoDTO> items){
        if(items.isEmpty()){
            throw new RegraNegocioException("Não é possível realizar um pedido sem itens!");
        }

        return items
                .stream()
                .map( dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtosRepository
                            .findById(idProduto)
                            .orElseThrow(
                                    () -> new RegraNegocioException("Código de produto inválido: "+ idProduto)
                            );
                        ItemPedido itemPedido = new ItemPedido();
                        itemPedido.setQuantidade(dto.getQuantidade());
                        itemPedido.setPedido(pedido);
                        itemPedido.setProduto(produto);

                        return itemPedido;
                } ).collect(Collectors.toList());
    }

}
