package com.gs.ocorrenciaservice.controller;

import com.gs.ocorrenciaservice.model.IncidenteCosteiro;
import com.gs.ocorrenciaservice.service.IncidenteCosteiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/incidenteCosteiro")
public class IncidenteCosteiroController {

    private IncidenteCosteiroService incidenteCosteiroService;

    @Autowired
    public IncidenteCosteiroController(IncidenteCosteiroService incidenteCosteiroService){
        this.incidenteCosteiroService = incidenteCosteiroService;
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/cadastrar")
    public ResponseEntity cadastrarIncidente(@RequestBody IncidenteCosteiro incidenteCosteiro){
        return ResponseEntity.status(HttpStatus.CREATED).body(incidenteCosteiroService.cadastrar(incidenteCosteiro));
    }
}
