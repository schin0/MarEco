package com.gs.eventoservice.repository;

import com.gs.eventoservice.model.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventoRepository extends JpaRepository<Evento, Long> {
}
