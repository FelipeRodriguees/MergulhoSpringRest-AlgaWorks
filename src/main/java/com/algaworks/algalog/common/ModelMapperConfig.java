package com.algaworks.algalog.common;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Define que esta classe é um componente de definição de beans.
public class ModelMapperConfig {

    @Bean // Determina que este metodo instancia e configura um bean gerenciado pelo Sptring
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
