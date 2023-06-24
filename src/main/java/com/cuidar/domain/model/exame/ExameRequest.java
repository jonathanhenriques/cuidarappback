package com.cuidar.domain.model.exame;

import com.cuidar.domain.model.atendente.AtendenteED;
import com.cuidar.domain.model.local.LocalED;
import com.cuidar.domain.model.medico.MedicoED;
import com.cuidar.domain.model.paciente.PacienteED;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ExameRequest {

    @EqualsAndHashCode.Include
    private Long id;

    private PacienteED paciente;

    private String nomeExame;

    private MedicoED medico;

    private LocalED local;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @CreationTimestamp
    private LocalDateTime dataExame;

    private BigDecimal valor;

    private AtendenteED atendente;

    private String observacao;

}
