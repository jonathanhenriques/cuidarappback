package com.cuidar.api.controller;

import com.cuidar.domain.service.EstatisticasQueryService;
import com.cuidar.domain.service.PacienteReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/estatisticas")
public class EstatisticaController {

    @Autowired
    private EstatisticasQueryService estatisticasQueryService;

    @Autowired
    private PacienteReportService pacienteReportService;

    @GetMapping(path = "/quantidade-pacientes"
                , produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> consultarQuantidadePacientes(){
        byte[] bytesPdf = pacienteReportService.emitirQuantidadeDePacientesCadastrados();

        var headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=quantidade-pacientes.pdf");

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_PDF)
                .headers(headers)
                .body(bytesPdf);
    }


}
