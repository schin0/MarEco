package com.gs.ocorrenciaservice.service;

import com.gs.ocorrenciaservice.model.IncidenteCosteiro;
import com.gs.ocorrenciaservice.repository.IncidenteCosteiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IncidenteCosteiroService {

    private IncidenteCosteiroRepository incidenteCosteiroRepository;

    @Autowired
    public IncidenteCosteiroService(IncidenteCosteiroRepository incidenteCosteiroRepository){
        this.incidenteCosteiroRepository = incidenteCosteiroRepository;
    }

    public IncidenteCosteiro cadastrar(IncidenteCosteiro incidenteCosteiro){
        return incidenteCosteiroRepository.save(incidenteCosteiro);
    }
}
