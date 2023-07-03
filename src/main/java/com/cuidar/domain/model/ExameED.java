package com.cuidar.domain.model;

import com.cuidar.api.core.validation.ValorExame;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_EXAME")
//@ValorZeroIncluiDescricao(valorField = "valor", descricaoField = "nomeExame", descricaoObrigatoria = "Frete Gratis")
public class ExameED {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

//    @NotBlank(message = " nomePaciente {campo.texto.notBlank.obrigatorio}")
//    @Column(name = "NOME_PACIENTE", nullable = false, length = 100)
//    private String nomePaciente;

//    @Column(name = "PACIENTE_ID")

    @ManyToOne
    @JoinColumn( name = "PACIENTE_ID",nullable = false)
//    @JsonIgnore
//    @JsonIgnoreProperties(value = {
//            "dataNasc",
//            "idade",
//            "rg",
//            "estadoCivil",
//            "filhos",
//            "nomeResponsavelPaciente",
//            "contato",
//            "profissao",
//            "endereco",
//            "deficiente",
//            "deficiencia",
//            "deficienciaFamilia",
//            "convenio",
//            "observacao",
//            "aceite",
//            "exames",
//            "indicacao",
//            "isAtivo",
//            "dataCadastro"
//    },  allowSetters = true, allowGetters = true)
    @JsonIgnoreProperties(value = {"exames"})
    private PacienteED paciente;

    @NotBlank
    @Column(name = "NOME_EXAME", nullable = false, length = 100)
    private String nomeExame;

    @Valid
//    @NotBlank(message = "medico {campo.texto.notBlank.obrigatorio}")
//    @Column(name = "MEDICO_ID", nullable = true)
    @OneToOne
    @JsonIgnoreProperties({"isAtivo"})
    private MedicoED medico;

    @Valid
//    @NotBlank(message = "local {campo.texto.notBlank.obrigatorio}")
//    @Column(name = "LOCAL_ID", nullable = true)
    @OneToOne
    @JsonIgnoreProperties({"endereco"})
    private LocalED local;

//    @JsonIgnoreProperties(value = {"nome", "dataNasc", "observacao", "valor", "dataExame","rg", "dataCadastro","isAtivo","indicacao", "local","medicoAtendente",
//            "atendente","aceite","observacao","convenio", "deficienciaFamilia", "deficiencia", "deficiente", "endereco","profissao", "contato","nomeResponsavelPaciente",
//            "filhos", "estadoCivil", "idade", "exames"})
////    @NotBlank(message = "paciente {campo.texto.notBlank.obrigatorio}")
////    @Column(name = "ID_PACIENTE", nullable = false)
//    @ManyToOne
//    @JoinColumn(name = "ID_PACIENTE")
//    private PacienteED paciente;

    @JsonFormat(pattern = "yyyy-MM-dd")
//    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @CreationTimestamp
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(nullable = false, columnDefinition = "datetime")
    @Column(name = "DATA_EXAME", nullable = false, columnDefinition = "TIMESTAMP")
    private OffsetDateTime dataExame;

    @NotNull
    @ValorExame
//    @PositiveOrZero
//    @Multiplo(numero = 1)
    @DecimalMin("0.00")
    @Digits(integer=10, fraction=2)
    @Column(name = "VALOR", nullable = false, precision = 10, scale = 2)
    private BigDecimal valor;

    @Valid
//    @NotBlank(message = "atendente {campo.texto.notBlank.obrigatorio}")
//    @Column(name = "ATENDENTE_ID")
    @OneToOne
    @JsonIgnoreProperties({"isAtivo"})
    private AtendenteED atendente;

    //    @ElementCollection
//    @CollectionTable(name = "TB_ATENDENTE", joinColumns = @JoinColumn(name = "ID_PACIENTE"))
//    @Column(name = "ID_ATENDENTE")
//    private List<String> atendente;
//
//    @ElementCollection
//    @CollectionTable(name = "TB_MEDICO_ATENDENTE", joinColumns = @JoinColumn(name = "ID_PACIENTE"))
//    @Column(name = "ID_MEDICO_ATENDENTE")
//    private List<String> medicoAtendente;

    @Column(name = "OBSERVACAO", length = 500)
    private String observacao;


    @Column(name = "Situacao", nullable = false, length = 9, columnDefinition = "tinyint(1) DEFAULT 1 not null")
    private Boolean situacao = Boolean.TRUE;


    public void cancelar(){
        this.setSituacao(false);
    }

}
