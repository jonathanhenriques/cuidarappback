package com.cuidar.domain.service;

import com.cuidar.domain.model.exame.ExameED;
import com.cuidar.domain.repository.ExameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Service
public class ExameRN {

    @Autowired
    private ExameRepository exameRepository;


    public ExameED atualizarExame(ExameED exame){
        return exameRepository.save(exame);
    }
}
