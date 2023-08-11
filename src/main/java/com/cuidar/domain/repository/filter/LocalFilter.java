package com.cuidar.domain.repository.filter;


import lombok.Getter;
import lombok.Setter;

/**Classe destinada ao ExameSpecification*/
@Getter
@Setter
public class LocalFilter {

   private Long id;

   private String nomeLocal;

   private Boolean isAtivo;

   private String endRua;

   private String endBairro;

   private String endCep;

   private String endNumero;

   private String endCidade;

   private String endTipoResidencia;

}
