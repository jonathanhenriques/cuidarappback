package com.cuidar.domain.model.EnderecoED;

import com.cuidar.domain.model.TipoResidencia.TipoResidencia;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Positive;

//@Entity
//@Table(name = "TB_ENDERECO")
@Data
@Embeddable
public class EnderecoED {


//    @Id
//    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
//    private Long id;

    @Column(name = "END_RUA", nullable = true, length = 75)
    private String endRua;

    @Column(name = "END_NUMERO", nullable = true)
    @Positive(message = "numero não pode ser negativo")
    private String endNumero;

    @Column(name = "END_BAIRRO", nullable = true, length = 50)
    private String endBairro;

    @Column(name = "END_CIDADE", nullable = true, length = 50)
    private String endCidade;

    @Column(name = "END_CEP", nullable = true, length = 11)
    private String endCep;

    @Enumerated(EnumType.STRING)
    @Column(name = "END_TIPO_RESIDENCIA", nullable = false, length = 11)
    private TipoResidencia endTipoResidencia;

    @Column(name = "END_OBSERVACAO", nullable = true, length = 100)
    private String endObservacao;
}
