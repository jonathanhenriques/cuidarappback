package com.genaws.escolagen.repository;

import com.genaws.escolagen.domain.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    Optional<Aluno> findAlunoByCodigo(String codigoAluno);
//    List<Aluno> findAllBySala(Sala sala);


}
