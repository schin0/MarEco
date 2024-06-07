package com.gs.eventoservice.service;

import com.gs.eventoservice.model.Evento;
import com.gs.eventoservice.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    private EventoRepository eventoRepository;

    @Autowired
    public EventoService(EventoRepository eventoRepository){
        this.eventoRepository = eventoRepository;
    }

    public Evento cadastrar(Evento evento){
        return eventoRepository.save(evento);
    }

    public List<Evento> listar() {
        return eventoRepository.findAll();
    }

    public Optional<Evento> obterPorId(Long id) {
        return eventoRepository.findById(id);
    }
}
