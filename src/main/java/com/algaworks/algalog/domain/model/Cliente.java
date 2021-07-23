package com.algaworks.algalog.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Gera os equals e os hash para os atributos escolhidos.
@Getter
@Setter
@Entity // Define que a classe pertence a uma entidade.
        // O mesmo já busca o nome da classe como o nome da tabela no banco.
// Caso o nome da tabela seja diferente do nome da classe se usa o @Table(name = "nomeTabela").
public class Cliente {

    @EqualsAndHashCode.Exclude // Seleciona para gerar os equals e hash code.
    @Id // Identifica a chave primária.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a geração do Id para o padrão do banco(deixa como auto incremento)
    private Long id;

    @NotBlank // Impede que a propriedade receba um valor vazio ou nulo.
    @Size(max = 60) // Define para 60 caracteres ao atributo nome.
    private String nome;

    @NotBlank
    @Email // Verifica se o email está na sintaxe correta.
    @Size(max = 255)
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "fone") // Representa o nome da coluna no banco. Caso seja o mesmo não precisa da anotação.
    private String telefone;

}
