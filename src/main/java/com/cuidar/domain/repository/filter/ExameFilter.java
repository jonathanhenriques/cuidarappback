package com.cuidar.domain.repository.filter;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class ExameFilter {

   private Long id;
   private Long pacienteId;
   private String nomeExame;
   private Long medicoId;

    private Long localId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dataExame;

    private BigDecimal valor;

    private Long atendenteId;

    private Boolean situacao;

}
