package com.cuidar.domain.service;

import com.cuidar.api.PacienteResponseMin;
import com.cuidar.domain.model.PacienteED;

import java.util.List;

public interface EstatisticasQueryService {

    List<PacienteED> consultarQuantidadePacientesCadasrados();
}
