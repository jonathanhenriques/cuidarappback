package com.genaws.escolagen.service;

import com.genaws.escolagen.domain.model.Sala;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SalaService {


    public List<Sala> findAll();

    public List<Sala> findAllBySala(Sala sala);

    public Sala buscarOuFalhar(Long salaId);

    public Sala cadastrar(Sala sala);

    @Transactional
    public void ativar(Long salaId);
    @Transactional
    public void desativar(Long salaId);

}
