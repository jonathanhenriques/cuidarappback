package com.cuidar.domain.repository;

import com.cuidar.domain.model.UsuarioED;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<UsuarioED, Long> {

}
