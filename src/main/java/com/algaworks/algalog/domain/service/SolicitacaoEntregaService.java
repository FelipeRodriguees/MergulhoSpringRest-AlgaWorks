package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.StatusEntrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private EntregaRepository entregaRepository;

    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(Entrega entrega) {
        entrega.setStatusEntrega(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return entregaRepository.save(entrega);
    }
}
