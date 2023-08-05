package com.cuidar.domain.repository;

import com.cuidar.domain.model.ExameED;
import com.cuidar.domain.model.PacienteED;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ExameRepository extends JpaRepository<ExameED, Long>, JpaSpecificationExecutor<ExameED> {

    Optional<ExameED> findExameByCodigo(String codigoExame);
}
