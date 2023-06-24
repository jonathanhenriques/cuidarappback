package com.cuidar.domain.service;

import com.cuidar.domain.model.atendente.AtendenteED;
import com.cuidar.domain.model.exame.ExameED;
import com.cuidar.domain.repository.AtendenteRepository;
import com.cuidar.domain.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtendenteRN {

    @Autowired
    private AtendenteRepository atendenteRepository;

    public List<AtendenteED> buscarAtendentes(){
        return atendenteRepository.findAll();
    }
    public AtendenteED buscarAtendenteById(Long atendenteId){
        return atendenteRepository.findById(atendenteId).orElseThrow(() -> new RuntimeException("Atendente Não encontrado: " + atendenteId));
    }

    public AtendenteED cadastrarAtendente(AtendenteED atendente){
        return atendenteRepository.save(atendente);
    }


}
