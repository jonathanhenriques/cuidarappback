package com.cuidar.api.controller;

import com.cuidar.domain.model.ExameED;
import com.cuidar.domain.service.ExameService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/exames")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExameREST {

    @Autowired
    private ExameService exameService;


    @Operation(summary = "Busca um exame por Id")
    @GetMapping(value = "/{exameId}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public ExameED buscarrExameById(@PathVariable(name = "exameId") Long exameId){
        return exameService.buscarOuFalhar(exameId);
    }

    @Operation(summary = "atualiza um exame")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public ExameED atualizarExame(@Valid @RequestBody ExameED exameED){
        return exameService.atualizarExame(exameED);
    }

    @Operation(summary = "Cadastra um exame")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public ExameED cadastrarExame(@Valid @RequestBody ExameED exameED){
        return exameService.cadastrarExame(exameED);
    }

    @Operation(summary = "Cancelar um exame, delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/ativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void cancelarExame(@PathVariable Long id) {
        exameService.cancelarExame(id);
    }
}
