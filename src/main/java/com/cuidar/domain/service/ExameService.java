package com.cuidar.domain.service;

import com.cuidar.domain.Exceptions.*;
import com.cuidar.domain.model.AtendenteED;
import com.cuidar.domain.model.ExameED;
import com.cuidar.domain.model.LocalED;
import com.cuidar.domain.model.MedicoED;
import com.cuidar.domain.model.PacienteED;
import com.cuidar.domain.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Objects;

@Service
public class ExameService {

    @Autowired
    private ExameRepository exameRepository;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private AtendenteService atendenteService;

    @Autowired
    private MedicoService medicoService;

    @Autowired
    private LocalService localService;

    /**
     * @Transactional
     * Garante que todas as operações realizadas no método sejam tratadas como uma única unidade de trabalho.
     * Se alguma operação falhar, a transação pode ser revertida
     *
     * cadastrarExame(ExameEd exame)
     *  Buscar as entidades pelo ID novamente garante que a versão mais recente das entidades seja utilizada,
     *  carregada e persistida junto com o exame
     */
    @Transactional
    public ExameED cadastrarExame(ExameED exame){

        PacienteED paciente = pacienteService.buscarOuFalhar(exame.getPaciente().getCodigo().toString());

        AtendenteED atendente = atendenteService.buscarOuFalhar(exame.getAtendente().getId());

        MedicoED medico = medicoService.buscarOuFalhar(exame.getMedico().getId());

        LocalED local = localService.buscarOuFalhar(exame.getLocal().getId());

        exame.setPaciente(paciente);
        exame.setAtendente(atendente);
        exame.setMedico(medico);
        exame.setLocal(local);


        return exameRepository.save(exame);
    }

    public ExameED atualizarExame(ExameED exame){
        return exameRepository.save(exame);
    }

    @Transactional
    public Boolean cancelarExame(Long exameCodigo){
        buscarOuFalhar(exameCodigo.toString()).inativar();
//        exameRepository.save(exame);
        return true;
    }

//    public ExameED buscarOuFalhar(Long exameId){
//        return exameRepository.findById(exameId).
//                orElseThrow(() -> new ExameNaoEncontradoException(exameId));
//    }

    public ExameED buscarOuFalhar(String exameCodigo){
        return exameRepository.findExameByCodigo(exameCodigo).
                orElseThrow(() -> new ExameNaoEncontradoException(exameCodigo));
    }
}
