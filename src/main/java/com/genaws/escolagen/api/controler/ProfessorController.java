package com.genaws.escolagen.api.controler;

import com.genaws.escolagen.domain.model.Professor;
import com.genaws.escolagen.repository.ProfessorRepository;
import com.genaws.escolagen.service.serviceImpl.ProfessorServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/professores")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProfessorController {

    @Autowired
    ProfessorServiceImpl professorService;

    @Autowired
    ProfessorRepository professorRepository;



    @GetMapping(value = "/testar")
    public String teste(String letras){
        return "funcionouuuuuuu";
    }

    @GetMapping
    public List<Professor> todos(){
        return professorService.findAll();
    }

    @GetMapping(value = "/id/{professorId}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public Professor buscarOuFalhar(@PathVariable("professorId") Long professorId){
        return professorService.buscarOuFalhar(professorId);
    }


    @Operation(summary = "Cadastra um professor")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public Professor cadastrar(@Valid @RequestBody Professor professor){
        return professorService.cadastrar(professor);
    }

    //    @Operation(summary = "Ativar um professor, inverte o delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/ativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void ativar(@PathVariable("id") Long id) {

        professorService.ativar(id);
    }

    //    @Operation(summary = "Desativar um professor, delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/desativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void excluir(@PathVariable("id") Long id) {
        professorService.desativar(id);
    }


}

