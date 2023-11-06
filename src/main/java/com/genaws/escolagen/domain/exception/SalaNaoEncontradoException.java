package com.genaws.escolagen.domain.exception;

public class SalaNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public SalaNaoEncontradoException(String mensagem) {
        super(String.format("Não existe um cadastro de sala com código: %s", mensagem));
    }





}