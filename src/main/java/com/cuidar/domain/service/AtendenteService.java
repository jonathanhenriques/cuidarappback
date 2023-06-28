package com.cuidar.domain.service;

import com.cuidar.domain.Exceptions.AtendenteNaoEncontradoException;
import com.cuidar.domain.model.atendente.AtendenteED;
import com.cuidar.domain.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendenteService {

    @Autowired
    private AtendenteRepository atendenteRepository;

    public List<AtendenteED> buscarAtendentes(){
        return atendenteRepository.findAll();
    }

    public AtendenteED cadastrarAtendente(AtendenteED atendente){
        return atendenteRepository.save(atendente);
    }


    public AtendenteED buscarOuFalhar(Long atendenteId) {
        return atendenteRepository.findById(atendenteId)
                .orElseThrow(() -> new AtendenteNaoEncontradoException(atendenteId));
    }

}
