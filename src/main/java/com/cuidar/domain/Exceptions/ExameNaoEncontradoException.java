package com.cuidar.domain.Exceptions;

public class ExameNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public ExameNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public ExameNaoEncontradoException(Long exameId) {
        this(String.format("Não existe um cadastro de exame com código: %d", exameId));
    }

}