package com.cuidar.domain.repository.filter;


import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

/**Classe destinada ao ExameSpecification*/
@Getter
@Setter
public class PacienteFilter {

   private Long id;

    private String codigo;

    private String nome;

    private String dataNasc;

    private String idade;

   private String RG;

    private String estadoCivil;

   private Long filhos;

   private String nomeResponsavelPaciente;

    private String contatoEmail;

    private String contatoInstagram;

    private Long profissao;

    private String enderecoRua;

    private String enderecoBairro;

    private String enderecoCidade;

    private String enderecoCep;

    private Boolean deficiente;

    private String deficiencia;

    private String convenio;

//    private String exameNome;
//
//    private String exameLocal;
//
//    private String exameDataExame;
//
//    private String exameValor;
//
//    private String exameAtendente;

    private String indicacao;

    private String isAtivo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dataCadastro;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime dataAtualizacao;

//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
//    private OffsetDateTime dataExame;
}
