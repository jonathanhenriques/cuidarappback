package com.cuidar.domain.Exceptions;

public class MedicoNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public MedicoNaoEncontradoException(String mensagem) {
        super(mensagem);
    }

    public MedicoNaoEncontradoException(Long exameId) {
        this(String.format("Não existe um cadastro de médico com código: %d", exameId));
    }

}