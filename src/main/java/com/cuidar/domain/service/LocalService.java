package com.cuidar.domain.service;

import com.cuidar.domain.Exceptions.LocalNaoEncontradoException;
import com.cuidar.domain.model.LocalED;
import com.cuidar.domain.repository.LocalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class LocalService {

    @Autowired
    private LocalRepository localRepository;

    public Page<LocalED> buscarLocais(Pageable pageable){
        return localRepository.findAll(pageable);
    }

    public LocalED cadastrarLocal(LocalED local){
        return localRepository.save(local);
    }


    public LocalED buscarOuFalhar(Long localId) {
        return localRepository.findById(localId)
                .orElseThrow(() -> new LocalNaoEncontradoException(localId));
    }

    @org.springframework.transaction.annotation.Transactional
    public void ativar(Long localId) {
//        Objects
//                .requireNonNull(local, "Objeto local passado é null!");
//
//        //TODO: Verificar se o obj esta mudando para true
        buscarOuFalhar(localId).ativar();
//        localRepository.save(local);
    }

    @javax.transaction.Transactional
    public Boolean desativar(Long localId){
        buscarOuFalhar(localId).inativar();
        return true;
    }

}
