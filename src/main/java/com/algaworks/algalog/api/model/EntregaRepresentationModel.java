package com.algaworks.algalog.api.model;

import com.algaworks.algalog.domain.model.Cliente;
import com.algaworks.algalog.domain.model.StatusEntrega;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class EntregaRepresentationModel {

    private Long id;
    private ClienteSimpleModel cliente;
    private DestinatarioRepresentationModel destinatario;
    private BigDecimal taxa;
    private StatusEntrega status;
    private OffsetDateTime dataPedido;
    private OffsetDateTime dateFinalizacao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteSimpleModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteSimpleModel cliente) {
        this.cliente = cliente;
    }

    public DestinatarioRepresentationModel getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(DestinatarioRepresentationModel destinatario) {
        this.destinatario = destinatario;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }

    public StatusEntrega getStatus() {
        return status;
    }

    public void setStatus(StatusEntrega status) {
        this.status = status;
    }

    public OffsetDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(OffsetDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public OffsetDateTime getDateFinalizacao() {
        return dateFinalizacao;
    }

    public void setDateFinalizacao(OffsetDateTime dateFinalizacao) {
        this.dateFinalizacao = dateFinalizacao;
    }
}
