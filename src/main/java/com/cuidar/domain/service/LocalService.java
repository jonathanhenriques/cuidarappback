package com.cuidar.domain.service;

import com.cuidar.domain.Exceptions.LocalNaoEncontradoException;
import com.cuidar.domain.model.LocalED;
import com.cuidar.domain.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    public List<LocalED> buscarLocais(){
        return localRepository.findAll();
    }

    public LocalED cadastrarLocal(LocalED local){
        return localRepository.save(local);
    }


    public LocalED buscarOuFalhar(Long localId) {
        return localRepository.findById(localId)
                .orElseThrow(() -> new LocalNaoEncontradoException(localId));
    }

    @Transactional
    public Boolean desativarLocal(Long exameId){
        buscarOuFalhar(exameId).desativar();
//        exameRepository.save(exame);
        return true;
    }

    @Transactional
    public Boolean ativarLocal(Long exameId){
        buscarOuFalhar(exameId).ativar();
//        exameRepository.save(exame);
        return true;
    }

}
