package com.cuidar.domain.model.paciente;


import com.cuidar.domain.model.enuns.EstadoCivil;
import com.cuidar.domain.model.contato.ContatoED;
import com.cuidar.domain.model.endereco.EnderecoED;
import com.cuidar.domain.model.exame.ExameED;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_PACIENTE")
public class PacienteED {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


//    @NotBlank(message = "nome {campo.texto.notBlank.obrigatorio}")
    @Size(max = 100, min = 3, message = "nome {campo.texto.sizeMax} 100")
    @Column(name = "NOME", nullable = true, length = 100)
    private String nome;


//    @DateTimeFormat(pattern = "dd-MM-yyyy")
//    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "DATA_NASC", nullable = true, columnDefinition = "TIMESTAMP")
    private LocalDate dataNasc;

//    @NotBlank(message = "idade {campo.texto.notBlank.obrigatorio}")
    @Positive(message = "idade não pode ser negativa")
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

    @PositiveOrZero(message = "Qtd filhos não pode ser negativo")
    @Column(name = "FILHOS", nullable = true)
    private Integer filhos;

    @Column(name = "NOME_RESPONSAVEL_PACIENTE", nullable = true, length = 100)
    private String nomeResponsavelPaciente;

    @Embedded
    private ContatoED contato;

    @Column(name = "PROFISSAO", nullable = true, length = 30)
    private String profissao;

    @Embedded
    private EnderecoED endereco;

    @Column(name = "IS_DEFICIENTE", nullable = true, columnDefinition = "BIT")
    private Boolean deficiente;

    @Column(name = "DEFICIENCIA", nullable = true, length = 50)
    private String deficiencia;

    @Column(name = "DEFICIENCIA_FAMILIA", nullable = true)
    private String deficienciaFamilia;

    @Column(name = "IS_CONVENIO", nullable = true, columnDefinition = "BIT")
    private Boolean convenio;

    @Column(name = "OBSERVACAO", nullable = true, length = 500)
    private String observacao;

    @Column(name = "IS_ACEITE", nullable = true, columnDefinition = "BIT")
    private Boolean aceite; //substitui assinatura

//    @ElementCollection
//    @CollectionTable(name = "TB_ATENDENTE", joinColumns = @JoinColumn(name = "ID_PACIENTE"))
//    @Column(name = "ID_ATENDENTE")
//    private List<String> atendente;
//
//    @ElementCollection
//    @CollectionTable(name = "TB_MEDICO_ATENDENTE", joinColumns = @JoinColumn(name = "ID_PACIENTE"))
//    @Column(name = "ID_MEDICO_ATENDENTE")
//    private List<String> medicoAtendente;

//    @ElementCollection
//    @CollectionTable(name = "TB_EXAME", joinColumns = @JoinColumn(name = "ID_PACIENTE"))
    @Column(name = "ID_EXAME")
    @OneToMany(mappedBy = "paciente")
    @Cascade(CascadeType.MERGE)
//    @JoinTable(name = "TB_PACIENTE_EXAME", joinColumns = @JoinColumn(name = "ID_PACIENTE", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "ID_EXAME", referencedColumnName = "id"))
//    @JsonIgnoreProperties(value = {
////            "id",
//            "paciente",
////            "nomeExame",
//            "medico",
//            "local",
//            "dataExame",
//            "valor",
//            "atendente",
//            "observacao"
//    })
    private List<ExameED> exames;

//    @ElementCollection
//    @CollectionTable(name = "TB_LOCAL_ATENDIMENTO", joinColumns = @JoinColumn(name = "ID_PACIENTE"))
//    @Column(name = "ID_LOCAL_ATENDIMENTO")
//    private List<String> local;


    @Column(name = "INDICACAO", nullable = true, length = 100)
    private String indicacao;

    @Column(name = "IS_ATIVO", nullable = true, columnDefinition = "BIT")
    private Boolean isAtivo;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CADASTRO", nullable = true, columnDefinition = "TIMESTAMP")
    private LocalDate dataCadastro;


}
