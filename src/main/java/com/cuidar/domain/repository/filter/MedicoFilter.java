package com.cuidar.domain.repository.filter;


import lombok.Getter;
import lombok.Setter;

/**Classe destinada ao ExameSpecification*/
@Getter
@Setter
public class MedicoFilter {

   private Long id;

   private String nome;

   private Boolean isAtivo;

}
