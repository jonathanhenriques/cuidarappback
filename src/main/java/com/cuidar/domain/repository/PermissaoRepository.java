package com.cuidar.domain.repository;

import com.cuidar.domain.model.PermissaoED;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissaoRepository  extends JpaRepository<PermissaoED, Long> {
}
