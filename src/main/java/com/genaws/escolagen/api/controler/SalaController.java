package com.genaws.escolagen.api.controler;

//import com.genaws.escolagen.service.serviceImpl.SalaServiceImpl;
import com.genaws.escolagen.domain.model.Sala;
import com.genaws.escolagen.service.serviceImpl.SalaServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/salas")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class SalaController {
    @Autowired
    private SalaServiceImpl salaService;

    @GetMapping(value = "/testar")
    public String teste(String letras){
        return "funcionouuuuuuu";
    }

    @GetMapping
    public List<Sala> todos(){
        return salaService.findAll();
    }

    @GetMapping(value = "/id/{salaId}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public Sala buscarOuFalhar(@PathVariable("salaId") Long salaId){
        return salaService.buscarOuFalhar(salaId);
    }


    @Operation(summary = "Cadastra um Sala")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public Sala cadastrar(@Valid @RequestBody Sala sala){
        return salaService.cadastrar(sala);
    }

    //    @Operation(summary = "Ativar um Sala, inverte o delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/ativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void ativar(@PathVariable("id") Long id) {

        salaService.ativar(id);
    }

    //    @Operation(summary = "Desativar um Sala, delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/desativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void excluir(@PathVariable("id") Long id) {
        salaService.desativar(id);
    }


}

