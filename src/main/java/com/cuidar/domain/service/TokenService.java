package com.cuidar.domain.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.cuidar.domain.model.UsuarioED;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Slf4j
@Service
public class TokenService {
//
//    @Value("${api.security.token.secret}")
//    private String secret;
//
//    public String gerarToken(UsuarioED usuario) {
//        try {
//            var algoritmo = Algorithm.HMAC256(secret);
//            return JWT.create()
//                    .withIssuer("API Instituto Criar")
//                    .withSubject(usuario.getLogin())
//                    .withExpiresAt(dataExpiracao())
//                    .sign(algoritmo);
//        } catch (JWTCreationException exception){
//            throw new RuntimeException("erro ao gerar token jwt", exception);
//        }
//    }
//
//    public String getSubject(String tokenJWT) {
//        try {
//            var algoritmo = Algorithm.HMAC256(secret);
//            return JWT.require(algoritmo)
//                    .withIssuer("API Instituto Criar")
//                    .build()
//                    .verify(tokenJWT)
//                    .getSubject();
//        } catch (JWTVerificationException exception) {
//            throw new RuntimeException("Token JWT inválido ou expirado!");
//        }
//    }
//
//    private Instant dataExpiracao() {
//        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
//    }

}
//}

//    @Value("${api.security.token.secret}")
//    private String secret;
//
//
//    public String gerarToken(UsuarioED usuario){
//        log.info("token application.properties {}", secret);
//        try {
//            var algoritmo = Algorithm.HMAC256(secret);
//            return JWT.create()
//                    .withIssuer("API Instituto Criar")
//                    .withSubject(usuario.getLogin())
////                    .withClaim("id", usuario.getId())
//                    .withExpiresAt(dataExiracao())
//                    .sign(algoritmo);
//        } catch (JWTCreationException exception){
//            throw new RuntimeException("Erro ao gerar token jwt", exception);
//        }
//    }
//
//    //valida o token e retorna o subject (login do usuário)
//    public String getSubject(String tokenJWT){
//        try {
//            var algoritmo = Algorithm.HMAC256(secret);
//            return JWT.require(algoritmo)
//                    // specify an specific claim validations
//                    .withIssuer("API Instituto Criar")
//                    // reusable verifier instance
//                    .build()
//                    .verify(tokenJWT)
//                    .getSubject();
//
//        } catch (JWTVerificationException exception){
//           throw new RuntimeException("Token jwt inválido ou expirado!", exception);
//        }
//    }
//
//    private Instant dataExiracao() {
//        //hora atual mais 2HORAS tempo de expiração do token gerado
//        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
//    }
//}
