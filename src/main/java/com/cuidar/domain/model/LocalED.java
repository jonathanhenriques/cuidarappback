package com.cuidar.domain.model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_LOCAL")
public class LocalED {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME_LOCAL", nullable = false)
    private String nomeLocal;

    @Embedded
    private EnderecoED endereco;

    @Column(name = "IS_ATIVO", nullable = false, length = 9, columnDefinition = "tinyint(1) DEFAULT 1 not null")
    private Boolean isAtivo = Boolean.TRUE;


    public void desativar(){
        this.setIsAtivo(false);
    }

    public void ativar(){
        this.setIsAtivo(true);
    }

}
