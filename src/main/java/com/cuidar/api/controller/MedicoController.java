package com.cuidar.api.controller;

import com.cuidar.domain.model.LocalED;
import com.cuidar.domain.model.MedicoED;
import com.cuidar.domain.repository.MedicoRepository;
import com.cuidar.domain.repository.filter.ExameFilter;
import com.cuidar.domain.repository.filter.LocalFilter;
import com.cuidar.domain.repository.filter.MedicoFilter;
import com.cuidar.domain.service.MedicoService;
import com.cuidar.infra.repository.spec.ExameSpecifications;
import com.cuidar.infra.repository.spec.LocalSpecifications;
import com.cuidar.infra.repository.spec.MedicoSpecifications;
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
@RequestMapping(value = "/medicos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class MedicoController {

    @Autowired
    private MedicoService medicoService;

    @Autowired
    MedicoRepository medicoRepository;


    @Operation(summary = "Busca um medico por Id")
    @GetMapping(value = "/{medicoId}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public MedicoED buscarExameById(@PathVariable(name = "medicoId") Long medicoId){
        return medicoService.buscarOuFalhar(medicoId);
    }


    @Operation(summary = "Busca todos os locais filtrados por parametros")
    @GetMapping
    public Page<MedicoED> pesquisar(MedicoFilter filtro, @PageableDefault(size = 5, page = 0) Pageable pageable) {
//        Page<LocalED> page = atendenteRepository.findAll(ExameSpecifications.usandoFiltro(filtro), pageable);
        return medicoRepository.findAll(MedicoSpecifications.usandoFiltro(filtro), pageable);
    }

//    @Operation(summary = "atualiza um medico")
//    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8")
//    public MedicoED atualizarExame(@Valid @RequestBody MedicoED exameED){
//        return medicoService.atualizarMedico(exameED);
//    }

    @Operation(summary = "Cadastra um medico")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public MedicoED cadastrarExame(@Valid @RequestBody MedicoED medicoED){
        return medicoService.cadastrarMedico(medicoED);
    }

    @Operation(summary = "Ativar um Medico, inverte o delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/ativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void ativarMedico(@PathVariable Long id) {

        medicoService.ativar(id);
    }

    @Operation(summary = "Deletar um Medico, delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{id}/desativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void excluirMedico(@PathVariable Long id) {
        medicoService.desativar(id);
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
