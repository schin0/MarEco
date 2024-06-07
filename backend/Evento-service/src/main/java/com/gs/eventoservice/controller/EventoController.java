package com.gs.eventoservice.controller;

import com.gs.eventoservice.model.Evento;
import com.gs.eventoservice.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/evento")
public class EventoController {

    private EventoService eventoService;

    @Autowired
    public EventoController(EventoService eventoService){
        this.eventoService = eventoService;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/cadastrar")
    public ResponseEntity cadatrarEvento(@RequestBody Evento evento){
        return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.cadastrar(evento));
    }
    @CrossOrigin(origins = "*")
    @GetMapping("/listar")
    public ResponseEntity listarEvento(){
        return ResponseEntity.ok(eventoService.listar());
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/obterPorId/{id}")
    public ResponseEntity obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(eventoService.obterPorId(id));
    }

}
