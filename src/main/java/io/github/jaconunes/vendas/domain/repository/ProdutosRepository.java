package io.github.jaconunes.vendas.domain.repository;

import io.github.jaconunes.vendas.domain.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutosRepository extends JpaRepository<Produto, Integer> {

}
