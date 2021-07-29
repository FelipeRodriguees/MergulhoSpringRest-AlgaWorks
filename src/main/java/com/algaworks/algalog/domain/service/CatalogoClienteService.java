package com.algaworks.algalog.domain.service;

import com.algaworks.algalog.domain.exception.NegocioExcpetion;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service // Representa que a classe é um componente Spring com uma semântica de um serviço
public class CatalogoClienteService {

    private ClienteRepository clienteRepository;

    @Transactional // Está anotação da um rollback de todas as alterações no banco caso algo de errado ocorra.
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente.getEmail()));

        if (emailEmUso) {
            throw new NegocioExcpetion("Já existe um cliente com este e-mail!");
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }
}
