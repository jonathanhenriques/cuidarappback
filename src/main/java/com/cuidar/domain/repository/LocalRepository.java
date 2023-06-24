package com.cuidar.domain.repository;

import com.cuidar.domain.model.atendente.AtendenteED;
import com.cuidar.domain.model.local.LocalED;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<LocalED, Long> {
}
