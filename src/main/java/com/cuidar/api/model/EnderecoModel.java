package com.cuidar.api.model;

import com.cuidar.domain.model.enuns.TipoResidencia;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class EnderecoModel {


//    @Id
//    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "END_RUA", nullable = true, length = 75)
    private String endRua;

    @Column(name = "END_NUMERO", nullable = true, length = 20)
//    @Positive(message = "numero não pode ser negativo")
    private String endNumero;

    @Column(name = "END_BAIRRO", nullable = true, length = 50)
    private String endBairro;

    @Column(name = "END_CIDADE", nullable = true, length = 50)
    private String endCidade;

    @Column(name = "END_CEP", nullable = true, length = 11)
    private String endCep;

    @Enumerated(EnumType.STRING)
    @Column(name = "END_TIPO_RESIDENCIA", nullable = true, length = 11)
    private TipoResidencia endTipoResidencia;
    private String endObservacao;
}