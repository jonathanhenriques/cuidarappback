package com.cuidar.domain.service;

import com.cuidar.domain.Exceptions.AtendenteNaoEncontradoException;
import com.cuidar.domain.Exceptions.NegocioException;
import com.cuidar.domain.model.AtendenteED;
import com.cuidar.domain.repository.AtendenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;

@Service
public class AtendenteService {

    @Autowired
    private AtendenteRepository atendenteRepository;

    public Page<AtendenteED> buscarAtendentes(Pageable page){
        return atendenteRepository.findAll(page);
    }

    public AtendenteED cadastrarAtendente(AtendenteED atendente){
        return atendenteRepository.save(atendente);
    }


    public AtendenteED buscarOuFalhar(Long atendenteId) {
        return atendenteRepository.findById(atendenteId)
                .orElseThrow(() -> new AtendenteNaoEncontradoException(atendenteId));
    }

    @Transactional
    public void ativar(AtendenteED atendente) {
        Objects
                .requireNonNull(atendente, "Objeto atendente passado é null!");

        //TODO: Verificar se o obj esta mudando para true
        var atendenteBuscada = buscarOuFalhar(atendente.getId());
        atendenteBuscada.ativar();
//        atendenteRepository.save(atendente);
    }

    @javax.transaction.Transactional
    public Boolean desativar(Long atendenteId){
        buscarOuFalhar(atendenteId).inativar();
        return true;
    }


//    @Transactional
//    public void excluir(AtendenteED atendente) {
//        Objects
//                .requireNonNull(atendente, "Objeto atendente passado é null!");
//
//        //TODO: Verificar se o obj esta mudando para false
//        var atendenteBuscada = buscarOuFalhar(atendente.getId());
//        atendenteBuscada.inativar();
////        atendenteRepository.save(atendente);
//    }

}
