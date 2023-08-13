package com.cuidar.api.controller;

import com.cuidar.domain.model.AtendenteED;
import com.cuidar.domain.model.AtendenteED;
import com.cuidar.domain.repository.AtendenteRepository;
import com.cuidar.domain.repository.filter.AtendenteFilter;
import com.cuidar.domain.repository.filter.ExameFilter;
import com.cuidar.domain.service.AtendenteService;
import com.cuidar.infra.repository.spec.AtendenteSpecifications;
import com.cuidar.infra.repository.spec.ExameSpecifications;
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
@RequestMapping(value = "/atendentes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AtendenteController {

    @Autowired
    private AtendenteService atendenteService;

    @Autowired
    AtendenteRepository atendenteRepository;


    @Operation(summary = "Busca um atendente por Id")
    @GetMapping(value = "/{atendenteId}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public AtendenteED buscarAtendenteById(@PathVariable(name = "atendenteId") Long atendenteId){
        return atendenteService.buscarOuFalhar(atendenteId);
    }


//    @Operation(summary = "atualiza um atendente")
//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8")
//    public AtendenteED atualizarAtendente(@Valid @RequestBody AtendenteED atendente){
//        return atendenteService.atualizarAtendente(atendente);
//    }

    @Operation(summary = "Busca todos os atendentes filtrados por parametros")
    @GetMapping
    public Page<AtendenteED> pesquisar(AtendenteFilter filtro, @PageableDefault(size = 5) Pageable pageable) {
//        Page<AtendenteED> page = atendenteRepository.findAll(ExameSpecifications.usandoFiltro(filtro), pageable);
        return atendenteRepository.findAll(AtendenteSpecifications.usandoFiltro(filtro), pageable);
    }

    @Operation(summary = "Cadastra um atendente")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public AtendenteED cadastrarAtendente(@Valid @RequestBody AtendenteED atendente){
        return atendenteService.cadastrarAtendente(atendente);
    }

    @Operation(summary = "Ativar um atendente, inverte o delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/ativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void ativarAtendente(@PathVariable Long id) {

        atendenteService.ativar(id);
    }

    @Operation(summary = "Deletar um atendente, delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/desativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void excluirAtendente(@PathVariable Long id) {
        atendenteService.desativar(id);
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
