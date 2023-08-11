package com.cuidar.domain.repository;

import com.cuidar.domain.model.LocalED;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface LocalRepository extends JpaRepository<LocalED, Long>,
        JpaSpecificationExecutor<LocalED> {
}
