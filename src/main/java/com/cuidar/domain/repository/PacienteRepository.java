package com.cuidar.domain.repository;


import com.cuidar.domain.model.PacienteED;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteED, Long> {

//    @Query("fom PacienteED where codigo = :codigoPaciente")
    Optional<PacienteED> findPacienteByCodigo(String codigoPaciente);

    List<PacienteED> findAllPacientesByIsAtivo(Boolean isAtivo);

    List<PacienteED> findAllPacientesByNomeContainingIgnoreCase(@Param("nome") String nome);

    @Query("SELECT p FROM com.cuidar.domain.model.PacienteED p JOIN p.exames e WHERE LOWER(e.nomeExame) LIKE %:nomeExame%")
    List<PacienteED> findAllPacientesBynomeExameContainingIgnoreCase(@Param("nomeExame") String nomeExame);

    List<PacienteED> findAllPacientesByEnderecoEndRuaContainingIgnoreCase(@Param("endRua") String endRua);

}
