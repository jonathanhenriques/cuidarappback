package com.cuidar.infra.security;

import com.cuidar.domain.repository.UsuarioRepository;
import com.cuidar.domain.service.TokenService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class SecurityFilter extends OncePerRequestFilter {
    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository repository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var tokenJWT = recuperarToken(request);

        if (tokenJWT != null) {
            var subject = tokenService.getSubject(tokenJWT);
            var usuario = repository.findByLogin(subject);

            var authentication = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String recuperarToken(HttpServletRequest request) {
        var authorizationHeader = request.getHeader("Authorization");
        if (authorizationHeader != null) {
            return authorizationHeader.replace("Bearer ", "");
        }

        return null;
    }

}
//    @Autowired
//    private TokenService tokenService;
//
//    @Autowired
//    private UsuarioRepository usuarioRepository;
//
//    @Override
//    //filterChain representa a cadeia de filtros. Um filtro precisa chamar o próximo filtro na cadeia, passando a requisição e a resposta.
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        log.info("Filtro de Requisição");
//        var tokenJWT = recuperarToken(request);
//
//        if(tokenJWT != null){
//
//            //pega o email
//            var subject = tokenService.getSubject(tokenJWT);
//            log.info("Subject: {}", subject);
//            //busca o usuário no banco
//            var usuario = usuarioRepository.findByLogin(subject);
//
//            //UsernamePasswordAuthenticationToken é como se fosse um DTO de usuário
//            var authentication = new UsernamePasswordAuthenticationToken(usuario, usuario.getAuthorities());
//            //Coloca o usuário na sessão dizendo que ele está logado
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//        }
//
//        filterChain.doFilter(request, response);
//
//    }
//
//    private String recuperarToken(HttpServletRequest request) {
//        var authorizationHeader = request.getHeader("Authorization");
//        if(authorizationHeader != null){
//            log.info("Token JWT: {}", authorizationHeader);
//            return authorizationHeader.replace("Bearer ", "");
//        }
//
//
//        return null;
//    }
//}
