package com.cuidar.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.cuidar.domain.model.PermissaoED;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_GRUPO")
public class GrupoED {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @ManyToMany
    @JoinTable(name = "tb_grupo_permissao", joinColumns = @JoinColumn(name = "grupo_id"),
            inverseJoinColumns = @JoinColumn(name = "permissao_id"))
    private List<PermissaoED> permissoes = new ArrayList<>();

}