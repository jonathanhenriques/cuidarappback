package com.cuidar.domain.repository;

import com.cuidar.domain.model.usuario.UsuarioED;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepository extends JpaRepository<UsuarioED, Long> {

    UserDetails findByLogin(String login);
}
