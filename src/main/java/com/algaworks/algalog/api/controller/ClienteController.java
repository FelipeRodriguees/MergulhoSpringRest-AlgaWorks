package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.assembler.ClienteAssembler;
import com.algaworks.algalog.api.model.ClienteRepresentationModel;
import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.repository.ClienteRepository;
import com.algaworks.algalog.domain.service.CatalogoClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;
    private CatalogoClienteService catalogoClienteService;
    private ClienteAssembler clienteAssembler;

    @GetMapping
    public List<ClienteRepresentationModel> listar(){
        List<Cliente> clientes = catalogoClienteService.listar();
        return clienteAssembler.toCollectionModel(clientes);
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<ClienteRepresentationModel> buscar(@PathVariable Long clienteId) { // @PathVariable define um caminho para a variável que virá na requisição.
        return clienteRepository.findById(clienteId)
                .map(cliente -> ResponseEntity.ok(clienteAssembler.toModel(cliente)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED) // Se tudo ocorrer de forma correta ele retorna o status 201 Created
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) { // @RequestBody transforma o JSON que virá na requisição em um cliente.
        return catalogoClienteService.salvar(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<ClienteRepresentationModel> atualziar(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente) {
        if(!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        Cliente answer = catalogoClienteService.salvar(cliente);

        return ResponseEntity.ok(clienteAssembler.toModel(answer));
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
        if (!clienteRepository.existsById(clienteId)) {
            return ResponseEntity.notFound().build();
        }
        catalogoClienteService.excluir(clienteId);
        return ResponseEntity.noContent().build();
    }
}
