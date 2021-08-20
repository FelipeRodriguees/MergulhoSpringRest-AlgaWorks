package com.algaworks.algalog.api.model.inputModel;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class EntregaInputModel {

    @Valid
    @NotNull
    private ClienteIdInputModel cliente;

    @Valid
    @NotNull
    private DestinatarioInputModel destinatario;

    @Valid
    @NotNull
    private BigDecimal taxa;

    public ClienteIdInputModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteIdInputModel cliente) {
        this.cliente = cliente;
    }

    public DestinatarioInputModel getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(DestinatarioInputModel destinatario) {
        this.destinatario = destinatario;
    }

    public BigDecimal getTaxa() {
        return taxa;
    }

    public void setTaxa(BigDecimal taxa) {
        this.taxa = taxa;
    }
}
