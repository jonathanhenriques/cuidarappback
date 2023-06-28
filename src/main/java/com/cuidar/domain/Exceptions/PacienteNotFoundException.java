package com.cuidar.domain.Exceptions;

public class PacienteNotFoundException extends EntidadeNaoEncontradaException {

    private static final long serialVersionUID = 1L;

    public PacienteNotFoundException(String mensagem) {
        super(mensagem);
    }

    public PacienteNotFoundException(Long pacienteId) {
        this(String.format("Não existe um cadastro de paciente com código: %d", pacienteId));
    }



}
