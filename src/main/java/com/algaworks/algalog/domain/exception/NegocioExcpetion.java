package com.algaworks.algalog.domain.exception;

public class NegocioExcpetion extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public NegocioExcpetion(String message) {
        super(message);
    }
}
