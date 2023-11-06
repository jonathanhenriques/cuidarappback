package com.genaws.escolagen.domain.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "GENAWS_TB_PROFESSOR")
public class Professor {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

//    private UUID codigo;
    private String codigo;


//@Column(name = "nome_professor")
//@NotBlank
//@Size(max = 100, min = 3)
@Column(name = "NOMEPROFESSOR", nullable = false, length = 100)
@JsonAlias({"nomeProfessor", "nomeDoProfessor", "nome_Professor"})
    private String nomeProfessor;
//
//    @ManyToOne
//    @JoinColumn(name = "sala_id")
//    private Sala sala;


//    @ManyToOne
//    @JoinColumn(name = "sala_id", referencedColumnName = "id", nullable = true)
//    private Sala sala;

//    @ManyToMany
//    @JoinTable(
//            name = "professor_sala",
//            joinColumns = @JoinColumn(name = "professor_id"),
//            inverseJoinColumns = @JoinColumn(name = "sala_id")
//    )
//    private Set<Sala> salas;

//    @ManyToMany(mappedBy = "professores")
//    private Set<Aluno> alunos;

//    @OneToMany(mappedBy = "professor")
//    private List<Aluno> alunos;

    @ManyToOne
    @JoinColumn(name = "aluno_id") // Defina o nome da coluna de chave estrangeira
    private Aluno aluno;

//    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
//    private Set<Aluno> alunos;

    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
    private Set<Sala> salas;


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
