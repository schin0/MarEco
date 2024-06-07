package com.gs.eventoservice.controller;

import com.gs.eventoservice.model.Produto;
import com.gs.eventoservice.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    private ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService){
        this.produtoService = produtoService;
    }


    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarProduto(@RequestBody Produto produto){
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.cadastrar(produto));
    }
    @GetMapping("/listar")
    public ResponseEntity listarProduto(){
        return ResponseEntity.ok(produtoService.listar());
    }

}
