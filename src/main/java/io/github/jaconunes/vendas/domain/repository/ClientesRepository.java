package io.github.jaconunes.vendas.domain.repository;


import io.github.jaconunes.vendas.domain.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Cliente, Integer> {


}
