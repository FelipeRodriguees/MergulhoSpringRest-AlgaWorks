package com.algaworks.algalog.api.controller;

import com.algaworks.algalog.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar(){

        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Felipe Rodrigues");
        cliente1.setEmail("2000feliperodrigues@gmail.com");
        cliente1.setTelefone("+55 (42) 98442-4077");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Gilmar Soares");
        cliente2.setEmail("gilmar@gmail.com");
        cliente2.setTelefone("+55 (42) 92212-7840");

        return Arrays.asList(cliente1, cliente2);
    }
}
