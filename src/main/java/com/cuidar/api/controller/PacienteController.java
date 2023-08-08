package com.cuidar.api.controller;



import com.cuidar.domain.Exceptions.PacienteNotFoundException;
import com.cuidar.domain.model.PacienteED;
import com.cuidar.domain.service.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PacienteController {


    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private ModelMapper modelMapper;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @Operation(summary = "Obtem paciente por codigo")
    @GetMapping(path = "/{codigoPaciente}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PacienteED obterPacientePorCodigo(@PathVariable("codigoPaciente") String codigoPaciente) {
        return pacienteService.buscarOuFalhar(codigoPaciente);
    }

    @Operation(summary = "Obtem paciente por RG")
    @GetMapping(path = "/RG/{pacienteRG}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PacienteED obterPacientePorRG(@PathVariable("pacienteRG") String pacienteRG) {
        return pacienteService.buscarPacientePorRG(pacienteRG)
                .orElseThrow(() -> new PacienteNotFoundException(pacienteRG.toString()));
    }

    @Operation(summary = "Obtem paciente por codigo")
    @GetMapping(path = "/{codigoPaciente}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> obterPacientePorCodigoPDF(@PathVariable("codigoPaciente") String codigoPaciente) {
        return null;
    }

    @Operation(summary = "Obtem todos os pacientes")
    @GetMapping(
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public Page<PacienteED> obterTodosPacientes(@PageableDefault(size = 5) Pageable pageable) {
//        pageable = traduzirPageable(pageable);
        return pacienteService.obterTodosPacientes(pageable);
    }


//    @Operation(summary = "Obtem todos os pacientes")
//    @GetMapping(
////            consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8")
//    public ResponseEntity<Page<PacienteED>> obterTodosPacientes(@PageableDefault(size = 5) Pageable pageable) {
////        pageable = traduzirPageable(pageable);
//        return ResponseEntity.ok()
//                //ADICIONANDO CORS MANUALMENTE SOMENTE NESTE ENDPOINT
//                .header(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, "http://localhost:8000")
//                .body(pacienteService.obterTodosPacientes(pageable));
//    }



    @Operation(summary = "Obtem todos os pacientes por isAtivo, true ou falso ")
    @GetMapping(path ="/isAtivo/{isAtivo}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public Page<PacienteED> obterTodosPacientesAtivos(@PathVariable("isAtivo") Boolean isAtivo, Pageable pageable) {
        return pacienteService.obterTodosPacientesAtivos(isAtivo, pageable);
    }

    @Operation(summary = "Obtem todos os pacientes, por nome")
    @GetMapping(path = "/nomePaciente/{nome}",
//            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<PacienteED>> obterTodosPacientesPorNome(@PathVariable("nome") String nome) {
        return ResponseEntity.ok(pacienteService.obterTodosPacientesPorNome(nome));
    }

    @Operation(summary = "Obtem todos os pacientes, por nome do exame")
    @GetMapping(path = "/nomeExame/{nome}",
    //            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<PacienteED>> obterTodosPacientesPorExame(@PathVariable("nomeExame") String nomeExame) {
        return ResponseEntity.ok(pacienteService.obterTodosPacientesPorExame(nomeExame));
    }

    @Operation(summary = "Obtem todos os pacientes, por nome da rua")
    @GetMapping(path = "/nomeRua/{nome}",
    //            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<List<PacienteED>> obterTodosPacientesPorEndereco(@PathVariable("nomeRua") String nomeRua) {
        return ResponseEntity.ok(pacienteService.obterTodosPacientesPorEndereco(nomeRua));
    }


    @Operation(summary = "Cadastra um novo paciente")
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = "application/json;charset=UTF-8")
    public ResponseEntity<PacienteED> cadastrarPaciente(/*@Valid*/ @RequestBody PacienteED pacienteED) {
        return ResponseEntity.ok(pacienteService.salvarPaciente(pacienteED));
    }

    @Operation(summary = "atualiza um paciente")
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = "application/json;charset=UTF-8")
    public ResponseEntity<PacienteED> atualizarPaciente(@Valid @RequestBody PacienteED pacienteED) {
        PacienteED pacienteBanco = pacienteService.buscarOuFalhar(pacienteED.getCodigo().toString());

//        BeanUtils.copyProperties(pacienteBanco, pacienteED,
//                "id", "idade", "endereco","atendente","medicoAtendente","exames","local", "dataCadastro");

        return ResponseEntity.ok(pacienteService.atualizarPaciente(pacienteED));
    }


    @Operation(summary = "Ativar um paciente")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PutMapping(
            path = "/{pacienteCodigo}/ativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
    )
    public void ativarPaciente(@PathVariable String pacienteCodigo) {
        pacienteService.ativar(pacienteCodigo);
    }


    @Operation(summary = "Desativa um paciente, delete lógico")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping(
            path = "/{pacienteCodigo}/ativar"
//            ,consumes = MediaType.APPLICATION_JSON_VALUE,
//            produces = "application/json;charset=UTF-8"
            )
    public void deletePaciente(@PathVariable String pacienteCodigo) {
        pacienteService.desativar(pacienteCodigo);
    }


//    private Pageable traduzirPageable(Pageable apiPageable) {
//        var mapeamento = Map.of(
//                "codigo", "codigo",
//                "id", "id"
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
