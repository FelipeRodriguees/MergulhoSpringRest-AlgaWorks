package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private SolicitacaoEntregaService solicitacaoEntregaService;

    @PostMapping
    public Entrega solicitar(@RequestBody Entrega entrega) {
        return solicitacaoEntregaService.solicitar(entrega);
    }

}
