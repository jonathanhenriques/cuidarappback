package com.cuidar.domain.model.usuario;


import com.cuidar.domain.repository.UsuarioRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService implements UserDetailsService {

        private UsuarioRepository usuarioRepository;

        public AutenticacaoService(UsuarioRepository usuarioRepository) {
            this.usuarioRepository = usuarioRepository;
        }

        @Override
        public UserDetails loadUserByUsername(String username) {
            return usuarioRepository.findByLogin(username);
        }


}
