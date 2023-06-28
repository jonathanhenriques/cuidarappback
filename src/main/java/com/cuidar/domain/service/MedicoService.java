package com.cuidar.domain.service;

import com.cuidar.domain.Exceptions.MedicoNaoEncontradoException;
import com.cuidar.domain.model.atendente.AtendenteED;
import com.cuidar.domain.model.medico.MedicoED;
import com.cuidar.domain.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    @Autowired
    private MedicoRepository medicoRepository;

    public List<MedicoED> buscarAtendentes(){
        return medicoRepository.findAll();
    }

    public MedicoED cadastrarAtendente(MedicoED medico){
        return medicoRepository.save(medico);
    }


    public MedicoED buscarOuFalhar(Long medicoId) {
        return medicoRepository.findById(medicoId)
                .orElseThrow(() -> new MedicoNaoEncontradoException(medicoId));
    }

}
