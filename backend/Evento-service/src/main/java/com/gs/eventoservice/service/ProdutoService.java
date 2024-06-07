package com.gs.eventoservice.service;

import com.gs.eventoservice.model.Produto;
import com.gs.eventoservice.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    public Produto cadastrar(Produto produto){
        return produtoRepository.save(produto);
    }

    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

}
