package com.algaworks.algalog.api.assembler;

import com.algaworks.algalog.api.model.EntregaRepresentationModel;
import com.algaworks.algalog.api.model.inputModel.EntregaInputModel;
import com.algaworks.algalog.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaAssembler {

    private ModelMapper modelMapper;

    public EntregaRepresentationModel toModel(Entrega entrega) {
        return modelMapper.map(entrega, EntregaRepresentationModel.class);
    }

    public List<EntregaRepresentationModel> toCollectionModel(List<Entrega> entregas) {
        return entregas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaInputModel entregaInputModel) {
        return modelMapper.map(entregaInputModel, Entrega.class);
    }
}
