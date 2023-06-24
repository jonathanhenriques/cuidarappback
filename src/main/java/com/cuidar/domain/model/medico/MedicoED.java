package com.cuidar.domain.model.medico;

import com.cuidar.domain.model.endereco.EnderecoED;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_MEDICO")
public class MedicoED {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOME", nullable = false)
    private String nome;

    @Column(name = "IS_ATIVO", nullable = false, columnDefinition = "boolean default true")
    private Boolean isAtivo;


}
