package com.genaws.escolagen.service.serviceImpl;

import com.genaws.escolagen.domain.exception.AlunoNaoEncontradoException;
import com.genaws.escolagen.domain.exception.ProfessorNaoEncontradoException;
import com.genaws.escolagen.domain.model.Aluno;
import com.genaws.escolagen.domain.model.Professor;
import com.genaws.escolagen.domain.model.Sala;
import com.genaws.escolagen.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfessorServiceImpl {

    @Autowired
    ProfessorRepository professorRepository;


    public List<Professor> findAll(){
        return professorRepository.findAll();
    }

//    public Aluno buscarOuFalhar(String alunoCodigo){
//        return alunoRepository.findAlunoByCodigo(alunoCodigo).
//                orElseThrow(() -> new AlunoNaoEncontradoException(alunoCodigo));
//    }

//    public List<Professor> findAllBySala(Sala sala){
//        return professorRepository.findAllBySala(sala);
//    }

    public Professor buscarOuFalhar(Long Id){
        return professorRepository.findById(Id)
                .orElseThrow(() -> new ProfessorNaoEncontradoException(Id.toString()));
    }

    public Professor cadastrar(Professor professor){
        return professorRepository.save(professor);
    }


    @Transactional
    public void ativar(Long Id) {
        buscarOuFalhar(Id).ativar();
//        medicoBuscado.ativar();
//        medicoRepository.save(medico);
    }
    @Transactional
    public void desativar(Long Id) {
        buscarOuFalhar(Id).inativar();
//        medicoRepository.save(medico);
    }
}
