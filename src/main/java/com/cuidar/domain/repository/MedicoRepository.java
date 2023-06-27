package com.cuidar.domain.repository;

import com.cuidar.domain.model.atendente.AtendenteED;
import com.cuidar.domain.model.medico.MedicoED;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoED, Long> {

    List<MedicoED> findAllByIsAtivo(Boolean valor);
}