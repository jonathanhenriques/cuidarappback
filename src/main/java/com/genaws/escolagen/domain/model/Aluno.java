package com.genaws.escolagen.domain.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "GENAWS_TB_ALUNO")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String codigo;

    @NotBlank
    @Size(max = 100, min = 3)
    @Column(name = "NOME", nullable = true, length = 100)
    @JsonAlias({"nome", "nomeAluno", "nome_Aluno", "aluno",})
    private String nome;

    @Positive
    @Column(name = "IDADE", nullable = false)
    private Long idade;

    @PositiveOrZero
    @Column(name = "NOTAPRIMEIROSEMESTRE", nullable = true)

    private Long notaPrimeiroSemestre;

    @PositiveOrZero
    @Column(name = "NOTASEGUNDOSEMESTRE", nullable = true)
    private Long notaSegundoSemestre;

//    @Embedded
//    private Professor nomeProfessor;
//    private String nomeProfessor;


//    @ManyToMany(mappedBy = "alunos")
//    private Set<Professor> professores;

//    @ManyToOne
//    @JoinColumn(name = "professor_id", referencedColumnName = "id", nullable = true)
//    private Professor professor;

//    @ManyToMany
//    @JoinTable(
//            name = "aluno_sala",
//            joinColumns = @JoinColumn(name = "aluno_id"),
//            inverseJoinColumns = @JoinColumn(name = "sala_id")
//    )
//    private Set<Sala> salas;


    @OneToMany(mappedBy = "aluno")
    private List<Professor> professores;

//    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
//    private Set<Professor> professores;

    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    private Set<Sala> salas;

//    @Embedded
//    private Sala numeroSala;
//    private String numeroSala;



//    @ManyToMany
//    @JoinColumn(name = "sala_id")
//    private List<Sala> sala;

//    @ManyToMany
//    private List<Professor> professor;

    @Column(name = "IS_ATIVO", nullable = false, columnDefinition = "boolean default true")
    private Boolean isAtivo;

    public void ativar(){
        this.setIsAtivo(true);
    }

    public void inativar(){
        this.setIsAtivo(false);
    }

    @PrePersist /*antes de criar o registro este metodo e executado*/
    private void gerarUUID(){
        setCodigo(UUID.randomUUID().toString());
    }

}
