package com.cuidar.domain.Exceptions;

public class PacienteNotFoundException extends RuntimeException {
    public PacienteNotFoundException(String paciente, Long id) {
        super(String.format("Paciente não encontrado com : '%s'", id, id));
    }


}
