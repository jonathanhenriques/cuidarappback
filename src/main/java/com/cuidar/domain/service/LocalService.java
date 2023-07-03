package com.cuidar.domain.service;

import com.cuidar.domain.Exceptions.LocalNaoEncontradoException;
import com.cuidar.domain.model.LocalED;
import com.cuidar.domain.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    public List<LocalED> buscarAtendentes(){
        return localRepository.findAll();
    }

    public LocalED cadastrarAtendente(LocalED local){
        return localRepository.save(local);
    }


    public LocalED buscarOuFalhar(Long localId) {
        return localRepository.findById(localId)
                .orElseThrow(() -> new LocalNaoEncontradoException(localId));
    }

}
