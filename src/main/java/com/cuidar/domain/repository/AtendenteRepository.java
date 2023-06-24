package com.cuidar.domain.repository;

import com.cuidar.domain.model.atendente.AtendenteED;
import com.cuidar.domain.model.exame.ExameED;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtendenteRepository extends JpaRepository<AtendenteED, Long> {

    List<AtendenteED> findAllByIsAtivo(Boolean valor);
}
