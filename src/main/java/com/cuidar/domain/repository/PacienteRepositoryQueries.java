package com.cuidar.domain.repository;

import com.cuidar.domain.model.PacienteED;

import java.util.List;

/**
 * Apenas lista o nome dos metodos personalizados
 */
public interface PacienteRepositoryQueries {

    List<PacienteED> find(String nome);
}
