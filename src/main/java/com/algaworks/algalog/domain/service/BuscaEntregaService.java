package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.EntidadeNaoEncontradaExcption;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega busca(Long entregaId) {
        Entrega entrega = entregaRepository.findById(entregaId).
                orElseThrow(() -> new EntidadeNaoEncontradaExcption("Entrega não encontrada"));
        return entrega;
    }
}
