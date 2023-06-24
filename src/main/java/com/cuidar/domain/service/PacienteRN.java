package com.cuidar.domain.service;

import com.cuidar.domain.Exceptions.PacienteNotFoundException;
import com.cuidar.domain.model.exame.ExameED;
import com.cuidar.domain.repository.PacienteRepository;
import com.cuidar.domain.model.paciente.PacienteED;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteRN {

    @Autowired
    private PacienteRepository pacienteRepository;

    public PacienteRN(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    public Optional<PacienteED> obterPacientePorId(Long id) {
        return pacienteRepository.findPacienteById(id);
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
        List<ExameED> exames = pacienteED.getExames();
        pacienteED.setExames(null);

        PacienteED pacienteSalvo = pacienteRepository.save(pacienteED);
        exames.forEach(exame -> exame.setPaciente(pacienteSalvo));
        pacienteSalvo.setExames(exames);

        pacienteRepository.save(pacienteSalvo);
        return pacienteSalvo;
    }


    public PacienteED atualizarPaciente(PacienteED pacienteED) {

        return pacienteRepository.save(pacienteED);
    }




    public void deletarLogicoPaciente(Long id){
        PacienteED pacienteParaDesativar = pacienteRepository.findPacienteById(id).orElseThrow(() -> new PacienteNotFoundException("Paciente", id));
        pacienteParaDesativar.setIsAtivo(false);
        pacienteRepository.save(pacienteParaDesativar);
    }

}
