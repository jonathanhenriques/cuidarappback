package com.cuidar.domain.model.PacienteED;

import com.cuidar.domain.model.ContatoED.ContatoED;
import com.cuidar.domain.model.ExameED.ExameED;
import com.cuidar.domain.model.EnderecoED.EnderecoED;
import lombok.*;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_PACIENTE")
public class PacienteED {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PACIENTE_ID")
    private Long id;


    @NotBlank(message = "nome {campo.texto.notBlank.obrigatorio}")
    @Size(max = 100, min = 3, message = "nome {campo.texto.sizeMax} 100")
    @Column(name = "NOME", nullable = false, length = 100)
    private String nome;


    @DateTimeFormat(pattern = "dd-MM-yyyy")
//    @CreationTimestamp
    @Column(name = "DATA_NASC", nullable = true, columnDefinition = "TIMESTAMP")
    private LocalDateTime dataNasc;

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

    @Column(name = "IS_DEFICIENTE", nullable = false, columnDefinition = "BIT")
    private Boolean deficiente;

    @Column(name = "DEFICIENCIA", nullable = true, length = 50)
    private String deficiencia;

    @Column(name = "DEFICIENCIA_FAMILIA", nullable = true)
    private String deficienciaFamilia;

    @Column(name = "IS_CONVENIO", nullable = true, columnDefinition = "BIT")
    private Boolean convenio;

    @Column(name = "OBSERVACAO", nullable = true, length = 500)
    private String observacao;

    @Column(name = "IS_ACEITE", nullable = false, columnDefinition = "BIT")
    private Boolean aceite; //substitui assinatura

    @ElementCollection
    @CollectionTable(name = "TB_ATENDENTE", joinColumns = @JoinColumn(name = "ID_PACIENTE"))
    @Column(name = "ID_ATENDENTE")
    private List<String> atendente;

    @ElementCollection
    @CollectionTable(name = "TB_MEDICO_ATENDENTE", joinColumns = @JoinColumn(name = "ID_PACIENTE"))
    @Column(name = "ID_MEDICO_ATENDENTE")
    private List<String> medicoAtendente;

//    @ElementCollection
//    @CollectionTable(name = "TB_EXAME", joinColumns = @JoinColumn(name = "ID_PACIENTE"))
    @Column(name = "ID_EXAME")
    @OneToMany(mappedBy = "paciente",orphanRemoval = true)
    @Cascade(CascadeType.ALL)
//    @JoinTable(name = "TB_PACIENTE_EXAME", joinColumns = @JoinColumn(name = "ID_PACIENTE", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "ID_EXAME", referencedColumnName = "id"))
    private List<ExameED> exames;

    @ElementCollection
    @CollectionTable(name = "TB_LOCAL_ATENDIMENTO", joinColumns = @JoinColumn(name = "ID_PACIENTE"))
    @Column(name = "ID_LOCAL_ATENDIMENTO")
    private List<String> local;


    @Column(name = "INDICACAO", nullable = true, length = 100)
    private String indicacao;

    @Column(name = "IS_ATIVO", nullable = false, columnDefinition = "BIT")
    private Boolean isAtivo;

    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DATA_CADASTRO", nullable = true, columnDefinition = "TIMESTAMP")
    private LocalDateTime dataCadastro;


}
