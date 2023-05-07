package com.cuidar.api.controller;




import com.cuidar.domain.model.dto.DadosAutenticacao;
import com.cuidar.domain.model.usuario.Usuario;
import com.cuidar.infra.security.token.DadosTokenJWT;
import com.cuidar.domain.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;


    @PostMapping
    public ResponseEntity login(@RequestBody @Valid DadosAutenticacao dados){
        //usando o DTO DadosAutenticacao e convertendo para UsernamePasswordAuthenticationToken
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        //usando o AuthenticationManager para autenticar o token (ele chama AutenticacaoService
        var autenticaction = manager.authenticate(authenticationToken);

        var tokenJWT = tokenService.gerarToken((Usuario) autenticaction.getPrincipal());
        //retorna o token dentro do dto DadosTokenJWT
        return ResponseEntity.ok(new DadosTokenJWT(tokenJWT));
    }

}
