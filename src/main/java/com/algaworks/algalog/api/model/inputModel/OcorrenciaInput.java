package com.algaworks.algalog.api.model.inputModel;

import javax.validation.constraints.NotBlank;

public class OcorrenciaInput {

    @NotBlank
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
