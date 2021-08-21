package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.NegocioExcpetion;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.model.Ocorrencia;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private EntregaRepository entregaRepository;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao) {
        Entrega entrega = entregaRepository.findById(entregaId).
                orElseThrow(() -> new NegocioExcpetion("Entrega não encontrada"));

        return entrega.adicionarOcorrencia(descricao);
    }
}
