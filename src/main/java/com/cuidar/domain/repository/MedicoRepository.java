package com.cuidar.domain.repository;

import com.cuidar.domain.model.MedicoED;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicoRepository extends JpaRepository<MedicoED, Long>,
        JpaSpecificationExecutor<MedicoED> {

    List<MedicoED> findAllByIsAtivo(Boolean valor);
}
