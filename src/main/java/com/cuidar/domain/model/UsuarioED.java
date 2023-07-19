package com.cuidar.domain.model;

import lombok.*;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_USUARIO")
// UserDetails define os atributos e métodos que o Spring Security usa para autenticar e autorizar usuários
// return true pois não temos regras de negócio para bloquear usuários
public class UsuarioED {


    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "SENHA")
    private String senha;

    @ManyToMany
    @JoinTable(name = "tb_usuario_grupo", joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "grupo_id"))
    private List<GrupoED> grupos = new ArrayList<>();


}

