package com.genaws.escolagen.service.serviceImpl;

import com.genaws.escolagen.domain.exception.AlunoNaoEncontradoException;
import com.genaws.escolagen.domain.model.Aluno;
import com.genaws.escolagen.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlunoServiceImpl {

    @Autowired
    AlunoRepository alunoRepository;


    public List<Aluno> findAll(){
        return alunoRepository.findAll();
    }

//    public Aluno buscarOuFalhar(String alunoCodigo){
//        return alunoRepository.findAlunoByCodigo(alunoCodigo).
//                orElseThrow(() -> new AlunoNaoEncontradoException(alunoCodigo));
//    }

//    public List<Aluno> findAllBySala(Sala sala){
//        return alunoRepository.findAllBySala(sala);
//    }

    public Aluno buscarOuFalhar(Long alunoId){
        return alunoRepository.findById(alunoId)
                .orElseThrow(() -> new AlunoNaoEncontradoException(alunoId.toString()));
    }

    public Aluno cadastrar(Aluno aluno){
        return alunoRepository.save(aluno);
    }


    @Transactional
    public void ativar(Long alunoId) {
        buscarOuFalhar(alunoId).ativar();
//        medicoBuscado.ativar();
//        medicoRepository.save(medico);
    }
    @Transactional
    public void desativar(Long alunoId) {
        buscarOuFalhar(alunoId).inativar();
//        medicoRepository.save(medico);
    }
}
