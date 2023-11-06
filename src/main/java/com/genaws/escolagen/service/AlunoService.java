package com.genaws.escolagen.service;

import com.genaws.escolagen.domain.model.Aluno;
import com.genaws.escolagen.domain.model.Sala;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AlunoService {


    public List<Aluno> findAll();

    public List<Aluno> findAllBySala(Sala sala);

    public Aluno buscarOuFalhar(Long alunoId);

    public Aluno cadastrar(Aluno aluno);

    @Transactional
    public void ativar(Long alunoId);
    @Transactional
    public void desativar(Long alunoId);


}
