package com.cuidar.api.controller;

import com.cuidar.domain.model.ExameED;
import com.cuidar.domain.repository.ExameRepository;
import com.cuidar.domain.repository.filter.ExameFilter;
import com.cuidar.domain.service.ExameService;
import com.cuidar.infra.repository.spec.ExameSpecifications;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping(value = "/exames")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ExameController {

    @Autowired
    private ExameService exameService;

    @Autowired
    ExameRepository exameRepository;


    @Operation(summary = "Busca um exame por código")
    @GetMapping(value = "/{exameCodigo}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public ExameED buscarExameById(@PathVariable(name = "exameCodigo") String exameCodigo){
        return exameService.buscarOuFalhar(exameCodigo);
    }

    @Operation(summary = "Busca todos os exames filtrados por parametros")
    @GetMapping
    public Page<ExameED> pesquisar(ExameFilter filtro,@PageableDefault(size = 5) Pageable pageable) {
//        Page<ExameED> page = exameRepository.findAll(ExameSpecifications.usandoFiltro(filtro), pageable);
        return exameRepository.findAll(ExameSpecifications.usandoFiltro(filtro), pageable);
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


    @Operation(summary = "Ativar um exame,cancela  delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{exameCodigo}/ativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void ativarExame(@PathVariable String exameCodigo) {
        exameService.ativar(exameCodigo);
    }


    @Operation(summary = "Cancelar um exame, delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{exameCodigo}/inativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void cancelarExame(@PathVariable String exameCodigo) {
        exameService.desativar(exameCodigo);
    }



//    @Operation(summary = "Busca um exame por data inicial e data final")
//    @GetMapping(value = "/inicial/{dataInicial}/final/{dataFinal}",
////            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8")
//    public List<ExameED> buscarExamesPorIntervaloDeDatas(@PathVariable(name = "dataInicial") OffsetDateTime dataInicial,
//                                                   @PathVariable(name = "dataFinal") OffsetDateTime dataFinal){
//        return exameService.buscarExamesPorIntervaloDeDatas(dataInicial, dataFinal);
//    }


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
