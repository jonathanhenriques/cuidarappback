package com.genaws.escolagen.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "GENAWS_TB_SALA")
public class Sala {

//    private UUID codigo;
    private String codigo;

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;


//   @Positive
//   @Column(name = "NUMERO_SALA", nullable = true)
//    private Long numeroSala;

//    @OneToMany
//    private Set<Professor> professores;

//    @OneToMany(mappedBy = "professor", fetch = FetchType.LAZY, cascade = {CascadeType.DETACH})
//    private Set<Sala> salas;

    @ManyToOne
    @JoinColumn(name = "professor_id", referencedColumnName = "id", nullable = true)
    private Professor professor;


    @ManyToOne
    @JoinColumn(name = "aluno_id", referencedColumnName = "id", nullable = true)
    private Aluno aluno;

//
//    @JsonIgnoreProperties(value = {"salasDeAula"}, allowSetters = true)
//    @OneToMany(mappedBy = "sala")
//   private List<Professor> professores;

//    @ManyToMany(mappedBy = "sala")
//    private Set<Aluno> alunos;

//    @ManyToMany(mappedBy = "sala")
//    private Set<Professor> professores;

//    @OneToMany(mappedBy = "sala")
//    private List<Aluno> alunos;



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
