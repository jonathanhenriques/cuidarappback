package com.cuidar.domain.repository;


import com.cuidar.domain.model.paciente.PacienteED;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteDB extends JpaRepository<PacienteED, Long> {

    Optional<PacienteED> findPacienteById(Long id);

    List<PacienteED> findAllPacientesByIsAtivo(Boolean isAtivo);

    List<PacienteED> findAllPacientesByNomeContainingIgnoreCase(@Param("nome") String nome);

    @Query("SELECT p FROM com.cuidar.domain.model.paciente.PacienteED p JOIN p.exames e WHERE LOWER(e.nomeExame) LIKE %:nomeExame%")
    List<PacienteED> findAllPacientesBynomeExameContainingIgnoreCase(@Param("nomeExame") String nomeExame);

    List<PacienteED> findAllPacientesByEnderecoEndRuaContainingIgnoreCase(@Param("endRua") String endRua);

}
