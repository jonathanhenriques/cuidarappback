package com.cuidar.domain.repository;


import com.cuidar.domain.model.PacienteED;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteED, Long> {

//    @Query("from PacienteED p join fetch p.exameED")
//    List<PacienteED> findAll();

//    @Query("fom PacienteED where codigo = :codigoPaciente")
    Optional<PacienteED> findPacienteByCodigo(String codigoPaciente);

    Optional<PacienteED> findTop1PacienteByRG(String pacienteRG);

    Page<PacienteED> findAllPacientesByIsAtivo(Boolean isAtivo, Pageable pageable);

    List<PacienteED> findAllPacientesByNomeContainingIgnoreCase(@Param("nome") String nome);

    @Query(value = "SELECT p FROM PacienteED p JOIN p.exames e WHERE LOWER(e.nomeExame) LIKE %:nomeExame%",
            countQuery = "SELECT COUNT(p) FROM PacienteED p JOIN p.exames e WHERE LOWER(e.nomeExame) LIKE %:nomeExame%")
// exemplo   @Query(value = "from Cozinha c join fetch c.restaurantes r where c.nome like :nome",
//            countQuery = "select count(c.id) from Cozinha c where c.nome like :nome")

    List<PacienteED> findAllPacientesBynomeExameContainingIgnoreCase(@Param("nomeExame") String nomeExame);

    List<PacienteED> findAllPacientesByEnderecoEndRuaContainingIgnoreCase(@Param("endRua") String endRua);

}
