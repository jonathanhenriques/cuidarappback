package com.cuidar.api.controller;

import com.cuidar.domain.model.ExameED;
import com.cuidar.domain.repository.ExameRepository;
import com.cuidar.domain.repository.filter.ExameFilter;
import com.cuidar.domain.service.ExameService;
import com.cuidar.infra.repository.spec.ExameSpecifications;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/exames")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExameController {

    @Autowired
    private ExameService exameService;

    @Autowired
    ExameRepository exameRepository;


    @Operation(summary = "Busca um exame por Id")
    @GetMapping(value = "/{exameId}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public ExameED buscarrExameById(@PathVariable(name = "exameId") Long exameId){
        return exameService.buscarOuFalhar(exameId);
    }

    @Operation(summary = "Busca todos os exames filtrados por parametros")
    @GetMapping
    public List<ExameED> pesquisar(ExameFilter filtro){
        List<ExameED> todosExames = exameRepository.findAll(ExameSpecifications.usandoFiltro(filtro));
        return todosExames;
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


    /**
     * Metodo responsavel por filtrar os parametros  passados na requisicao
     * para seus respectivos correspondentes (existentes no DTO usado)
     *
     */
//    private Pageable traduzirPageable(Pageable apiPageable) {
//        var mapeamento = Map.of(
//                "id", "id"
////                "codigo", "codigo",
////                "subtotal", "subtotal",
////                "taxaFrete", "taxaFrete",
////                "valorTotal", "valorTotal",
////                "dataCriacao", "dataCriacao",
////                "restaurante.nome", "restaurante.nome",
////                "restaurante.id", "restaurante.id",
////                "cliente.id", "cliente.id",
////                "cliente.nome", "cliente.nome"
//        );
//
//        return PageableTranslator.translate(apiPageable, mapeamento);
//    }
}
