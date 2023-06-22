package com.cuidar.domain.model.local;

import com.cuidar.domain.model.endereco.EnderecoED;
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
    private Long id;

    @Column(name = "NOME_LOCAL", nullable = false)
    private String nomeLocal;

    @Embedded
    private EnderecoED endereco;
}
