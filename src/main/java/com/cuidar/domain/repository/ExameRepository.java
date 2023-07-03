package com.cuidar.domain.repository;

import com.cuidar.domain.model.ExameED;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExameRepository extends JpaRepository<ExameED, Long> {
}
