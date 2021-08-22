package com.algaworks.algalog.api.model.inputModel;

import javax.validation.constraints.NotNull;

public class ClienteInputModel {

    @NotNull
    private String nome;

    @NotNull
    private String email;

    @NotNull
    private String telefone;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
