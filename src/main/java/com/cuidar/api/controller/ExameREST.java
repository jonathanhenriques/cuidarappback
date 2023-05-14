package com.cuidar.api.controller;

import com.cuidar.domain.model.exame.ExameED;
import com.cuidar.domain.service.ExameRN;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/exames")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExameREST {

    @Autowired
    private ExameRN exameRN;


    @Operation(summary = "atualiza um exame")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public ExameED atualizarExame(@RequestBody ExameED exameED){
        return exameRN.atualizarExame(exameED);
    }
}
