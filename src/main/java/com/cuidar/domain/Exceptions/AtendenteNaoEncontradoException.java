package com.cuidar.domain.Exceptions;

public class AtendenteNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public AtendenteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public AtendenteNaoEncontradoException(Long exameId) {
        this(String.format("Não existe um cadastro de atendente com código: %d", exameId));
    }

}