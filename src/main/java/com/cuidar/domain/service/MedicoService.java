package com.cuidar.domain.service;

import com.cuidar.domain.Exceptions.MedicoNaoEncontradoException;
import com.cuidar.domain.model.MedicoED;
import com.cuidar.domain.repository.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

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


    @Transactional
    public void ativar(Long medicoId) {
        buscarOuFalhar(medicoId).ativar();
//        medicoBuscado.ativar();
//        medicoRepository.save(medico);
    }
    @Transactional
    public void desativar(Long medicoId) {
        MedicoED medicoBuscado = buscarOuFalhar(medicoId);
        medicoBuscado.inativar();
//        medicoRepository.save(medico);
    }


    public MedicoED buscarOuFalhar(Long medicoId) {
        return medicoRepository.findById(medicoId)
                .orElseThrow(() -> new MedicoNaoEncontradoException(medicoId));
    }

}
