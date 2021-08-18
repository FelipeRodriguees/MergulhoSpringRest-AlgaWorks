package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.api.model.DestinatarioRepresentationModel;
import com.algaworks.algalog.api.model.EntregaRepresentationModel;
import com.algaworks.algalog.domain.model.Entrega;
import com.algaworks.algalog.domain.repository.EntregaRepository;
import com.algaworks.algalog.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaRepository entregaRepository;
    private SolicitacaoEntregaService solicitacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody Entrega entrega) {

        return solicitacaoEntregaService.solicitar(entrega);
    }

    @GetMapping
    public List<Entrega> listar(){
        return entregaRepository.findAll();
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaRepresentationModel> buscar(@PathVariable Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> {
                    EntregaRepresentationModel entregaRepresentationModel = new EntregaRepresentationModel();

                    entregaRepresentationModel.setId(entrega.getId());
                    entregaRepresentationModel.setNomeCliente(entrega.getCliente().getNome());

                    DestinatarioRepresentationModel destinatarioRepresentationModel = new DestinatarioRepresentationModel();
                    destinatarioRepresentationModel.setNome(entrega.getDestinatario().getNome());
                    destinatarioRepresentationModel.setLogradouro(entrega.getDestinatario().getLogradouro());
                    destinatarioRepresentationModel.setNumero(entrega.getDestinatario().getNumero());
                    destinatarioRepresentationModel.setComplemento(entrega.getDestinatario().getNumero());
                    destinatarioRepresentationModel.setComplemento(entrega.getDestinatario().getComplemento());
                    destinatarioRepresentationModel.setBairro(entrega.getDestinatario().getBairro());

                    entregaRepresentationModel.setDestinatario(destinatarioRepresentationModel);
                    entregaRepresentationModel.setTaxa(entrega.getTaxa());
                    entregaRepresentationModel.setStatus(entrega.getStatus());
                    entregaRepresentationModel.setDataPedido(entrega.getDataPedido());
                    entregaRepresentationModel.setDateFinalizacao(entrega.getDataFinalizacao());


                    return ResponseEntity.ok(entregaRepresentationModel);
                }).orElse(ResponseEntity.notFound().build());
    }
}
