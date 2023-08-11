package com.cuidar.api.controller;

import com.cuidar.domain.model.LocalED;
import com.cuidar.domain.repository.LocalRepository;
import com.cuidar.domain.repository.filter.LocalFilter;
import com.cuidar.domain.service.LocalService;
import com.cuidar.infra.repository.spec.AtendenteSpecifications;
import com.cuidar.infra.repository.spec.LocalSpecifications;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/locais")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocalController {

    @Autowired
    private LocalService localService;

    @Autowired
    LocalRepository localRepository;


    @Operation(summary = "Busca um Local por Id")
    @GetMapping(value = "/{LocalId}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public LocalED buscarLocalById(@PathVariable(name = "LocalId") Long LocalId){
        return localService.buscarOuFalhar(LocalId);
    }

    @Operation(summary = "Busca todos os locais filtrados por parametros")
    @GetMapping
    public Page<LocalED> pesquisar(LocalFilter filtro, @PageableDefault(size = 5) Pageable pageable) {
//        Page<LocalED> page = atendenteRepository.findAll(ExameSpecifications.usandoFiltro(filtro), pageable);
        return localRepository.findAll(LocalSpecifications.usandoFiltro(filtro), pageable);
    }

//    @Operation(summary = "atualiza um Local")
//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8")
//    public LocalED atualizarLocal(@Valid @RequestBody LocalED LocalED){
//        return LocalService.atualizarLocal(LocalED);
//    }

    @Operation(summary = "Cadastra um Local")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public LocalED cadastrarLocal(@Valid @RequestBody LocalED LocalED){
        return localService.cadastrarLocal(LocalED);
    }

    @Operation(summary = "Ativar um Local")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/ativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void AtivarLocal(@PathVariable Long id) {
        localService.ativar(id);
    }

    @Operation(summary = "Desativar um Local, delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/desativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void desativarLocal(@PathVariable Long id) {
        localService.desativar(id);
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
