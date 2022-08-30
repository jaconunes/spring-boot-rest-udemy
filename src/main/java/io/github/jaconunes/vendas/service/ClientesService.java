package io.github.jaconunes.vendas.service;

import io.github.jaconunes.vendas.model.Cliente;
import io.github.jaconunes.vendas.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientesService {

    private ClientesRepository repository;

    public ClientesService( ClientesRepository repository){
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente){
        validarCliente(cliente);
        ClientesRepository clientesRepository = new ClientesRepository();
        this.repository.persistir(cliente);
    }

    public void validarCliente(Cliente cliente){
        //validações clientes
    }
}
