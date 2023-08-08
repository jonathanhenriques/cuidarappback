package com.cuidar.api.controller;

import com.cuidar.domain.model.LocalED;
import com.cuidar.domain.repository.LocalRepository;
import com.cuidar.domain.service.LocalService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/locais")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LocalController {

    @Autowired
    private LocalService LocalService;

    @Autowired
    LocalRepository LocalRepository;


    @Operation(summary = "Busca um Local por Id")
    @GetMapping(value = "/{LocalId}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public LocalED buscarLocalById(@PathVariable(name = "LocalId") Long LocalId){
        return LocalService.buscarOuFalhar(LocalId);
    }

    @Operation(summary = "Busca todos os Locals")
    @GetMapping
    public Page<LocalED> buscarLocais(@PageableDefault(size = 5)Pageable pageable){
        return LocalService.buscarLocais(pageable);
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
        return LocalService.cadastrarLocal(LocalED);
    }

    @Operation(summary = "Ativar um Local")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/ativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void AtivarLocal(@PathVariable Long id) {
        LocalService.ativarLocal(id);
    }

    @Operation(summary = "Desativar um Local, delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/desativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void desativarLocal(@PathVariable Long id) {
        LocalService.desativarLocal(id);
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
