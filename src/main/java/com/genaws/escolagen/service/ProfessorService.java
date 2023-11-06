package com.genaws.escolagen.service;

import com.genaws.escolagen.domain.model.Aluno;
import com.genaws.escolagen.domain.model.Professor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface ProfessorService {


    public List<Professor> findAll();

//    public List<Professor> findAllBySala(Sala sala);

    public Professor buscarOuFalhar(Long professorId);

    public Professor cadastrar(Professor professor);

    @Transactional
    public void ativar(Long professorId);
    @Transactional
    public void desativar(Long professorId);

}
