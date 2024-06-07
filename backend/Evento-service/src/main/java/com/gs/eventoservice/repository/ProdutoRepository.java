package com.gs.eventoservice.repository;

import com.gs.eventoservice.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
