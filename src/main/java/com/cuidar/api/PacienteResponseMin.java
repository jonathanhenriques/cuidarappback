package com.cuidar.api;

import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
public class PacienteResponseMin {

    private Long PacienteId;
    private String PacienteNome;
//    private Date dataCadastro;
}
