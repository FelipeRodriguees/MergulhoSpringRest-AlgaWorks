package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @GetMapping
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId) { // @PathVariable define um caminho para a variável que virá na requisição.
        return clienteRepository.findById(clienteId)
                .map(cliente -> ResponseEntity.ok(cliente))
                .orElse(ResponseEntity.notFound().build());
// Ambos os códigos fazem a mesma coisa
//        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//        if (cliente.isPresent()) {
//            return ResponseEntity.ok(cliente.get());
//        } else {
//            return ResponseEntity.notFound().build();
//        }
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Se tudo ocorrer de forma correta ele retorna o status 201 Created
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) { // @RequestBody transforma o JSON que virá na requisição em um cliente.
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualziar(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente) {
        if(!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        Cliente answer = clienteRepository.save(cliente);

        return ResponseEntity.ok(answer);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        clienteRepository.deleteById(clienteId);
        return ResponseEntity.noContent().build();
    }
}
