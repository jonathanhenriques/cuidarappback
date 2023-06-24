package com.cuidar.domain.model.paciente;


import com.cuidar.domain.model.contato.ContatoED;
import com.cuidar.domain.model.endereco.EnderecoED;
import com.cuidar.domain.model.enuns.EstadoCivil;
import com.cuidar.domain.model.exame.ExameED;
import com.cuidar.domain.model.exame.ExameRequest;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PacienteRequest {

    @EqualsAndHashCode.Include
    private Long id;

    private String nome;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataNasc;

    @Positive(message = "idade não pode ser negativa")
    private Integer idade;


    private String RG;

    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @PositiveOrZero(message = "Qtd filhos não pode ser negativo")
    private Integer filhos;

    private String nomeResponsavelPaciente;

    @Embedded
    private ContatoED contato;

    private String profissao;

    @Embedded
    private EnderecoED endereco;

    private Boolean deficiente;

    private String deficiencia;

    private String deficienciaFamilia;

    private Boolean convenio;

    private String observacao;

    private Boolean aceite; //substitui assinatura

    private List<ExameRequest> exames;

    private String indicacao;

    private Boolean isAtivo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    private LocalDate dataCadastro;


}
