package com.cuidar.api.model;

import com.cuidar.api.core.validation.Groups;
import com.cuidar.domain.model.ContatoED;
import com.cuidar.domain.model.EnderecoED;
import com.cuidar.domain.model.ExameED;
import com.cuidar.domain.model.enuns.EstadoCivil;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

//import org.hibernate.annotations.Cascade;
//import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;


import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PacienteModel {


    @NotNull(groups = Groups.PacienteId.class)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

//    @Column(name = "UUID", nullable = false)
//    private UUID codigo;


    @NotBlank
    @Size(max = 100, min = 3)
    @Column(name = "NOME", nullable = true, length = 100)
    @JsonAlias({"nome", "nomePaciente", "nome_Paciente"})
    private String nome;


    //    @DateTimeFormat(pattern = "dd-MM-yyyy")
//    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATA_NASC", nullable = true, columnDefinition = "TIMESTAMP")
    private LocalDate dataNasc;

    //    @NotBlank(message = "idade {campo.texto.notBlank.obrigatorio}")
    @Positive
    @Column(name = "IDADE", nullable = true)
//    //formula para calcular a idade com base na dataNasc
//    @Formula("YEAR(CURRENT_DATE) - YEAR(data_nascimento)" +
//            " - (CASE WHEN MONTH(CURRENT_DATE) < MONTH(data_nascimento)" +
//            " THEN 1 WHEN MONTH(CURRENT_DATE) = MONTH(data_nascimento)" +
//            " AND DAY(CURRENT_DATE) < DAY(data_nascimento)" +
//            " THEN 1 ELSE 0 END)")
    private Integer idade;

    @Column(name = "RG", nullable = true, length = 9)
    private String RG;

    @Enumerated(EnumType.STRING)
    @Column(name = "ESTADO_CIVIL", nullable = true, length = 10)
    private EstadoCivil estadoCivil;

    @PositiveOrZero
    @Column(name = "HAS_FILHOS", nullable = true)
    private Integer filhos;

    @Column(name = "NOME_RESPONSAVEL_PACIENTE", nullable = true, length = 100)
    private String nomeResponsavelPaciente;

    @Embedded
    private ContatoED contato;

    @Column(name = "PROFISSAO", nullable = true, length = 30)
    private String profissao;

    @Embedded
    private EnderecoED endereco;

    @Column(name = "DEFICIENTE", nullable = true)
    private Boolean deficiente;

    @Column(name = "DEFICIENCIA", nullable = true, length = 100)
    private String deficiencia;

    @Column(name = "DEFICIENCIA_FAMILIA", nullable = true, length = 100)
    private String deficienciaFamilia;

    @Column(name = "HAS_CONVENIO")
    private Boolean convenio;

    @Column(name = "OBSERVACAO", length = 360)
    private String observacao;

    @Column(name = "IS_ACEITE")
    private Boolean aceite; //substitui assinatura

    private List<ExameModel> exames;

    @Column(name = "INDICACAO", length = 100)
    private String indicacao;

    @Column(name = "IS_ATIVO")
    private Boolean isAtivo;


}

