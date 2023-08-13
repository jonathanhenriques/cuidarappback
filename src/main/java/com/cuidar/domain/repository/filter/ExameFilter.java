package com.cuidar.domain.repository.filter;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.OffsetDateTime;

/**Classe destinada ao ExameSpecification*/
@Getter
@Setter
public class ExameFilter {

   private Long id;

    private String codigo;

    private Long pacienteId;

    private String pacienteNomeResponsavel;

    private String pacienteIndicacao;

   private String pacienteCodigo;

    private String pacienteRG;

   private String nomeExame;

   private Long medicoId;

    private Long localId;

    private Long atendenteId;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate dataExame;

    private BigDecimal valor;


    private Boolean isAtivo;

}
