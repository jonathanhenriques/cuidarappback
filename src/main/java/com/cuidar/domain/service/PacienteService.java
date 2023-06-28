package com.cuidar.domain.service;

import com.cuidar.domain.Exceptions.PacienteNotFoundException;
import com.cuidar.domain.model.exame.ExameED;
import com.cuidar.domain.repository.PacienteRepository;
import com.cuidar.domain.model.paciente.PacienteED;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<PacienteED> obterTodosPacientes() {
        return pacienteRepository.findAll();
    }

    public List<PacienteED> obterTodosPacientesAtivos(Boolean isAtivo) {
        return pacienteRepository.findAllPacientesByIsAtivo(isAtivo);
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

    public void deletarLogicoPaciente(Long pacienteId){
        PacienteED pacienteParaDesativar = buscarOuFalhar(pacienteId);
        pacienteParaDesativar.setIsAtivo(false);
        pacienteRepository.save(pacienteParaDesativar);
    }

    public PacienteED buscarOuFalhar(Long pacienteId){
        return pacienteRepository.findById(pacienteId).
                orElseThrow(() -> new PacienteNotFoundException(pacienteId));
    }

}
