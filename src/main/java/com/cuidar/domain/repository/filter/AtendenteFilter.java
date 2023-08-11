package com.cuidar.domain.repository.filter;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**Classe destinada ao ExameSpecification*/
@Getter
@Setter
public class AtendenteFilter {

   private Long id;

   private String nome;

   private Boolean isAtivo;

}
