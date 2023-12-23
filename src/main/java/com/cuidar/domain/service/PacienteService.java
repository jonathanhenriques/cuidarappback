package com.cuidar.domain.service;

import com.cuidar.domain.Exceptions.PacienteNotFoundException;
import com.cuidar.domain.repository.PacienteRepository;
import com.cuidar.domain.model.PacienteED;
import com.cuidar.domain.repository.filter.PacienteFilter;
import com.cuidar.infra.repository.spec.ExameSpecifications;
import com.cuidar.infra.repository.spec.PacienteSpecifications;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private ExameService exameService;

    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Optional<PacienteED> buscarPacienteByCodigo(String codigoPaciente){
        return pacienteRepository.findPacienteByCodigo(codigoPaciente);
    }

    public Optional<PacienteED> buscarPacientePorRG(String pacienteRG){
        return pacienteRepository.findTop1PacienteByRG(pacienteRG);
//                .orElseThrow(() -> new PacienteNotFoundException(pacienteRG.toString()));
    }

    public Page<PacienteED> findAll(PacienteFilter filtro, Pageable pageable){
        return pacienteRepository.findAll(PacienteSpecifications.usandoFiltro(filtro), pageable);
    }

    public Page<PacienteED> obterTodosPacientes(Pageable pageable) {
        return pacienteRepository.findAll(pageable);
    }

    public Page<PacienteED> obterTodosPacientesAtivos(Boolean isAtivo, Pageable pageable) {
        return pacienteRepository.findAllPacientesByIsAtivo(isAtivo, pageable);
    }

    public List<PacienteED> obterTodosPacientesPorNome(String nome) {
        return pacienteRepository.findAllPacientesByNomeContainingIgnoreCase(nome);
    }

    public List<PacienteED> obterTodosPacientesPorExame(String nomeExame) {
        return pacienteRepository.findAllPacientesBynomeExameContainingIgnoreCase(nomeExame);

    }

    public List<PacienteED> obterTodosPacientesPorEndereco(String endRua) {
        return pacienteRepository.findAllPacientesByEnderecoEndRuaContainingIgnoreCase(endRua);

    }


    public PacienteED salvarPaciente(PacienteED pacienteED) {
//        List<ExameED> exames = pacienteED.getExames();
//        pacienteED.setExames(null);

        PacienteED pacienteSalvo = pacienteRepository.save(pacienteED);
//        exames.forEach(exame -> exame.setPaciente(pacienteSalvo));
//        pacienteSalvo.setExames(exames);
//
//        pacienteRepository.save(pacienteSalvo);
        return pacienteSalvo;
    }

    public PacienteED atualizarPaciente(PacienteED pacienteED) {

        return pacienteRepository.save(pacienteED);
    }


    @Transactional
    public void ativar(String pacienteCodigo) {
        buscarOuFalhar(pacienteCodigo).ativar();
//        pacienteRepository.save(paciente);
    }

    @Transactional
    public void desativar(String pacienteCodigo) {
        buscarOuFalhar(pacienteCodigo).inativar();
//        pacienteRepository.save(paciente);
    }

    public PacienteED buscarOuFalhar(String pacienteCodigo){
        return pacienteRepository.findPacienteByCodigo(pacienteCodigo).
                orElseThrow(() -> new PacienteNotFoundException(pacienteCodigo));
    }

}
