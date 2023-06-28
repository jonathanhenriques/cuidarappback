package com.cuidar.domain.Exceptions;

public class LocalNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public LocalNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public LocalNaoEncontradoException(Long exameId) {
        this(String.format("Não existe um cadastro de local com código: %d", exameId));
    }

}