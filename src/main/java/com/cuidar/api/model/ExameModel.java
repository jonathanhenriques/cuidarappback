package com.cuidar.api.model;

import com.cuidar.domain.model.AtendenteED;
import com.cuidar.domain.model.LocalED;
import com.cuidar.domain.model.MedicoED;
import com.cuidar.domain.model.PacienteED;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class ExameModel {

    private Long id;
    private PacienteED paciente;
    private String nomeExame;
    private MedicoED medico;
    private LocalED local;
    private BigDecimal valor;
    private AtendenteED atendente;
    private String observacao;

}
