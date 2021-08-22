package com.algaworks.algalog.api.assembler;

import com.algaworks.algalog.api.model.ClienteRepresentationModel;
import com.algaworks.algalog.domain.model.Cliente;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class ClienteAssembler {

    ModelMapper modelMapper;

    public ClienteRepresentationModel toModel(Cliente cliente) {
        return modelMapper.map(cliente, ClienteRepresentationModel.class);
    }

    public List<ClienteRepresentationModel> toCollectionModel(List<Cliente> clientes) {
        return clientes.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }
}