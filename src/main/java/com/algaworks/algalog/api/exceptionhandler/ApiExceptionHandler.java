package com.algaworks.algalog.api.exceptionhandler;

import com.algaworks.algalog.domain.exception.EntidadeNaoEncontradaExcption;
import com.algaworks.algalog.domain.exception.NegocioExcpetion;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice // Diz que a classe é um componente do Sptring e também fala que a mesma pode tratar exceções de forma global.
public class ApiExceptionHandler  extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Problem.Campo> campos = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            String nome = ((FieldError) error).getField();
            String mensagem = error.getDefaultMessage();

            campos.add(new Problem.Campo(nome,mensagem));
        }

        Problem problem = new Problem();
        problem.setStatus(status.value());
        problem.setDataHora(OffsetDateTime.now());
        problem.setTitulo("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.");
        problem.setCampos(campos);

        return handleExceptionInternal(ex, problem, headers, status, request);
    }

    @ExceptionHandler(EntidadeNaoEncontradaExcption.class)
    public ResponseEntity<Object> handleNegocio(EntidadeNaoEncontradaExcption ex, WebRequest request) {

        HttpStatus status = HttpStatus.NOT_FOUND;

        Problem problem = new Problem();
        problem.setStatus(status.value());
        problem.setDataHora(OffsetDateTime.now());
        problem.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }

    @ExceptionHandler(NegocioExcpetion.class) // Referência a classe NegocioException para tratar o erro.
    public ResponseEntity<Object> handleNegocio(NegocioExcpetion ex, WebRequest request) {

        HttpStatus status = HttpStatus.BAD_REQUEST;

        Problem problem = new Problem();
        problem.setStatus(status.value());
        problem.setDataHora(OffsetDateTime.now());
        problem.setTitulo(ex.getMessage());

        return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
    }
}
