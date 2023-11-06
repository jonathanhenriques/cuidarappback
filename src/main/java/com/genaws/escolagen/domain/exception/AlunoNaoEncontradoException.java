package com.genaws.escolagen.domain.exception;

public class AlunoNaoEncontradoException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public AlunoNaoEncontradoException(String mensagem) {
        super(String.format("Não existe um cadastro de aluno com código: %s", mensagem));
//        super(String.format(mensagem));
    }





}